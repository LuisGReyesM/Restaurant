package cl.Awakelab.Restaurante.Web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PedidosList {

    @GetMapping
    public  String getInicio(){
        return"pedidosList";
    }

}
