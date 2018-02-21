package com.karate.library.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping
    public Map<String, String[]> search(HttpServletRequest request) {
        return request.getParameterMap();
    }

    @PostMapping
    public String echo(@RequestBody String request) {
        return request;
    }

    @RequestMapping(value = "/headers", method = {GET, POST})
    public Map<String, Object> echoHeaders(HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            List<String> list = new ArrayList();
            while (headerValues.hasMoreElements()) {
                String headerValue = headerValues.nextElement();
                list.add(headerValue);
            }
            map.put(headerName.toLowerCase(), list);
        }
        return map;
    }

    @RequestMapping(value = "/cookies", method = {GET, POST})
    public List<Cookie> echoCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return Collections.emptyList();
        } else {
            String domain = request.getParameter("domain");
            for (Cookie cookie: cookies) {
                if (domain != null) {
                    cookie.setDomain(domain);
                }
                response.addCookie(cookie);
            }
            return Arrays.asList(cookies);
        }
    }

}
