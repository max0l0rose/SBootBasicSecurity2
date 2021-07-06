package rc.bootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    //
//	@Override
//	public void onStartup(ServletContext aServletContext) throws ServletException
//	{
//		registerHiddenFieldFilter(aServletContext);
//	}

//	@Bean
//	public XmlWebApplicationContext qqq(ServletContext container) {
//		XmlWebApplicationContext context = new XmlWebApplicationContext();
//		context.setConfigLocation("applicationContext.xml");
//		return context;
//	}


	@Override
	public void onStartup(ServletContext container) throws ServletException {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("applicationContext.xml");
		context.setServletContext(container);

		System.out.println("--- MyWebApplicationInitializer ---");
	}


	//	private void registerHiddenFieldFilter(ServletContext aContext) {
//		aContext.addFilter("hiddenHttpMethodFilter", new     HiddenHttpMethodFilter())
//				.addMappingForUrlPatterns(null ,true, "/*");
//	}
}
