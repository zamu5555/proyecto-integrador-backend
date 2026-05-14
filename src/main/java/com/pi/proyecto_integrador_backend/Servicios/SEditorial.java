package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MEditorial;
import com.pi.proyecto_integrador_backend.Repositorio.IEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SEditorial {

    @Autowired
    private IEditorial iEditorial;

    // LISTAR
    public List<MEditorial> listarEditoriales() throws Exception {

        try {

            return iEditorial.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR ID
    public MEditorial consultarPorId(Long id) throws Exception {

        try {

            Optional<MEditorial> editorial =
                    iEditorial.findById(id);

            if (editorial.isEmpty()) {

                throw new Exception(
                        "Editorial no encontrada"
                );
            }

            return editorial.get();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR NOMBRE
    public List<MEditorial> consultarPorNombre(
            String nombre) throws Exception {

        try {

            if (nombre == null || nombre.trim().isEmpty()) {

                throw new Exception(
                        "El nombre no puede estar vacío"
                );
            }

            return iEditorial.buscarPorNombre(nombre);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MEditorial agregarEditorial(
            MEditorial editorial) throws Exception {

        try {

            if (editorial == null) {

                throw new Exception(
                        "La editorial no puede ser null"
                );
            }

            return iEditorial.save(editorial);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // MODIFICAR
    public MEditorial modificarEditorial(
            Long id,
            MEditorial editorialActualizada)
            throws Exception {

        try {

            Optional<MEditorial> editorialExistente =
                    iEditorial.findById(id);

            if (editorialExistente.isEmpty()) {

                throw new Exception(
                        "Editorial no encontrada"
                );
            }

            MEditorial editorial =
                    editorialExistente.get();

            editorial.setNombreEditorial(
                    editorialActualizada.getNombreEditorial()
            );

            return iEditorial.save(editorial);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarEditorial(Long id)
            throws Exception {

        try {

            if (!iEditorial.existsById(id)) {

                throw new Exception(
                        "Editorial no encontrada"
                );
            }

            iEditorial.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}