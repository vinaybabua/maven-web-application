package com.mt.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/employee")
public class EmployeeService {

 @Value("${greeter.message}")
 private String greeterMessageFormat;

 @Value("${SQL_DB_URL}")
 private String dbURL;

 @Value("${SQL_DB_USERNAME}")
 private String dbUsername;

 @Value("${SQL_DB_PWD}")
 private String dbPwd;

@Value("${MYNAME}")
String name;
	
	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws JSONException {
                
		JSONObject js = new JSONObject();
		js.put("Name", "Manasa Technologies");
		js.put("Calling Name", name);
		js.put("DOB", "01-Nov-2011");
		js.put("Hobbies", "Reading Technical Books");
		js.put("Places he like", "His native place");

		return js.toString();
}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	String getHello(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws JSONException {
                        System.out.println("Helooooooooooooooooooooooooooooooooo") ;
				return "Hello manasa "+name;

			}
	
  
@RequestMapping(value = "/greet", method = RequestMethod.GET)
@ResponseBody
    String getHello(HttpServletRequest request, HttpServletResponse response)
			throws JSONException {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        
        if (prefix == null) {
            prefix = "Hello!";
        }

	System.out.println("DB URL: "+ dbURL) ;
	System.out.println("DB USERNAME: "+ dbUsername) ;
	System.out.println("DB PWD: "+ dbPwd) ;
        return String.format(greeterMessageFormat, prefix);
    }
}
