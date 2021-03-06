package com.ito.notifico.lineanegocio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "producto", uniqueConstraints = @UniqueConstraint(name = "producto_uk", columnNames = {"codigo","clase_id"}))
@SQLDelete(sql = "UPDATE producto SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String nombre;

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.REFRESH })
    @JoinColumn(name = "clase_id", columnDefinition = "int4 NOT NULL")
    @JsonBackReference
    private ClaseEntity clase;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}