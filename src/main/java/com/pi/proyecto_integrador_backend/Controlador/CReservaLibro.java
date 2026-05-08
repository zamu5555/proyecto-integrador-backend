package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MReservaLibro;
import com.pi.proyecto_integrador_backend.Servicio.SReservaLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva-libro")
@CrossOrigin(origins = "*")
public class CReservaLibro {

    @Autowired
    private SReservaLibro reservaLibroService;

    // Lista general
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservaLibroService.listar());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservaLibroService.buscarPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MReservaLibro reservaLibro) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservaLibroService.guardar(reservaLibro));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            reservaLibroService.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).body("ReservaLibro eliminada correctamente");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar por reserva
    @PostMapping("/por-reserva")
    public ResponseEntity<?> buscarPorReserva(@RequestBody MReserva reserva) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(reservaLibroService.buscarPorReserva(reserva));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}