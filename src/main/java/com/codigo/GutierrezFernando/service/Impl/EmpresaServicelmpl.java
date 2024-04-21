package com.codigo.GutierrezFernando.service.Impl;

import com.codigo.GutierrezFernando.dao.EmpresaRepository;
import com.codigo.GutierrezFernando.entity.EmpresaEntity;
import com.codigo.GutierrezFernando.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServicelmpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaEntity Crear(EmpresaEntity empresaEntity) {
        return empresaRepository.save(empresaEntity);
    }

    @Override
    public Optional<EmpresaEntity> BuscarxId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> BuscarAll() {
        return empresaRepository.findAll();
    }
                    //actualizar//
    @Override
    public EmpresaEntity Actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity>empresaRecuperada=empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()){
            EmpresaEntity empresa =empresaRecuperada.get();
            empresa.setRazon_social(empresaEntity.getRazon_social());
            empresa.setTipo_documento(empresaEntity.getTipo_documento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setDateCreate(empresaEntity.getDateCreate());
            empresa.setDateModif(empresaEntity.getDateModif());
            empresa.setDateDelet(empresaEntity.getDateDelet());
            empresa.setUsuaCrea(empresaEntity.getUsuaCrea());
            empresa.setUsuaModif(empresaEntity.getUsuaModif());
            empresa.setUsuaDelet(empresaEntity.getUsuaDelet());
            return empresaRepository.save(empresa);

        }
        return null;
    }

    @Override
    public EmpresaEntity Borrar(Long id) {
        Optional<EmpresaEntity>empresaRecuperada=empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setDateCreate(getTimeStamp());
            empresaRecuperada.get().setDateModif(getTimeStamp());
            empresaRecuperada.get().setDateDelet(getTimeStamp());
            empresaRecuperada.get().setUsuaCrea(toString());
            empresaRecuperada.get().setUsuaModif(toString());
            empresaRecuperada.get().setUsuaDelet(toString());


            return empresaRepository.save(empresaRecuperada.get());

        }
        return null;
    }
    private Timestamp getTimeStamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
}}
