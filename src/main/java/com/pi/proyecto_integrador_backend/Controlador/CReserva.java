package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Dto.ReservaCompletaDto;
import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Servicios.SReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class CReserva {

    @Autowired
    private SReserva sReserva;

    // LISTAR
    @GetMapping
    public ResponseEntity<?> listar() {

        try {

            return ResponseEntity.ok(
                    sReserva.listarReservas()
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // BUSCAR
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {

        try {

            return sReserva.encontrarReserva(id)
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
    public ResponseEntity<?> guardar(@RequestBody ReservaCompletaDto dto) {

        try {

            MReserva reserva = sReserva.guardarReservaCompleta(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {

            sReserva.eliminarReserva(id);

            return ResponseEntity.ok(
                    "Reserva eliminada correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // EXISTE
    @GetMapping("/existe/{id}")
    public ResponseEntity<?> existe(@PathVariable Long id) {

        try {

            return ResponseEntity.ok(
                    sReserva.existeReserva(id)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}