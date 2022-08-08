package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByDataConsultaBetweenAndGestanteId(LocalDate inicio, LocalDate fim, Integer gestanteId);
}
