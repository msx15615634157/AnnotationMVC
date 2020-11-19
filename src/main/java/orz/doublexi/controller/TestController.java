package orz.doublexi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import orz.doublexi.pojo.TestBean;

@Controller
public class TestController {
	public TestController() {
		System.out.println(this.getClass());
	}
	@Autowired
	TestBean  testBean;
	@RequestMapping("test.do")
public Object test01(){
		System.out.println(testBean.getName());
	return "hello";
}
}
