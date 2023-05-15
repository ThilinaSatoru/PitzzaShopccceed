package Nibm.lk.PitzzaShop.controller;

import Nibm.lk.PitzzaShop.MODEL.Products;
import Nibm.lk.PitzzaShop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ProductController {


    @Autowired
    private ProductsService productService;

    @GetMapping("/product")
    public String showProductPage(Model model) {
        List<Products> listProduct = productService.listAll();
        model.addAttribute("listProduct",listProduct);
        System.out.println("Get / ");
        return "product";
    }

    @GetMapping("/new_product")
    public String add(Model model)
    {
        model.addAttribute("product", new Products());
        return "new_product";
    }

    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Products std){
        productService.saveProducts(std);
        return "redirect:product";
    }

    @RequestMapping("/edits/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("new_product");
        Products std = productService.get(id);
        mav.addObject("product",std);
        return mav;
    }

    @RequestMapping("/deletes/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProducts(id);
        return "redirect:Admin";
    }
}
