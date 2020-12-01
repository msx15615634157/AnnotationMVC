package orz.doublexi.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import orz.doublexi.config.mvc.ServletConfig;
import orz.doublexi.config.spring.RootConfig;

import javax.servlet.*;
import java.util.EnumSet;

public class InitConfg extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{ServletConfig.class};
	}

	@Override
	protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		return super.registerServletFilter(servletContext, filter);
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"*.do"};
	}


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", new CharacterEncodingFilter());
		characterEncoding.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true, "/*");

		super.onStartup(servletContext);
	}
}
