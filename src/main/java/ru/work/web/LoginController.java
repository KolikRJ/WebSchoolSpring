package ru.work.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.work.web.mapper.StudentMapper;
import ru.work.web.object.ListStudents;
import ru.work.web.object.Student;
import ru.work.web.object.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	private StudentMapper mapper;
	private Map<String, Object> object;
	private ListStudents listStudents;
	private ModelAndView mav;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		User user = new User();
		mav = new ModelAndView("login", "user", user);
		return mav;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public ModelAndView list(@ModelAttribute("user") User user) {
		if (user.getLogin().equals("admin") && user.getPassword().equals("admin")) {
			if (object == null) {
				object = new HashMap<String, Object>();
				object.put("user", user);
				listStudents = new ListStudents();
				try {
					listStudents.setStudents(mapper.getAllStudent());
				} catch (Exception e) {
					listStudents.setStudents(null);
				}
				object.put("list", listStudents);
				object.put("student", new Student());
			}
			mav = new ModelAndView("list", object);
			return mav;
		} else {
			mav = new ModelAndView("failed", "user", user);
			return mav;
		}
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView redirect() {
		listStudents.setStudents(mapper.getAllStudent());
		mav = new ModelAndView("list", object);
		return mav;
	}
	
	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		mapper.addStudent(student);
		return "redirect:list";
	}
	
	@RequestMapping(value = "deleteStudent", method = RequestMethod.POST)
	public String deleteStudent(@ModelAttribute("student") Student student) {
		mapper.deleteStudent(student.getId());
		return "redirect:list";
	}
	
	@RequestMapping(value = "updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
		mapper.updateStudent(student);
		return "redirect:list";
	}
}
