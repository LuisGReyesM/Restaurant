package cl.Awakelab.Restaurante.Model.Domain.services;

import cl.Awakelab.Restaurante.Model.Domain.dto.CamareroDTO;

import cl.Awakelab.Restaurante.Model.Persistence.mapper.CamareroMapper;
import cl.Awakelab.Restaurante.Model.Persistence.repository.CamareroRepository;
import cl.Awakelab.Restaurante.Web.service.CamareroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CamareroServiceImpl implements CamareroService {
    private final CamareroRepository repository;
    private final CamareroMapper mapper;

    public CamareroServiceImpl(CamareroRepository repository, CamareroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Optional<List<CamareroDTO>> findAll() {
        return Optional.of(mapper.toCamareros(repository.findAll()));
    }
    @Override
    public Optional<CamareroDTO> findById(int id) {
        return repository.findById(id).map(mapper::toCamarero);
    }

}
