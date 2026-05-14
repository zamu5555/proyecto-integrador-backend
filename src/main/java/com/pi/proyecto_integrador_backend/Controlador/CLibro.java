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
    public ResponseEntity<List<MLibro>> listarLibros() throws Exception {

        return ResponseEntity.ok(
                sLibro.listarLibros()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MLibro> consultarPorId(
            @PathVariable Long id) throws Exception {

        MLibro libro = sLibro.consultarPorId(id);

        return ResponseEntity.ok(libro);
    }

    // BUSCAR POR NOMBRE
    @GetMapping("/buscar")
    public ResponseEntity<List<MLibro>> consultarPorNombre(
            @RequestParam String nombre) throws Exception {

        return ResponseEntity.ok(
                sLibro.consultarPorNombre(nombre)
        );
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MLibro> agregarLibro(
            @RequestBody MLibro libro) throws Exception {

        MLibro nuevo = sLibro.agregarLibro(libro);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<MLibro> modificarLibro(
            @PathVariable Long id,
            @RequestBody MLibro libro) throws Exception {

        MLibro actualizado =
                sLibro.modificarLibro(id, libro);

        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(
            @PathVariable Long id) throws Exception {

        sLibro.eliminarLibro(id);

        return ResponseEntity.ok(
                "Libro eliminado correctamente"
        );
    }
}