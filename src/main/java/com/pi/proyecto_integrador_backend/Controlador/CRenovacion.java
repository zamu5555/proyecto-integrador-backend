package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import com.pi.proyecto_integrador_backend.Servicios.SRenovacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/Renovaciones")
@CrossOrigin("*")
public class CRenovacion {

    @Autowired
    private SRenovacion sRenovacion;

    // Lista general
    @GetMapping
    public ResponseEntity<?> listarRenovaciones() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sRenovacion.listarRenovaciones());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por fecha
    @GetMapping("/buscarRenovacion")
    public ResponseEntity<?> consultarPorFechaRenovacion(@RequestParam LocalDate fechaRenovacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sRenovacion.consultarPorFechaRenovacion(fechaRenovacion));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}