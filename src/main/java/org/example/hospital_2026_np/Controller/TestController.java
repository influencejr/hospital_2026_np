package org.example.hospital_2026_np.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hello", "Hospital 2026 NP");
        return "index";
    }

}
