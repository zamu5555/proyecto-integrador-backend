package com.pi.proyecto_integrador_backend.Servicio;

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

    // Lista general
    public List<MUsuario> listar() throws Exception {
        try {
            return usuarioRepo.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public MUsuario buscarPorId(Long id) throws Exception {
        try {
            Optional<MUsuario> usuario = usuarioRepo.findById(id);
            if (usuario.isPresent()) {
                return usuario.get();
            } else {
                throw new Exception("Usuario no encontrado con id: " + id);
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por documento
    public MUsuario buscarPorDocumento(String documento) throws Exception {
        try {
            if (documento == null || documento.trim().isEmpty()) {
                throw new Exception("El documento no puede estar vacío");
            }
            Optional<MUsuario> usuario = usuarioRepo.findByDocumento(documento);
            if (usuario.isPresent()) {
                return usuario.get();
            } else {
                throw new Exception("Usuario no encontrado con documento: " + documento);
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Guardar usuario
    public MUsuario guardar(MUsuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("El usuario no puede ser nulo");
            }
            return usuarioRepo.save(usuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar usuario
    public void eliminar(Long id) throws Exception {
        try {
            if (!usuarioRepo.existsById(id)) {
                throw new Exception("No se puede eliminar, usuario no encontrado con id: " + id);
            }
            usuarioRepo.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}