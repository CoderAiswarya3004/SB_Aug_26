package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
// @Component
public class HelloController {
    @RequestMapping("/home")
    public void sayHello(PrintWriter writer){
        System.out.println("Hello Web");
        writer.println("<h1>Hello Spring Web</h1> <p>Welcome Home</p>");
    }

    @RequestMapping("/")
    public void landingPage(PrintWriter printWriter){
        System.out.println("landing page1");
        printWriter.println("our First landing page");
    }
    @RequestMapping("/contact")
    public String contact(PrintWriter printWriter){
        return "contact-page";
    }    

     // @RequestMapping("/submit-details")
  // public String submitDetails(HttpServletRequest request, Model model) {
  // System.out.println("Submit Details handled");

  // String name = request.getParameter("name");
  // String phone = request.getParameter("phone");

  // // System.out.println("name is:- " + name);
  // // System.out.println("phone is:- " + phone);

  // model.addAttribute("name1", name);
  // model.addAttribute("phone", phone);

  // return "details-page";
  // }

    @RequestMapping("/submit-details")
    // public String viewDetails(HttpServletRequest request) {
    public String viewDetails(@RequestParam("name1") String Rajesh,@RequestParam("phone") String Phone , Model model) {
    //    String Name = request.getParameter("name");
    //    String Phone = request.getParameter("phone");
    //    System.out.println("Name of submitted user:"+Name+"Phone is :"+Phone);
       System.out.println("Name of submitted user:"+Rajesh+" Phone is :"+Phone);
       model.addAttribute("Name",Rajesh);
       model.addAttribute("callPossible",Phone);
       return "details-page";
    }
    // @RequestMapping("/submit-details")
//   public String submitDetails(@RequestParam(value = "name1") String name1, @RequestParam String phone, Model model) {
//     model.addAttribute("name1", name1);
//     model.addAttribute("phone", phone);

//     return "details-page";
//   }
// }    
}


