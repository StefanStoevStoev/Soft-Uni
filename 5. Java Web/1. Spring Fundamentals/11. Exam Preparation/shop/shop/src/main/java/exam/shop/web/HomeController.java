package exam.shop.web;

import exam.shop.model.entities.enums.CategoryEnum;
import exam.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryEnum.DRINK));
        model.addAttribute("food", productService
                .findAllProductsByCategoryName(CategoryEnum.FOOD));
        model.addAttribute("households", productService
                .findAllProductsByCategoryName(CategoryEnum.HOUSEHOLD));
        model.addAttribute("others", productService
                .findAllProductsByCategoryName(CategoryEnum.OTHER));
        return "home";
    }
}
