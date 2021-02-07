package br.com.cpdias.contact.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class IndexController {
    
    @GetMapping(value="/")
    public ModelAndView test(HttpServletResponse response) throws IOException{
        return new ModelAndView("index");
    }
}
