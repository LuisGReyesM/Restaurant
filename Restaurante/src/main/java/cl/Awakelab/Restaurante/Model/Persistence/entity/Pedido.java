package cl.Awakelab.Restaurante.Model.Persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="plato")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name ="Mesa_Id")
    private int mesaID;
    @Column(name ="Camarero_Id")
    private int camareroId;
    @Column(name ="Fecha")
    private Date fecha;
    @Column(name ="Total")
    private float total;
}
