package com.ito.notifico.lineanegocio.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(name = "usuario_uk", columnNames = "nombre"))
@SQLDelete(sql = "UPDATE usuario SET eliminado = current_date WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "eliminado is  null")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(12) NOT NULL")
    private String username;

    @Column(columnDefinition = "VARCHAR(12) NOT NULL")
    private String password;

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
