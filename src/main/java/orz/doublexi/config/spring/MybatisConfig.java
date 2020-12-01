package orz.doublexi.config.spring;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("orz.doublexi.mapper")
public class MybatisConfig {
	@Autowired
	DataSource dataSource;
	@Bean
	public MybatisSqlSessionFactoryBean initSqlSession(){
		MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean;
	}

}
