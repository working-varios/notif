package com.ito.notifico.lineanegocio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departamento", uniqueConstraints = @UniqueConstraint(name = "departamento_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE departamento SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(2) NOT NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(8) NOT NULL")
    private String sigla;

    @Column(columnDefinition = "VARCHAR(160) NOT NULL")
    private String nombre;

    @OneToMany(mappedBy = "departamento")
    @Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @Builder.Default
    @JsonManagedReference
    @OrderBy("nombre")
    private Set<MunicipioEntity> municipios = new HashSet<>();

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;
}