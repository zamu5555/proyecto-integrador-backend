package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MEditorial;
import com.pi.proyecto_integrador_backend.Servicios.SEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
@CrossOrigin("*")
public class CEditorial {

    @Autowired
    private SEditorial sEditorial;

    // Lista general
    @GetMapping
    public ResponseEntity<?> listarEditoriales() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sEditorial.listarEditoriales());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sEditorial.consultarPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por nombre
    @GetMapping("/buscar")
    public ResponseEntity<?> consultarPorNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sEditorial.consultarPorNombre(nombre));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Agregar editorial
    @PostMapping
    public ResponseEntity<?> agregarEditorial(@RequestBody MEditorial editorial) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sEditorial.agregarEditorial(editorial));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Modificar editorial
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEditorial(@PathVariable Integer id,
                                                @RequestBody MEditorial editorial) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sEditorial.modificarEditorial(id, editorial));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Eliminar editorial
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEditorial(@PathVariable Integer id) {
        try {
            sEditorial.eliminarEditorial(id);
            return ResponseEntity.status(HttpStatus.OK).body("Editorial eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}