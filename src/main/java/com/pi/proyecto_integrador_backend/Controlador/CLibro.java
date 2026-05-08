package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import com.pi.proyecto_integrador_backend.Servicios.SLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
@CrossOrigin("*")
public class CLibro {

    @Autowired
    private SLibro sLibro;

    // Lista general
    @GetMapping
    public ResponseEntity<?> listarLibros() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sLibro.listarLibros());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sLibro.consultarPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por nombre
    @GetMapping("/buscar")
    public ResponseEntity<?> consultarPorNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sLibro.consultarPorNombre(nombre));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Agregar libro
    @PostMapping
    public ResponseEntity<?> agregarLibro(@RequestBody MLibro libro) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sLibro.agregarLibro(libro));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Modificar libro
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarLibro(@PathVariable Integer id, @RequestBody MLibro libro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sLibro.modificarLibro(id, libro));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Eliminar libro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Integer id) {
        try {
            sLibro.eliminarLibro(id);
            return ResponseEntity.status(HttpStatus.OK).body("Libro eliminado correctamente");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}