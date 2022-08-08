package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.UsuarioGestante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioGestanteRepository extends JpaRepository<UsuarioGestante, Integer> {
    UsuarioGestante findByEmail(String email);
}
