package emergon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fiber")
public class FiberController {
    
    @GetMapping
    public String fiber(){        
        return "crud/fiber"; //.jsp
    }
    
}
