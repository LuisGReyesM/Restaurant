package cl.Awakelab.Restaurante.Model.Persistence.mapper;

import cl.Awakelab.Restaurante.Model.Domain.dto.PlatoDTO;
import cl.Awakelab.Restaurante.Model.Persistence.entity.Plato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatoMapper {

    @Mappings({
            @Mapping(source = "ID", target = "ID"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "precio", target = "precio"),
            @Mapping(source = "categoria", target = "categoria"),

    })
    PlatoDTO toPlato(Plato plato);
    List<PlatoDTO> toPlatos(List<Plato> plato);
    @InheritInverseConfiguration
    Plato toPlatodto(PlatoDTO platoDTO);


}
