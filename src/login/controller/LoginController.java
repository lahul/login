package login.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.nio.channels.FileChannel;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mysql.cj.jdbc.Blob;

import login.memberdetails.Member;
import login.service.MemberService;

@Controller
public class LoginController {

	public List<String> details=new ArrayList<String>();

	Member mem=new Member();
	
	@Autowired
	MemberService ms=new MemberService();
	
	@RequestMapping("/")
	public String showsignup() {
		return "signup";
	}
	
	@RequestMapping("welcome")
	public String processsignup(HttpServletRequest request,Model model) {
	/*details.add(request.getParameter("email"));
	details.add(request.getParameter("password"));
	details.add(request.getParameter("username"));
	details.add(request.getParameter("dob"));
	details.add(request.getParameter("gender"));
	details.add(request.getParameter("qualification"));*/
	
	String email=request.getParameter("email");	
	String password=request.getParameter("password");
	String username=request.getParameter("username");
	String dob=request.getParameter("dob");
	String gender=request.getParameter("gender");
	String qualification=request.getParameter("qualification");
		
	mem.setEmail(email);
	mem.setPassword(password);
	mem.setUsername(username);
	mem.setDob(dob);
	mem.setGender(gender);
	mem.setQualification(qualification);
	
	details.add(email);
	details.add(password);
	details.add(username);
	details.add(dob);
	details.add(gender);
	details.add(qualification);
	
	model.addAttribute("detail",details);
	int id=ms.insert(mem);
	if(id==1) {
	return "welcome";
	}
	else if(id==0){
		return "error";
	}
	else {
		return "loginerror";
	}
	}

	@RequestMapping("loginpage")
	public String showloginpage() {
		return "login";
	}
	
	@RequestMapping("loginprocess")
	public String processinglogin(HttpServletRequest request,Model model,HttpSession session) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean id=ms.check(username,password);
		if(id) {
			model.addAttribute("username",username);
			session=request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(120);
			return "loginsuccess";
		}
		else {
			return "error";
		}
		}
	@RequestMapping("logout")
	public String logoutprocess(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "login";
	}
	@RequestMapping("profile")
	public String showprofile(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession(false);
		if(session!=null&&session.getAttribute("username")!=null) {
			String test=(String) session.getAttribute("username");
			List<Member> orgs=ms.retrieve(test);
			model.addAttribute("orgs",orgs);
			return "profile";
		}
		else
			return "login";
	}
	@RequestMapping("uploadpic")
	public String showpic(Model model,HttpServletRequest request,HttpSession session) throws IOException {
		String img=(String) request.getParameter("img");
		File f=new File(img);
		String file1=f.getName();
		String dest="C:\\Users\\LAHUL\\eclipse-workspace\\login\\WebContent\\resources\\"+file1;
		File f2=new File(dest);
		Files.copy(f.toPath(), f2.toPath(),StandardCopyOption.REPLACE_EXISTING);
		String username=(String) session.getAttribute("username");
		boolean val=ms.upload(file1,username);
		List<Member> orgs=ms.retrieve(username);
		model.addAttribute("orgs",orgs);
		return "profile";
	}
}
