package com.tony.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/spingmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";

	/**
	 * Rest styple URL
	 * 1. Take "CRUD" for example:
	 * Add: /order POST
	 * Modify: /order/1 PUT		update?id=1
	 * Gain: /order/1 GET		get?id=1
	 * Delete: /order/1 DELETE	delete?id=1
	 * 
	 * How to send "PUT", "DELETE" requests?
	 * 1. Need to configure "HiddenHttpMethodFilter"
	 * 2. Need to send "POST" request
	 * 3. Need to send "POST" request with a Hidden attribute: name="_method", value="DELETE" or "PUT"
	 * 
	 * In the target method of SpringMVC, how to get "id"?
	 * Use @PathVariable annotation
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
