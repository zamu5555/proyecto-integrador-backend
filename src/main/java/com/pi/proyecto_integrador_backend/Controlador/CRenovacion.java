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
    public ResponseEntity<List<MRenovacion>> listarRenovaciones()
            throws Exception {

        return ResponseEntity.ok(
                sRenovacion.listarRenovaciones()
        );
    }

    // BUSCAR POR FECHA
    @GetMapping("/buscar")
    public ResponseEntity<List<MRenovacion>> consultarPorFechaRenovacion(
            @RequestParam LocalDate fechaRenovacion) throws Exception {

        return ResponseEntity.ok(
                sRenovacion.consultarPorFechaRenovacion(fechaRenovacion)
        );
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MRenovacion> guardar(
            @RequestBody MRenovacion renovacion) throws Exception {

        MRenovacion nueva =
                sRenovacion.guardar(renovacion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Long id) throws Exception {

        sRenovacion.eliminar(id);

        return ResponseEntity.ok(
                "Renovación eliminada correctamente"
        );
    }
}