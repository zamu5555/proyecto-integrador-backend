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

    //  Lista general
    public List<MEditorial> listarEditoriales() throws Exception {
        try {
            return iEditorial.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //  Buscar por ID
    public MEditorial consultarPorId(Integer id) throws Exception {
        try {
            Optional<MEditorial> editorial = iEditorial.findById(id);

            if (editorial.isEmpty()) {
                throw new Exception("Editorial no encontrada con id: " + id);
            }

            return editorial.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //  Buscar por nombre (LIKE)
    public List<MEditorial> consultarPorNombre(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre no puede estar vacío");
            }

            return iEditorial.buscarPorNombre(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //  Agregar editorial
    public MEditorial agregarEditorial(MEditorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("La editorial no puede ser null");
            }

            return iEditorial.save(editorial);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //  Modificar editorial
    public MEditorial modificarEditorial(Integer id, MEditorial editorialActualizada) throws Exception {
        try {
            Optional<MEditorial> editorialExistente = iEditorial.findById(id);

            if (editorialExistente.isEmpty()) {
                throw new Exception("Editorial no encontrada con id: " + id);
            }

            MEditorial editorial = editorialExistente.get();

            // 🔧 Ajusta según tu modelo
            editorial.setNombreEditorial(editorialActualizada.getNombreEditorial());

            return iEditorial.save(editorial);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //  Eliminar editorial
    public void eliminarEditorial(Integer id) throws Exception {
        try {
            if (!iEditorial.existsById(id)) {
                throw new Exception("Editorial no encontrada con id: " + id);
            }

            iEditorial.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}