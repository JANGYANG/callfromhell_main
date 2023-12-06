package team90s.callfromhell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("main")
@RequestMapping(path = "main")
public class MainController {
    @GetMapping(path = "")
    public String test(){
        return "WELCOME";
    }

}
