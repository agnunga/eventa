//package com.ag.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ag.model.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class LoginController {
//
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
//    System.out.println("Here we are LOGIN SH");
//    ModelAndView mav = new ModelAndView("user");
//    mav.addObject("login.jsp", new User());
//    return mav;
//  }
////  @RequestMapping(value = "/login", method = RequestMethod.GET)
////  public String showLogin(@RequestParam("reqParam") String reqParamValue) {
////    System.out.println("RDRDRD");
////    return "forward:/pages/login.jsp?reqParam="+reqParamValue;
////  }
//  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
//  @ModelAttribute("login") Login login) {
//    ModelAndView mav = null;
//    User user = new User();
//    user.setPhone("khbkjh");
//    if (null != user) {
//    mav = new ModelAndView("welcome");
//    mav.addObject("firstname", "Oloo");
//    } else {
//    mav = new ModelAndView("login");
//    mav.addObject("message", "Username or Password is wrong!!");
//    }
//    return mav;
//  }
//}