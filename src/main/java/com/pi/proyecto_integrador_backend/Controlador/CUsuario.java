package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MUsuario;
import com.pi.proyecto_integrador_backend.Servicios.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class CUsuario {

    @Autowired
    private SUsuario usuarioService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<MUsuario>> listar()
            throws Exception {

        return ResponseEntity.ok(
                usuarioService.listar()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MUsuario> buscarPorId(
            @PathVariable Long id)
            throws Exception {

        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // BUSCAR POR DOCUMENTO
    @GetMapping("/documento/{doc}")
    public ResponseEntity<MUsuario> buscarPorDocumento(
            @PathVariable String doc)
            throws Exception {

        return usuarioService.buscarPorDocumento(doc)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MUsuario> guardar(
            @RequestBody MUsuario usuario)
            throws Exception {

        MUsuario nuevo =
                usuarioService.guardar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<MUsuario> actualizar(
            @PathVariable Long id,
            @RequestBody MUsuario usuario)
            throws Exception {

        usuario.setUsuarioId(id);

        MUsuario actualizado =
                usuarioService.guardar(usuario);

        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Long id)
            throws Exception {

        usuarioService.eliminar(id);

        return ResponseEntity.ok(
                "Usuario eliminado correctamente"
        );
    }
}