package com.codigo.GutierrezFernando.service;

import com.codigo.GutierrezFernando.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    EmpresaEntity Crear(EmpresaEntity empresaEntity);
    Optional<EmpresaEntity> BuscarxId(Long id);
    List<EmpresaEntity> BuscarAll();
    EmpresaEntity Actualizar(Long id,EmpresaEntity empresaEntity);
    EmpresaEntity Borrar(Long id);
}
