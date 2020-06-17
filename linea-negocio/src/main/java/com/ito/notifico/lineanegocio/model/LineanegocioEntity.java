package com.ito.notifico.lineanegocio.model;


import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Builder;

@Getter
@Setter
@Entity
@Table(name = "lineanegocio")
@SQLDelete(sql = "UPDATE lineanegocio SET eliminado = current_date WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class LineanegocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "VARCHAR(12) NULL")
    private String codigo;

    @Column(name = "usuarioid")
    private int usuarioid;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String descripcion;

    @Column(name="montominimo", columnDefinition = "bigint")
    private BigInteger montoMinimo;

    @Column(name="montomaximo", columnDefinition = "bigint")
    private BigInteger montoMaximo;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}