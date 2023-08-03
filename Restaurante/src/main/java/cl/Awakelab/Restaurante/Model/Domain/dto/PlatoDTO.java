package cl.Awakelab.Restaurante.Model.Domain.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoDTO {

    private int ID;
    private String nombre;
    private String descripcion;
    private float precio;
    private String categoria;
}
