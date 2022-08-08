package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.UsuarioAnunciante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAnuncianteRepository extends JpaRepository<UsuarioAnunciante, Integer> {
    UsuarioAnunciante findByEmail(String email);
}
