package com.cinn.grav.utils.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
    private String email;
    private String senha;

    public LoginForm(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public LoginForm() {
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UsernamePasswordAuthenticationToken converter(){
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
