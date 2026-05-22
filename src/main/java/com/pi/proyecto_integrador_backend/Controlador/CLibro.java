package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import com.pi.proyecto_integrador_backend.Servicios.SLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@CrossOrigin(origins = "*")
public class CLibro {

    @Autowired
    private SLibro sLibro;

    // LISTAR
    @GetMapping
    public ResponseEntity<?> listarLibros() {

        try {

            return ResponseEntity.ok(
                    sLibro.listarLibros()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(
            @PathVariable Long id) {

        try {

            MLibro libro = sLibro.consultarPorId(id);

            return ResponseEntity.ok(libro);

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
                    sLibro.consultarPorNombre(nombre)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<?> agregarLibro(
            @RequestBody MLibro libro) {

        try {

            MLibro nuevo = sLibro.agregarLibro(libro);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarLibro(
            @PathVariable Long id,
            @RequestBody MLibro libro) {

        try {

            MLibro actualizado =
                    sLibro.modificarLibro(id, libro);

            return ResponseEntity.ok(actualizado);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibro(
            @PathVariable Long id) {

        try {

            sLibro.eliminarLibro(id);

            return ResponseEntity.ok(
                    "Libro eliminado correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}