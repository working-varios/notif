package com.ito.notifico.lineanegocio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "segmento", uniqueConstraints = @UniqueConstraint(name = "segmento_uk", columnNames = {"nombre","grupo_id"}))
@SQLDelete(sql = "UPDATE segmento SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class SegmentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(120) NOT NULL")
    private String nombre;

    @OneToMany(mappedBy = "segmento")
    @Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @Builder.Default
    @JsonManagedReference
    @OrderBy("nombre")
    private Set<FamiliaEntity> familias = new HashSet<>();

    @NotFound(action= NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.REFRESH })
    @JoinColumn(name = "grupo_id", columnDefinition = "int4 NOT NULL")
    @JsonBackReference
    private GrupoEntity grupo;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}