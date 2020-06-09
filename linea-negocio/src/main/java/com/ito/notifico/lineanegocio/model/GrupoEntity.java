package com.ito.notifico.lineanegocio.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "GRUPO")
@SQLDelete(sql = "UPDATE EQUIPO SET ELIMINADO = SYSDATE WHERE ID = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ELIMINADO = TO_DATE('01-01-1970','DD-MM-YYYY')")
public class GrupoEntity {

    @Id
    @SequenceGenerator(name = "GRUPO_SEQUENCE", sequenceName = "GRUPO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPO_SEQUENCE")
    @Column(name = "ID", columnDefinition = "NUMBER(10,0)")
    private int id;

    @Column(unique=true, length=20)
    private String codigo;
    @Column(unique=true, length=100)
    private String nombre;

    /** The activo. */
    @Column(name = "ACTIVO", columnDefinition = "NUMBER (1,0) DEFAULT 1 NOT NULL")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "ELIMINADO", columnDefinition = "TIMESTAMP(6) DEFAULT TO_DATE('01-01-1970','DD-MM-YYYY') NOT NULL")
    @Builder.Default
    private Date eliminado = new Date("1970/01/01");

}