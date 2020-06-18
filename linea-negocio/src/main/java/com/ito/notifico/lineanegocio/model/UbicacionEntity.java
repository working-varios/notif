package com.ito.notifico.lineanegocio.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Builder;

@Getter
@Setter
@Entity
@Table(name = "ubicacion", uniqueConstraints = @UniqueConstraint(name = "ubicacion_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE ubicacion SET eliminado = SYSDATE WHERE id = ?", check = ResultCheckStyle.COUNT)
public class UbicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(columnDefinition = "VARCHAR(120) NOT NULL")
    private String nombre;

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