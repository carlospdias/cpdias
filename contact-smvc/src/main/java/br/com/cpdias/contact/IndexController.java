package br.com.cpdias.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("indexController")
class IndexController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    
    @GetMapping("/")
    ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        LOGGER.info("Exibindo página principal {}.","index");
        mv.setViewName("index");
        
        return mv;
    }
}
