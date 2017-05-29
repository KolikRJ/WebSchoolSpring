package ru.work.web.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;

import ru.work.web.LoginController;
import ru.work.web.object.User;

@ContextConfiguration("classpath:root-context.xml")
public class SpringTest extends AbstractTestNGSpringContextTests {
	
	LoginController controller = new LoginController();
	
	@Test
	public void testHome() throws Exception {
		ModelAndView mav = controller.home();
		Map<?, ?> map = mav.getModel();
		Assert.isInstanceOf(User.class, map.get("user"));
	}
	
	@Test
	public void testApplicationContext() throws Exception {
		ApplicationContext context = applicationContext;
		Assert.notNull(context.getBean("dataSource"));
		Assert.notNull(context.getBean("sessionFactory"));
		Assert.notNull(context.getBean("studentMapper"));
	}
}
