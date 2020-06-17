package com.ito.notifico.lineanegocio.service.implementaciones;

import com.ito.notifico.lineanegocio.exception.ResourceNotFoundException;
import com.ito.notifico.lineanegocio.model.ModalidadEntity;
import com.ito.notifico.lineanegocio.repository.IModalidadRepository;
import com.ito.notifico.lineanegocio.service.IGenericNoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModalidadServiceImpl implements IGenericNoPageService<ModalidadEntity>{
        @Autowired
        private IModalidadRepository repository;

        @Override
        public ModalidadEntity findByName(String nombre) throws ResourceNotFoundException {
            if (repository.findByNombre(nombre) == null) {
                return repository.findByNombre(nombre);
            } else {
                throw new ResourceNotFoundException("Modalidad", "nombre", nombre);
            }
        }

        @Override
        public ModalidadEntity create(ModalidadEntity ModalidadEntity) {
            return repository.save(ModalidadEntity);
        }

        @Override
        public void delete(ModalidadEntity ModalidadEntity) throws ResourceNotFoundException {
            if (repository.findById(ModalidadEntity.getId()).isPresent()) {
                repository.delete(ModalidadEntity);
            }
            throw new ResourceNotFoundException("Modalidad", "id", Integer.toString(ModalidadEntity.getId()));
        }

        @Override
        public void deleteById(int id) throws ResourceNotFoundException {
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException("Modalidad", "id", Integer.toString(id));
            }
        }

        @Override
        public Iterable<ModalidadEntity> findAll() {
            List<ModalidadEntity> lista = (List<ModalidadEntity>) repository.findAll();
            return lista;
        }

        @Override
        public ModalidadEntity findById(int id) throws ResourceNotFoundException {
            if (repository.findById(id).isPresent()) {
                return repository.findById(id).get();
            } else {
                throw new ResourceNotFoundException("Modalidad", "id", Integer.toString(id));
            }
        }

        @Override
        public ModalidadEntity update(ModalidadEntity ModalidadEntity) throws ResourceNotFoundException {
            if (repository.findById(ModalidadEntity.getId()).isPresent()) {
                return repository.save(ModalidadEntity);
            }
            throw new ResourceNotFoundException("Modalidad", "id", Integer.toString(ModalidadEntity.getId()));
        }

}
