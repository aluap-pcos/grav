package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    Perfil findByNome(String nome);
}
