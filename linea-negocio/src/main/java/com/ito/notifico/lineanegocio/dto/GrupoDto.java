package com.ito.notifico.lineanegocio.dto;

import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

public class GrupoDto {
    private int id;

    private String codigo;

    private String nombre;

    private Boolean activo = true;

    private Date eliminado = new Date("1970/01/01");
}
