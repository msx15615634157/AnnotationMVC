package orz.doublexi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import orz.doublexi.pojo.TestBean;

@Configuration
@PropertySource("classpath:setting.properties")
@ComponentScan(value="orz.*",excludeFilters={@Filter(type=FilterType.ANNOTATION,classes={})})
public class RootConfig {
	@Autowired
	Environment env;
	@Bean
	public TestBean initBean(){
		
		String property = env.getProperty("name");
		TestBean testBean = new TestBean();
		testBean.setName(property);
		
	return testBean;	
	}

}
