package com.ifal.usandocookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class CookieController{
    
@GetMapping ( "/" )
public  String  readCookie ( @CookieValue ( value  =  "username" , defaultValue  =  "SEM" ) String  username ) {
    if(username.equals("SEM")){
        return "não contem nome!!!!!!!";
    }
    return  "Olá! Meu nome de usuário é " +  username ;

}

@GetMapping("/cadastro")
public ModelAndView cadastro(){
    ModelAndView mv = new ModelAndView("Cookies.html");
    return mv;
}

@GetMapping("/change-username")
public String setCookie(HttpServletResponse response, String name) {
    // create a cookie
    Cookie cookie = new Cookie("username", name);
    //add cookie to response
    response.addCookie(cookie);
    return "Nome do usuario foi enviado no Cookies!";
}






}

