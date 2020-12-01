package orz.doublexi.config.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import orz.doublexi.pojo.Story;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "orz.*", excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
@Import(value = {PropertiesConfig.class})
public class RootConfig {
	@Autowired
	Environment environment;

	@Bean
	public DataSource initDataSource() {
		System.out.println(environment.getProperty("username"));
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		return dataSource;
	}
	@Bean("limingzhijian")
	public Story initSrource() {
		return new Story("limingzhijian.txt");

	}

}
