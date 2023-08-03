package cl.Awakelab.Restaurante.Model.Persistence.mapper;

import cl.Awakelab.Restaurante.Model.Domain.dto.PedidoDTO;
import cl.Awakelab.Restaurante.Model.Persistence.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mappings({
            @Mapping(source = "ID", target = "ID"),
            @Mapping(source = "mesaId", target = "mesaId"),
            @Mapping(source = "camareroId", target = "camareroId"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "total", target = "total"),

    })
    PedidoDTO toPedido(Pedido pedido);
    List<PedidoDTO> toPedidos(List<Pedido> pedido);
    @InheritInverseConfiguration
    Pedido toPedidodto(PedidoDTO pedidoDTO);
}
