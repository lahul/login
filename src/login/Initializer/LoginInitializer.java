package login.Initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoginInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(LoginConfig.class);
		ServletRegistration.Dynamic reg=arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
		reg.addMapping("/");
		reg.setLoadOnStartup(1);
	}

}
