package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import com.pi.proyecto_integrador_backend.Repositorio.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SLibro {

    @Autowired
    private ILibro iLibro;

    //  Lista general
    public List<MLibro> listarLibros() throws Exception {
        try {
            return iLibro.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //  Buscar por ID
    public MLibro consultarPorId(Integer id) throws Exception {
        try {
            Optional<MLibro> libro = iLibro.findById(id);

            if (libro.isEmpty()) {
                throw new Exception("Libro no encontrado con id: " + id);
            }

            return libro.get();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //  Consultar por nombre
    public List<MLibro> consultarPorNombre(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre no puede estar vacío");
            }

            return iLibro.findByNombre(nombre);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Agregar libro
    public MLibro agregarLibro(MLibro libro) throws Exception {
        try {
            if (libro == null) {
                throw new Exception("El libro no puede ser null");
            }

            return iLibro.save(libro);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //  Modificar libro
    public MLibro modificarLibro(Integer id, MLibro libroActualizado) throws Exception {
        try {
            Optional<MLibro> libroExistente = iLibro.findById(id);

            if (libroExistente.isEmpty()) {
                throw new Exception("Libro no encontrado con id: " + id);
            }

            MLibro libro = libroExistente.get();

            libro.setNombre(libroActualizado.getNombre());
            libro.setAutor(libroActualizado.getAutor());
            libro.setGenero(libroActualizado.getGenero());

            return iLibro.save(libro);
        } catch (Exception e) {
            throw new Exception("Error al modificar libro: " + e.getMessage());
        }
    }

    //  Eliminar libro
    public void eliminarLibro(Integer id) throws Exception {
        try {
            if (!iLibro.existsById(id)) {
                throw new Exception("Libro no encontrado con id: " + id);
            }

            iLibro.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}