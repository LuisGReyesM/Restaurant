package cl.Awakelab.Restaurante.Model.Domain.services;


import cl.Awakelab.Restaurante.Model.Domain.dto.PedidoDTO;

import cl.Awakelab.Restaurante.Model.Persistence.mapper.PedidoMapper;

import cl.Awakelab.Restaurante.Model.Persistence.repository.PedidoRepository;
import cl.Awakelab.Restaurante.Web.service.PedidoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoServiceImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Optional<List<PedidoDTO>> findAll() {
        return Optional.of(mapper.toPedidos(repository.findAll()));
    }
    @Override
    public Optional<PedidoDTO> findById(int id) {
        return repository.findById(id).map(mapper::toPedido);
    }
}
