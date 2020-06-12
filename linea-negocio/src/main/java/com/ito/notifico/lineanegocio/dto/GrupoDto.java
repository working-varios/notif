package com.ito.notifico.lineanegocio.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class GrupoDto {
    private int id;

    private String codigo;

    private String nombre;

    private Boolean activo = true;

    private Date eliminado = new Date("1970/01/01");
}
