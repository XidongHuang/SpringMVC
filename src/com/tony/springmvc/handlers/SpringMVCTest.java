package com.tony.springmvc.handlers;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tony.springmvc.entities.User;

@SessionAttributes(value={"user"}, types={String.class})
@RequestMapping("/spingmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";

	@RequestMapping("/testRedirect")
	private String testRedirect(){
		System.out.println("testRedirect");
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/testView")
	public String testView(){
		
		System.out.println("testView");
		
		return "helloView";
	}
	
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		
		System.out.println("testViewAndViewResolver");
		
		return SUCCESS;
	}
	
	
	/**
	 * 1. If a method is marked "@ModelAttribute", then SpringMVC will invoke it before every target method
	 * 2. @ModelAttribute also can be used in target method's POJO arguments, its "value" will be:
	 * a) SpringMVC will use its "value" for searching the right object in implicitModel, if it exists then will pass into the target method's argument
	 * b) SpringMVC put "POJO" object into request, and the object's key is the "value"
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map){
		if(id != null){
			System.out.println("modelAttribute method");
			User user = new User(1, "Tom", "123456", "tom@gmail.com", 12);
			System.out.println("Get an Object from database: " + user);
			map.put("user", user);
		}
		
		
	}
	
	/**
	 * Process details:
	 * 1. Execute @ModelAttribute annotation method: Take object from data base, put object into Map. Key: user
	 * 2. SpringMVC take User object from Map, and assign parameters of form to User object
	 * 3. SpringMVC transfer the object to target method as arguments
	 * 
	 * notice: In @ModelAttribute method, the "key" in the map has to same the argument's name (lower-case for first letter) in target method
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		
		System.out.println("Modify: "+ user );
		
		
		return SUCCESS;
	}
	
	
	/**
	 * @SessionAttributes can a object into session attribute by setting its name, 
	 * also can specific the class type to do that (notice: the Annotation just can be set in on the top of class) 
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map){
		
		User user  = new User("Tom", "123456","Tom@gmail.com",15);
		map.put("user", user);
		map.put("school","Tony");
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 
	 * Target method can add Map type(or Model or ModelMap types)
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("Tom","Jerry", "Mike"));
		
		
		return SUCCESS;
	}
	
	
	
	/**
	 * The return value of target method can be ModelAndView.
	 * It includes model and view information
	 * SpringMVC will put ModelAndView's model data into request object
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//Add model data into ModelAndView
		modelAndView.addObject("time", new Date());
		
		return modelAndView;
	}
	
	/**
	 * SpringMVC supports original APIs to be arguments:
	 * 
	 * HttpServletRequest, HttpServletResponse, HttpSession
	 * java.security.Principal, Local, InputStream, OutputStream, Reader, Writer
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException{
		
		System.out.println("testServletAPI: " + request +", " + response);
		out.write("Hello SpringMVC");
		
//		return SUCCESS;
	}
	
	
	/**
	 * SpringMVC can assign values in corresponding POJO
	 * also with cascade attributes
	 * 
	 * @param user
	 * @return
	 */
	
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);

		return SUCCESS;
	}

	/**
	 * 
	 * @CookieValue: mapping on Cookie value. Similar with @RequestParam
	 * 
	 * @param sessionId
	 * @return
	 */

	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String sessionId) {

		System.out.println("testCookieValue: sessionId: " + sessionId);
		return SUCCESS;
	}

	/**
	 * Similar with @RequestParam
	 * 
	 * 
	 * @param al
	 * @return
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {

		System.out.println("testRequestHeader, Accept-Language: " + al);

		return SUCCESS;

	}

	/**
	 * @RequestParam for mapping parameters value: the name of parameters
	 *               required: The parameter is required or not. Default value
	 *               is "true" defaultValue: Setting parameters' default value
	 * 
	 * @param un
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam, username:" + un + ", age: " + age);

		return SUCCESS;
	}

	/**
	 * Rest styple URL 1. Take "CRUD" for example: Add: /order POST Modify:
	 * /order/1 PUT update?id=1 Gain: /order/1 GET get?id=1 Delete: /order/1
	 * DELETE delete?id=1
	 * 
	 * How to send "PUT", "DELETE" requests? 1. Need to configure
	 * "HiddenHttpMethodFilter" 2. Need to send "POST" request 3. Need to send
	 * "POST" request with a Hidden attribute: name="_method", value="DELETE" or
	 * "PUT"
	 * 
	 * In the target method of SpringMVC, how to get "id"? Use @PathVariable
	 * annotation
	 * 
	 * @return
	 */

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	private String testRest() {

		System.out.println("testRest POST");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	private String testRestDelete(@PathVariable Integer id) {

		System.out.println("testRest DELETE: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	private String testRestPut(@PathVariable Integer id) {

		System.out.println("testRest PUT: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	private String testRest(@PathVariable Integer id) {

		System.out.println("testRest GET: " + id);
		return SUCCESS;
	}

	/**
	 * 
	 * @PathVariable can map URL's placeholders into target methods' arguments
	 * @param id
	 * @return
	 */

	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {

		System.out.println("testPathVariable: " + id);

		return SUCCESS;

	}

	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {

		System.out.println("testAntPath");
		return SUCCESS;

	}

	/**
	 * 
	 * Can use "params" and "headers" to specific request mapping. They support
	 * simple expression
	 * 
	 * @return
	 */
	@RequestMapping(value = "testParamsAndHeaders", params = { "username", "age!=10" }, headers = {
			"Accept-Language=en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4" })
	public String testParamsAndHeader() {

		System.out.println("testParamsAndHeaders");

		return SUCCESS;
	}

	/**
	 * Set "method" to specific request method
	 * 
	 * @return
	 */

	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {

		System.out.println("testMethod");

		return SUCCESS;
	}

	/**
	 * 1. @RequestMapping can for class and method
	 * 
	 * 
	 * @return
	 */

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {

		System.out.println("testRequestMapping");

		return SUCCESS;

	}

}
