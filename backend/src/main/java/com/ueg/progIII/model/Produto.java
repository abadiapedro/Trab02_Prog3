package com.ueg.progIII.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Produto")
@Table(
        name = "Produtos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_fabricante_unico", columnNames = "fabricante")
        }
)
public @Data class Produto {

    @Id
    @SequenceGenerator(
            name = "produto_id_sequence",
            sequenceName = "produto_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "produto_id_sequence"
    )
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataValidade", nullable = false)
    private Date dataValidade;


    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "fabricante", nullable = false, length = 13)
    private String fabricante;


}
