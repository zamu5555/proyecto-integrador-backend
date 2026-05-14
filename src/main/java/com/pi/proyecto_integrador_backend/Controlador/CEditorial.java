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
    public ResponseEntity<List<MEditorial>> listarEditoriales() throws Exception {

        return ResponseEntity.ok(
                sEditorial.listarEditoriales()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MEditorial> consultarPorId(@PathVariable Long id) throws Exception {

        MEditorial editorial = sEditorial.consultarPorId(id);

        return ResponseEntity.ok(editorial);
    }

    // BUSCAR POR NOMBRE
    @GetMapping("/buscar")
    public ResponseEntity<List<MEditorial>> consultarPorNombre(
            @RequestParam String nombre) throws Exception {

        return ResponseEntity.ok(
                sEditorial.consultarPorNombre(nombre)
        );
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MEditorial> agregarEditorial(
            @RequestBody MEditorial editorial) throws Exception {

        MEditorial nueva = sEditorial.agregarEditorial(editorial);

        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<MEditorial> modificarEditorial(
            @PathVariable Long id,
            @RequestBody MEditorial editorial) throws Exception {

        MEditorial actualizada =
                sEditorial.modificarEditorial(id, editorial);

        return ResponseEntity.ok(actualizada);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEditorial(
            @PathVariable Long id) throws Exception {

        sEditorial.eliminarEditorial(id);

        return ResponseEntity.ok(
                "Editorial eliminada correctamente"
        );
    }
}