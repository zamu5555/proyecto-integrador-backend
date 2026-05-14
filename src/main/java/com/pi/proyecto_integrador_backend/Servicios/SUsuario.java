package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MUsuario;
import com.pi.proyecto_integrador_backend.Repositorio.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SUsuario {

    @Autowired
    private IUsuario usuarioRepo;

    // LISTAR
    public List<MUsuario> listar()
            throws Exception {

        try {

            return usuarioRepo.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Optional<MUsuario> buscarPorId(
            Long id) throws Exception {

        try {

            return usuarioRepo.findById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR DOCUMENTO
    public Optional<MUsuario> buscarPorDocumento(
            String documento) throws Exception {

        try {

            return usuarioRepo.findByDocumento(documento);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MUsuario guardar(MUsuario usuario)
            throws Exception {

        try {

            if (usuario == null) {

                throw new Exception(
                        "El usuario no puede ser null"
                );
            }

            return usuarioRepo.save(usuario);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(Long id)
            throws Exception {

        try {

            if (!usuarioRepo.existsById(id)) {

                throw new Exception(
                        "Usuario no encontrado"
                );
            }

            usuarioRepo.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}