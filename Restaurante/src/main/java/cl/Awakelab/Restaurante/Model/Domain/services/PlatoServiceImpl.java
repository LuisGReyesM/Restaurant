package cl.Awakelab.Restaurante.Model.Domain.services;

import cl.Awakelab.Restaurante.Model.Domain.dto.PlatoDTO;
import cl.Awakelab.Restaurante.Model.Persistence.mapper.PlatoMapper;
import cl.Awakelab.Restaurante.Model.Persistence.repository.PlatoRepository;
import cl.Awakelab.Restaurante.Web.service.PlatoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlatoServiceImpl  implements PlatoService {

    private final PlatoRepository repository;
    private final PlatoMapper mapper;

    public PlatoServiceImpl(PlatoRepository repository, PlatoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<PlatoDTO>> findAll() {
        return Optional.of(mapper.toPlatos(repository.findAll()));
    }
    @Override
    public Optional<PlatoDTO> findById(int id) {
        return repository.findById(id).map(mapper::toPlato);
    }

    @Override
    public Optional<PlatoDTO> create(PlatoDTO platoDTO)
    {
        return Optional.of(
                mapper.toPlato(
                        repository.save(
                                mapper.toPlatodto(platoDTO)
                        )
                ));
    }
    @Override
    public Optional<PlatoDTO> update(PlatoDTO platoDTO) {
        if (repository.existsById(platoDTO.getID())){
            return Optional.of(
                    mapper.toPlato(
                            repository.save(
                                    mapper.toPlatodto(platoDTO)
                            )
                    ));
        }
        return Optional.of(new PlatoDTO());
    }

    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
