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
public class PedidoDTO {
    private int ID;
    private int mesaId;
    private int camareroId;
    private Date fecha;
    private float total;
}
