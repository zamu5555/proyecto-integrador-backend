package com.pi.proyecto_integrador_backend.Controlador;

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
    public ResponseEntity<List<MReserva>> listar()
            throws Exception {

        return ResponseEntity.ok(
                sReserva.listarReservas()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MReserva> buscar(
            @PathVariable Long id)
            throws Exception {

        return sReserva.encontrarReserva(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MReserva> guardar(
            @RequestBody MReserva reserva)
            throws Exception {

        MReserva nueva =
                sReserva.agregarReserva(reserva);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nueva);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<MReserva> actualizar(
            @PathVariable Long id,
            @RequestBody MReserva reserva)
            throws Exception {

        reserva.setReservaId(id);

        MReserva actualizada =
                sReserva.agregarReserva(reserva);

        return ResponseEntity.ok(actualizada);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Long id)
            throws Exception {

        sReserva.eliminarReserva(id);

        return ResponseEntity.ok(
                "Reserva eliminada correctamente"
        );
    }

    // EXISTE
    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existe(
            @PathVariable Long id)
            throws Exception {

        return ResponseEntity.ok(
                sReserva.existeReserva(id)
        );
    }
}