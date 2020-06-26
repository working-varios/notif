package com.ito.notifico.lineanegocio.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Builder;

@Getter
@Setter
@Entity
@Table(name = "grupo", uniqueConstraints = @UniqueConstraint(name = "grupo_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE grupo SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(2)")
    private String sigla;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(120) NOT NULL")
    private String nombre;

    @OneToMany(mappedBy = "grupo")
    @Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @Builder.Default
    @JsonManagedReference
    @OrderBy("nombre")
    private Set<SegmentoEntity> segmentos = new HashSet<>();

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}