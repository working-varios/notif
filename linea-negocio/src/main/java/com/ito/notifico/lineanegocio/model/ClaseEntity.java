package com.ito.notifico.lineanegocio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clase", uniqueConstraints = @UniqueConstraint(name = "clase_uk", columnNames = {"nombre", "codigo","familia_id"}))
@SQLDelete(sql = "UPDATE clase SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class ClaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String nombre;

    @OneToMany(mappedBy = "clase")
    @Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @Builder.Default
    @JsonManagedReference
    @OrderBy("nombre")
    private Set<ProductoEntity> productos = new HashSet<>();

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.REFRESH })
    @JoinColumn(name = "familia_id", columnDefinition = "int4 NOT NULL")
    @JsonBackReference
    private FamiliaEntity familia;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}