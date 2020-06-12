package com.ito.notifico.lineanegocio.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Table(name = "lineanegocio")
@SQLDelete(sql = "UPDATE lineanegocio SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class LineanegocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "VARCHAR(10)")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(30)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(500)")
    private String descripcion;

//    @Column(columnDefinition = "bigint")
//    private BigInteger montoinicial;
//
//    @Column(columnDefinition = "bigint")
//    private BigInteger montofinal;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}