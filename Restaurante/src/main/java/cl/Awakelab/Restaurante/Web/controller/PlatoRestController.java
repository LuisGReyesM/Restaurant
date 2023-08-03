package cl.Awakelab.Restaurante.Web.controller;

import cl.Awakelab.Restaurante.Model.Domain.dto.PlatoDTO;
import cl.Awakelab.Restaurante.Web.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plato")
public class PlatoRestController {
    private final PlatoService service;

    public PlatoRestController(PlatoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlatoDTO>> findAll(){
        return service.findAll()
                .map(platoDTO -> new ResponseEntity<>(platoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{platoId}")
    public ResponseEntity<PlatoDTO> findById(@PathVariable int platoId){
        return service.findById(platoId)
                .map(platoDTO -> new ResponseEntity<>(platoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/create")
    public ResponseEntity<PlatoDTO> create(@RequestBody PlatoDTO platoDTO){
        return service.create(platoDTO)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));    }

    @PatchMapping("/update")
    public ResponseEntity<PlatoDTO> update(@RequestBody PlatoDTO platoDTO){
        return service.update(platoDTO)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{platoId}")
    public ResponseEntity<Boolean> delete(@PathVariable int platoId){
        return new ResponseEntity<Boolean>(service.delete(platoId), HttpStatus.OK);
    }


}
