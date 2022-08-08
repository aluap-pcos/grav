package com.cinn.grav.service;

import com.cinn.grav.entidades.Perfil;
import com.cinn.grav.entidades.Usuario;
import com.cinn.grav.repositorios.PerfilRepository;
import com.cinn.grav.repositorios.UsuarioRepository;
import com.cinn.grav.utils.exceptions.UsuarioJaExiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder encoder;


    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(username);

        if(usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }

        throw new UsernameNotFoundException("Email inválido");
    }

    public String authenticate(UsernamePasswordAuthenticationToken login, AuthenticationManager authenticationManager) {
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            return tokenService.gerarToken(authentication);
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Dados inválidos");
        }
    }

    public void criar(Usuario usuario, String perfil) throws UsuarioJaExiste {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getUsername());
        if(optionalUsuario.isPresent()){
            throw new UsuarioJaExiste();
        }
        else {
            usuario.setSenha(encoder.encode(usuario.getPassword()));

            usuario.addPerfil(perfilRepository.findByNome(perfil));

            usuarioRepository.save(usuario);
        }
    }


    public Usuario getUsuario(){
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
