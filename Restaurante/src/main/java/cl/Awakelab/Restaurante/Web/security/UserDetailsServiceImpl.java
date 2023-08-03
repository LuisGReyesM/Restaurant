package cl.Awakelab.Restaurante.Web.security;


import cl.Awakelab.Restaurante.Model.Persistence.entity.Usuario;
import cl.Awakelab.Restaurante.Model.Persistence.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final LoginRepository repository;
    public UserDetailsServiceImpl(LoginRepository repository){
        this.repository = repository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = repository.findByUsername(username);
        if (user.isPresent()){
            return new RCUserDetails(user.get());
        }

        throw new UsernameNotFoundException("El usuario no existe!");
    }
}

