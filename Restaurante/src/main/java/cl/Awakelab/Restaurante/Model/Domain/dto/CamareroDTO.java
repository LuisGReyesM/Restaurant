package cl.Awakelab.Restaurante.Model.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CamareroDTO {
    private int ID;
    private String nombre;
    private int edad;
    private Date Fecha_Inicio;
}
