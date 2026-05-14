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

    // LISTAR
    public List<MLibro> listarLibros() throws Exception {

        try {

            return iLibro.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR ID
    public MLibro consultarPorId(Long id)
            throws Exception {

        try {

            Optional<MLibro> libro =
                    iLibro.findById(id);

            if (libro.isEmpty()) {

                throw new Exception(
                        "Libro no encontrado"
                );
            }

            return libro.get();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR NOMBRE
    public List<MLibro> consultarPorNombre(
            String nombre) throws Exception {

        try {

            if (nombre == null || nombre.trim().isEmpty()) {

                throw new Exception(
                        "El nombre no puede estar vacío"
                );
            }

            return iLibro.findByNombre(nombre);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MLibro agregarLibro(MLibro libro)
            throws Exception {

        try {

            if (libro == null) {

                throw new Exception(
                        "El libro no puede ser null"
                );
            }

            return iLibro.save(libro);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // MODIFICAR
    public MLibro modificarLibro(
            Long id,
            MLibro libroActualizado)
            throws Exception {

        try {

            Optional<MLibro> libroExistente =
                    iLibro.findById(id);

            if (libroExistente.isEmpty()) {

                throw new Exception(
                        "Libro no encontrado"
                );
            }

            MLibro libro = libroExistente.get();

            libro.setNombre(
                    libroActualizado.getNombre());

            libro.setAutor(
                    libroActualizado.getAutor());

            libro.setGenero(
                    libroActualizado.getGenero());

            libro.setEditorial(
                    libroActualizado.getEditorial());

            return iLibro.save(libro);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarLibro(Long id)
            throws Exception {

        try {

            if (!iLibro.existsById(id)) {

                throw new Exception(
                        "Libro no encontrado"
                );
            }

            iLibro.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}