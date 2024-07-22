package com.example.gestionerroreswebapp;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    //Por simplicidad usamos esta vez @autowired
    @Autowired
    ProductService service;

    /*
    GET http://localhost:8080/products/new
     */
    @GetMapping("/products/new")
    public String getForm(Model model){
        model.addAttribute("product", new Product());
        return "productForm";

    }

    /*
    POST http://localhost:8080/products
     */
    @PostMapping("/products")
    public String createProduct(Model model, @Valid Product product, BindingResult validation){
        //Validaciones personalizadas....
        //....

        //Validaciones de Spring
        if (validation.hasErrors())
            return "productForm";

        System.out.println(product);

        //Guardar en base de datos
        model.addAttribute("product", product);

        /*
        Descomentar los errores que deseamos probar
         */
        //service.findById(1L);
        //service.save(product);

            return "productInfo";
    }
}
