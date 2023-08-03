package cl.Awakelab.Restaurante.Model.Persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="plato")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name ="Nombre")
    private String nombre;
    @Column(name ="Descripcion")
    private String descripcion;
    @Column(name ="Precio")
    private float precio;
    @Column(name ="Categoria")
    private String categoria;
}

