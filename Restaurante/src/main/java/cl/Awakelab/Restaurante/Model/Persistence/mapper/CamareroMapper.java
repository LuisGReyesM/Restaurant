package cl.Awakelab.Restaurante.Model.Persistence.mapper;

import cl.Awakelab.Restaurante.Model.Domain.dto.CamareroDTO;
import cl.Awakelab.Restaurante.Model.Persistence.entity.Camarero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CamareroMapper {
    @Mappings({
            @Mapping(source = "ID", target = "ID"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "fechaInicio", target = "fechaInicio"),


    })
    CamareroDTO toCamarero(Camarero camarero);
    List<CamareroDTO> toCamareros(List<Camarero> camarero);
    @InheritInverseConfiguration
    Camarero toCamarerodto(CamareroDTO camareroDTO);
}
