package cn.hjl.liunxdemo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value = "/hello")
    public String hello(){
        int i = 1/0;

        return "hello";
    }


}
