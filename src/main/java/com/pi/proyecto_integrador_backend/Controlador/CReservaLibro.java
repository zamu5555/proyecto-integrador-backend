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
    public ResponseEntity<List<MReservaLibro>> listar()
            throws Exception {

        return ResponseEntity.ok(
                reservaLibroService.listar()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MReservaLibro> buscarPorId(
            @PathVariable Long id)
            throws Exception {

        return reservaLibroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // AGREGAR
    @PostMapping
    public ResponseEntity<MReservaLibro> guardar(
            @RequestBody MReservaLibro reservaLibro)
            throws Exception {

        MReservaLibro nuevo =
                reservaLibroService.guardar(reservaLibro);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<MReservaLibro> actualizar(
            @PathVariable Long id,
            @RequestBody MReservaLibro reservaLibro)
            throws Exception {

        reservaLibro.setId(id);

        MReservaLibro actualizado =
                reservaLibroService.guardar(reservaLibro);

        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Long id)
            throws Exception {

        reservaLibroService.eliminar(id);

        return ResponseEntity.ok(
                "Registro eliminado correctamente"
        );
    }

    // BUSCAR POR RESERVA
    @PostMapping("/por-reserva")
    public ResponseEntity<List<MReservaLibro>> buscarPorReserva(
            @RequestBody MReserva reserva)
            throws Exception {

        return ResponseEntity.ok(
                reservaLibroService.buscarPorReserva(reserva)
        );
    }
}