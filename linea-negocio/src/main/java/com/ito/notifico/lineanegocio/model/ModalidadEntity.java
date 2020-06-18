package com.ito.notifico.lineanegocio.model;

import java.math.BigInteger;
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
@Table(name = "modalidad", uniqueConstraints = @UniqueConstraint(name = "modalidad_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE modalidad SET eliminado = current_date WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class ModalidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "VARCHAR(12) NULL")
    private String codigo;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String nombre;

    /** The activo. */
    @Column(name = "activo", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Builder.Default
    private Boolean activo = true;

    /** The eliminado. */
    @Column(name = "eliminado")
    private Date eliminado;

}