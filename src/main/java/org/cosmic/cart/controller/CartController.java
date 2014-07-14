/**
 * 
 */
package org.cosmic.cart.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Viknes
 *
 */

@Controller
@RequestMapping("/cart")
public class CartController {

	@ResponseBody
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String getItem(HttpServletResponse response) {
		return "Test from Server!";
	}
	
}
