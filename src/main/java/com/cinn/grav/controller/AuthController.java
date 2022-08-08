package com.cinn.grav.controller;

import com.cinn.grav.entidades.UsuarioGestante;
import com.cinn.grav.service.AuthService;
import com.cinn.grav.service.GestanteService;
import com.cinn.grav.service.TokenService;
import com.cinn.grav.utils.exceptions.UsuarioJaExiste;
import com.cinn.grav.utils.form.CadastroGestanteForm;
import com.cinn.grav.utils.dto.GestanteDTO;
import com.cinn.grav.utils.dto.TokenDTO;
import com.cinn.grav.utils.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @Autowired
    private GestanteService gestanteService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginForm form){
        UsernamePasswordAuthenticationToken login = form.converter();

        try{
            String token = authService.authenticate(login, authenticationManager);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/cadastro/gestante")
    public ResponseEntity<GestanteDTO> cadastroGestante(@RequestBody CadastroGestanteForm form){
        try{
            UsuarioGestante gestante = form.converter(authService, gestanteService);
            return ResponseEntity.ok(new GestanteDTO(gestante));
        }catch (UsuarioJaExiste e){
            return ResponseEntity.badRequest().build();
        }
    }
}
