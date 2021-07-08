package rc.bootsecurity.security;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import rc.bootsecurity.controller.NumberProvider;

import java.util.Locale;

@Configuration
//@ComponentScan("demospringmvc")
//@EnableWebMvc // -------------- Надо выключить чтобы работали статик ресурсы

//@ImportResource({"classpath:dispatcher1-servlet.xml"})
class WebMvcConfig implements WebMvcConfigurer {


	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}



//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages1");
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}


//	@Bean(name = "messageSource")
//	public ReloadableResourceBundleMessageSource getMessageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("messages1");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setUseCodeAsDefaultMessage(true);
//		return messageSource;
//	}

//	@Bean(name = "messageSource")
//	public ResourceBundleMessageSource getMessageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages1");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setUseCodeAsDefaultMessage(true);
//		return messageSource;
//	}



//	@Bean
//	public NumberProvider numberProvider() {
//		return new NumberProvider();
//	}


//	public LayoutDialect layoutDialect() {
//		TemplateEngine templateEngine = new TemplateEngine();
//		templateEngine.addDialect(new LayoutDialect());
//
//		return new LayoutDialect();
//	}

//	private static final String VIEWS = "/resources/templates/"; //""/WEB-INF/views/";
//
//	@Bean
//	public ITemplateResolver templateResolver() {
//		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//		resolver.setPrefix(VIEWS);
//		resolver.setSuffix(".html");
//		resolver.setTemplateMode(TemplateMode.HTML);
//		resolver.setCharacterEncoding("UTF-8");
//		resolver.setCacheable(false);
//		return resolver;
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.addTemplateResolver(new UrlTemplateResolver());
//		templateEngine.addTemplateResolver(templateResolver());
//		templateEngine.addDialect(new SpringSecurityDialect());
//		templateEngine.addDialect(new LayoutDialect());
//		templateEngine.addDialect(new Java8TimeDialect());
//		return templateEngine;
//	}
}