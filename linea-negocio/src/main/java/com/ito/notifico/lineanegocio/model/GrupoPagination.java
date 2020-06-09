package com.ito.notifico.lineanegocio.model;

import com.ito.notifico.lineanegocio.dto.GrupoDto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GrupoPagination extends PagingAndSortingRepository<GrupoDto,Integer> {
}
