package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MReservaLibro;
import com.pi.proyecto_integrador_backend.Servicios.SReservaLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva-libro")
@CrossOrigin(origins = "*")
public class CReservaLibro {

    @Autowired
    private SReservaLibro reservaLibroService;

    // LISTAR
    @GetMapping
    public ResponseEntity<?> listar() {

        try {

            return ResponseEntity.ok(
                    reservaLibroService.listar()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Long id) {

        try {

            return reservaLibroService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<?> guardar(
            @RequestBody MReservaLibro reservaLibro) {

        try {

            MReservaLibro nuevo =
                    reservaLibroService.guardar(reservaLibro);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevo);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody MReservaLibro reservaLibro) {

        try {

            reservaLibro.setId(id);

            MReservaLibro actualizado =
                    reservaLibroService.guardar(reservaLibro);

            return ResponseEntity.ok(actualizado);

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

            reservaLibroService.eliminar(id);

            return ResponseEntity.ok(
                    "Registro eliminado correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // BUSCAR POR RESERVA
    @PostMapping("/por-reserva")
    public ResponseEntity<?> buscarPorReserva(
            @RequestBody MReserva reserva) {

        try {

            return ResponseEntity.ok(
                    reservaLibroService.buscarPorReserva(reserva)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}