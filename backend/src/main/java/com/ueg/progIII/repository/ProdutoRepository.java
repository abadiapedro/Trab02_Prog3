package com.ueg.progIII.repository;

import com.ueg.progIII.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String Nome);

    //JPQL
    @Query("" +
            "SELECT CASE WHEN COUNT(p) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Produto p " +
            "WHERE p.fabricante = ?1"
    )
    Boolean existeFabricante(String fabricante);
}
