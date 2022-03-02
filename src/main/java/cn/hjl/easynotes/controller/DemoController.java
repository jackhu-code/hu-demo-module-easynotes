package cn.hjl.easynotes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jake hu
 * @date 20220130
 * @desc demo controller
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello word!";
    }

}
