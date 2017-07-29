package login.service;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.Blob;

import login.memberdetails.Member;

@Repository
public class MemberService {
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean check(String username,String password) {
		String query="select * from member_details where username=:un and password=:pass";
		HashMap<String,String> namedParameters=new HashMap<>();
		namedParameters.put("un", username);
		namedParameters.put("pass", password);
		List list1=namedParameterJdbcTemplate.queryForList(query,namedParameters);
		if(list1.size()>0) {
			return true;
		}
		else
			return false;
	}
	
	public int insert(Member mem) {
		
		String query1="select *from member_details where email=:email or username=:un";
		HashMap<String,Object> namedParameters1=new HashMap<>();
		namedParameters1.put("email", mem.getEmail());
		namedParameters1.put("un",mem.getUsername());
		List list2=namedParameterJdbcTemplate.queryForList(query1, namedParameters1);
		if(list2.size()>0) {
			return 2;
		}
		else {
		String query2="insert into member_details(email,password,username,dob,gender,qualification) "
				+ "values (:email,:password,:username,:dob,:gender,:qualification)";
		HashMap<String,Object> namedParameters2=new HashMap<>();
		namedParameters2.put("email",mem.getEmail());
		namedParameters2.put("password",mem.getPassword());
		namedParameters2.put("username",mem.getUsername());
		namedParameters2.put("dob",mem.getDob());
		namedParameters2.put("gender",mem.getGender());
		namedParameters2.put("qualification",mem.getQualification());
		boolean i=namedParameterJdbcTemplate.update(query2,namedParameters2)==1;
		if(i==true)
			return 1;
		else
			return 2;
		}
		}
		public List<Member> retrieve(String username) {
			String query="select * from member_details where username=:un";
			HashMap<String,String> hm=new HashMap<>();
			hm.put("un", username);
			List<Member> org=namedParameterJdbcTemplate.query(query, hm, new loginRowmapper());
			return org;
		}
		public boolean upload(String fname,String username) {
			String query="update member_details set image=:fname where username=:un";
			HashMap<String, String> hm=new HashMap<>();
			hm.put("fname", fname);
			hm.put("un",username );
			return namedParameterJdbcTemplate.update(query, hm)==1;
		}
}
