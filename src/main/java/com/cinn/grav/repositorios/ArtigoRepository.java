package com.cinn.grav.repositorios;

import com.cinn.grav.entidades.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer> {
    List<Artigo> findByTema(String tema);

    //List<Artigo> findByAutor(Integer id);


}
