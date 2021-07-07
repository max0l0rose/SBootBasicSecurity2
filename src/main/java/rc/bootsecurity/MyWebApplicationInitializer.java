package rc.bootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//
//class A implements ApplicationContextAware {
//	private ApplicationContext context;
//
//	public void setApplicationContext(ApplicationContext context) {
//		this.context = context;
//	}
//}


//@Configuration
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//    //
////	@Override
////	public void onStartup(ServletContext aServletContext) throws ServletException
////	{
////		registerHiddenFieldFilter(aServletContext);
////	}
//
////	@Bean
////	public XmlWebApplicationContext qqq(ServletContext container) {
////		XmlWebApplicationContext context = new XmlWebApplicationContext();
////		context.setConfigLocation("applicationContext.xml");
////		return context;
////	}
//
//
////	@Override
////	public void onStartup(ServletContext container) throws ServletException {
////		XmlWebApplicationContext context = new XmlWebApplicationContext();
////		context.setConfigLocation("applicationContext.xml");
////		context.setServletContext(container);
////
////		System.out.println("--- MyWebApplicationInitializer ---");
////	}
//
//
//	//	private void registerHiddenFieldFilter(ServletContext aContext) {
////		aContext.addFilter("hiddenHttpMethodFilter", new     HiddenHttpMethodFilter())
////				.addMappingForUrlPatterns(null ,true, "/*");
////	}
//}
