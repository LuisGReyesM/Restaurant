package cl.Awakelab.Restaurante.Web.controller;


import cl.Awakelab.Restaurante.Model.Domain.dto.PedidoDTO;
import cl.Awakelab.Restaurante.Web.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
    private final PedidoService service;

    public PedidoRestController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return service.findAll()
                .map(pedidoDTO -> new ResponseEntity<>(pedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable int pedidoId){
        return service.findById(pedidoId)
                .map(pedidoDTO -> new ResponseEntity<>(pedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
