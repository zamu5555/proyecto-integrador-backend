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

    public List<MUsuario> listar() {
        return usuarioRepo.findAll();
    }

    public Optional<MUsuario> buscarPorId(Long id) {
        return usuarioRepo.findById(id);
    }

    public Optional<MUsuario> buscarPorDocumento(String documento) {
        return usuarioRepo.findByDocumento(documento);
    }

    public MUsuario guardar(MUsuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public void eliminar(Long id) {
        usuarioRepo.deleteById(id);
    }
}