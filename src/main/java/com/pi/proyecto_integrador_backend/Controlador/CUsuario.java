package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Dto.UsuarioDto;
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
    public ResponseEntity<?> listar() {

        try {

            return ResponseEntity.ok(
                    usuarioService.listar()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        try {

            return usuarioService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR DOCUMENTO
    @GetMapping("/documento/{doc}")
    public ResponseEntity<?> buscarPorDocumento(@PathVariable String doc) {

        try {

            return usuarioService.buscarPorDocumento(doc)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // AGREGAR (DTO)
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody UsuarioDto dto) {

        try {

            MUsuario usuario = new MUsuario();

            usuario.setNombre(dto.getNombre());
            usuario.setDocumento(dto.getDocumento());
            usuario.setTelefono(dto.getTelefono());
            usuario.setCorreo(dto.getCorreo());
            usuario.setContraseña(dto.getContraseña());

            MUsuario nuevo = usuarioService.guardar(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ACTUALIZAR (DTO)
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody UsuarioDto dto) {

        try {

            MUsuario usuario = usuarioService.buscarPorId(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            usuario.setNombre(dto.getNombre());
            usuario.setDocumento(dto.getDocumento());
            usuario.setTelefono(dto.getTelefono());
            usuario.setCorreo(dto.getCorreo());
            usuario.setContraseña(dto.getContraseña());

            MUsuario actualizado = usuarioService.guardar(usuario);

            return ResponseEntity.ok(actualizado);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {

            usuarioService.eliminar(id);

            return ResponseEntity.ok(
                    "Usuario eliminado correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}