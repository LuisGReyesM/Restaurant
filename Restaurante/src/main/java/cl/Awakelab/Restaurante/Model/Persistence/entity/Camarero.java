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
public class Camarero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name ="Nombre")
    private String nombre;

    @Column(name ="Edad")
    private int edad;

    @Column(name ="Fecha_Inicio")
    private Date fechaincio;

}
