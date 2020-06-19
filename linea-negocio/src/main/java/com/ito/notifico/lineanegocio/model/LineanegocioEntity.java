package com.ito.notifico.lineanegocio.model;


import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Builder;

@Getter
@Setter
@Entity
@Table(name = "lineanegocio", uniqueConstraints = @UniqueConstraint(name = "lineanegocio_uk", columnNames = "nombre"))
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

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.REFRESH })
    @JoinTable(name = "linea_negocio_modalidad",
            joinColumns = @JoinColumn(name = "linea_negocio_id", columnDefinition = "int4"),
            inverseJoinColumns = @JoinColumn(name = "modalidad_id", columnDefinition = "int4"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"linea_negocio_id","modalidad_id"})})
    @Builder.Default
    private Set<ModalidadEntity> modalidades = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.REFRESH })
    @JoinTable(name = "linea_negocio_ubicacion",
            joinColumns = @JoinColumn(name = "linea_negocio_id", columnDefinition = "int4"),
            inverseJoinColumns = @JoinColumn(name = "ubicacion_id", columnDefinition = "int4"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"linea_negocio_id","ubicacion_id"})})
    @Builder.Default
    private Set<UbicacionEntity> ubicaciones = new HashSet<>();

}