package edu.lyon1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request, @RequestHeader HttpHeaders headers) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("titre", "IUT");
        mav.addObject("corps", "bonjour");
        mav.setViewName("template");

        List<HttpHeader> headersList = new ArrayList<HttpHeader>();

        for(Map.Entry<String, List<String>> header : headers.entrySet()) {
            headersList.add(new HttpHeader(header.getKey(), header.getValue().toString()));
        }

        mav.addObject("headerNames", headersList);

        return mav;
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    @ResponseBody
    public String testPost() {

        return "OK";
    }

    @RequestMapping(value="/user", method= RequestMethod.GET)
    @ResponseBody
    public User testGetUser(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        return new User(nom, prenom);
    }

    @RequestMapping(value="/browser", method= RequestMethod.GET)
    @ResponseBody
    public UserAgent testGetUserAgent(@RequestHeader HttpHeaders headers) {
        return new UserAgent(headers.get("User-Agent").get(0));
    }


    private class HttpHeader {

        final String name;
        final String value;

        public HttpHeader(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

}
