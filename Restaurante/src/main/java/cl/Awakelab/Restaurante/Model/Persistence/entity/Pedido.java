package cl.Awakelab.Restaurante.Model.Persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="pedido")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name ="Mesa_ID")
    private int mesaId;
    @Column(name ="Camarero_ID")
    private int camareroId;
    @Column(name ="Fecha")
    private Date fecha;
    @Column(name ="Total")
    private float total;
}
