package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Integer> {
    @Query("select a from Anotacao a join Consulta c on c.id = a.consulta where a.consulta = :idConsulta")
    Optional<Anotacao> buscaAnotacaoPorIdConsulta(@Param("idConsulta") Integer idConsulta);
}
