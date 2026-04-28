package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MUsuario;
import com.pi.proyecto_integrador_backend.Servicio.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class CUsuario {

    @Autowired
    private SUsuario usuarioService;

    @GetMapping
    public List<MUsuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<MUsuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/documento/{doc}")
    public Optional<MUsuario> buscarPorDocumento(@PathVariable String doc) {
        return usuarioService.buscarPorDocumento(doc);
    }

    @PostMapping
    public MUsuario guardar(@RequestBody MUsuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}