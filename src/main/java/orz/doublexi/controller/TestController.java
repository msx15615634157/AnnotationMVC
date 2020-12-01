package orz.doublexi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class TestController {
	public TestController() {
		System.out.println(this.getClass());
	}
	@Autowired
	DataSource dataSource;
	@RequestMapping("test.do")
	@ResponseBody
public Object test01(){
		System.out.println(dataSource);

	return "hello";
}
}
