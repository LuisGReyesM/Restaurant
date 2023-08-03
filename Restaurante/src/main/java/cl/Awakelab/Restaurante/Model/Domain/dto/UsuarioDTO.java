package cl.Awakelab.Restaurante.Model.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String role;
}
