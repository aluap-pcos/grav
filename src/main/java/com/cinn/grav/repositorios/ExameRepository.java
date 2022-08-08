package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
    @Query("select e from Exame e where e.dataExame between :inicio and :fim order by e.dataExame desc")
    List<Exame> listarExamesNumPeriodoDetempo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}
