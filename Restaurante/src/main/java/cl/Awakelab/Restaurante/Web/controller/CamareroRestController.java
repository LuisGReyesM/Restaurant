package cl.Awakelab.Restaurante.Web.controller;

import cl.Awakelab.Restaurante.Model.Domain.dto.CamareroDTO;
import cl.Awakelab.Restaurante.Web.service.CamareroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camarero")
public class CamareroRestController {
    private final CamareroService service;

    public CamareroRestController(CamareroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CamareroDTO>> findAll(){
        return service.findAll()
                .map(camareroDTO -> new ResponseEntity<>(camareroDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{camareroId}")
    public ResponseEntity<CamareroDTO> findById(@PathVariable int camareroId){
        return service.findById(camareroId)
                .map(camareroDTO -> new ResponseEntity<>(camareroDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
