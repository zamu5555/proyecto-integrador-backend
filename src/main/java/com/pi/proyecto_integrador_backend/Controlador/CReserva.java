package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Servicios.SReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@CrossOrigin("*")
public class CReserva {

    @Autowired
    private SReserva sReserva;

    // Lista general
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sReserva.listarReservas());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sReserva.encontrarReserva(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Agregar reserva
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MReserva reserva) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sReserva.agregarReserva(reserva));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            sReserva.eliminarReserva(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Verificar existencia
    @GetMapping("/existe/{id}")
    public ResponseEntity<?> existe(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sReserva.existeReserva(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}