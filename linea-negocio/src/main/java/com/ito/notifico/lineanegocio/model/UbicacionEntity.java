package com.ito.notifico.lineanegocio.model;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import lombok.Builder;

@Getter
@Setter
@Entity
@Table(name = "ubicacion", uniqueConstraints = @UniqueConstraint(name = "ubicacion_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE ubicacion SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class UbicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(8) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(120) NOT NULL")
    private String nombre;

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.REFRESH })
    @JoinColumn(name = "departamento_id", columnDefinition = "int4 NOT NULL")
    private DepartamentoEntity departamento;

    /**
     * The activo.
     */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /**
     * The eliminado.
     */
    @Column(name = "eliminado")
    private Date eliminado;

}