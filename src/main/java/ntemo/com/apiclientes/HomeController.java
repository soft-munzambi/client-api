package ntemo.com.apiclientes;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import ntemo.com.apiclientes.providers.services.TypeClientService;

@Controller
public class HomeController {

    final TypeClientService typeClientService;

    public HomeController(TypeClientService typeClientService) {
        this.typeClientService = typeClientService;
    }

    @GetMapping("/")

    public String index(Model model) {

        String name = "Munzambi Miguel";
        model.addAttribute("name", name);

        return "index";
    }
}
