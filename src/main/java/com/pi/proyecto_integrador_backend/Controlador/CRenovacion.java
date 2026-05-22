package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import com.pi.proyecto_integrador_backend.Servicios.SRenovacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/renovaciones")
@CrossOrigin(origins = "*")
public class CRenovacion {

    @Autowired
    private SRenovacion sRenovacion;

    // LISTAR
    @GetMapping
    public ResponseEntity<?> listarRenovaciones() {

        try {

            return ResponseEntity.ok(
                    sRenovacion.listarRenovaciones()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR FECHA
    @GetMapping("/buscar")
    public ResponseEntity<?> consultarPorFechaRenovacion(
            @RequestParam LocalDate fechaRenovacion) {

        try {

            return ResponseEntity.ok(
                    sRenovacion.consultarPorFechaRenovacion(fechaRenovacion)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<?> guardar(
            @RequestBody MRenovacion renovacion) {

        try {

            MRenovacion nueva =
                    sRenovacion.guardar(renovacion);

            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long id) {

        try {

            sRenovacion.eliminar(id);

            return ResponseEntity.ok(
                    "Renovación eliminada correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}