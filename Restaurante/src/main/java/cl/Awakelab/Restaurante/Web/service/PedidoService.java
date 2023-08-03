package cl.Awakelab.Restaurante.Web.service;

import cl.Awakelab.Restaurante.Model.Domain.dto.CamareroDTO;
import cl.Awakelab.Restaurante.Model.Domain.dto.PedidoDTO;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    Optional<List<PedidoDTO>> findAll();
    Optional <PedidoDTO> findById(int id);
}
