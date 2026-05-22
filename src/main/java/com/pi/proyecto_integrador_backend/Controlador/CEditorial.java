package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MEditorial;
import com.pi.proyecto_integrador_backend.Servicios.SEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
@CrossOrigin(origins = "*")
public class CEditorial {

    @Autowired
    private SEditorial sEditorial;

    // LISTAR
    @GetMapping
    public ResponseEntity<?> listarEditoriales() {

        try {

            return ResponseEntity.ok(
                    sEditorial.listarEditoriales()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Long id) {

        try {

            MEditorial editorial = sEditorial.consultarPorId(id);

            return ResponseEntity.ok(editorial);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR NOMBRE
    @GetMapping("/buscar")
    public ResponseEntity<?> consultarPorNombre(
            @RequestParam String nombre) {

        try {

            return ResponseEntity.ok(
                    sEditorial.consultarPorNombre(nombre)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<?> agregarEditorial(
            @RequestBody MEditorial editorial) {

        try {

            MEditorial nueva = sEditorial.agregarEditorial(editorial);

            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEditorial(
            @PathVariable Long id,
            @RequestBody MEditorial editorial) {

        try {

            MEditorial actualizada =
                    sEditorial.modificarEditorial(id, editorial);

            return ResponseEntity.ok(actualizada);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEditorial(
            @PathVariable Long id) {

        try {

            sEditorial.eliminarEditorial(id);

            return ResponseEntity.ok(
                    "Editorial eliminada correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}