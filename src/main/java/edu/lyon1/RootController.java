package edu.lyon1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping("/")
    public ModelAndView test(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "IUT");
    mav.addObject("corps", "bonjour");
    mav.setViewName("template");

    List<String> headers = new ArrayList<String>(Collections.list(request.getHeaderNames()));

    mav.addObject("headerNames", headers);

    return mav;
    }

}
