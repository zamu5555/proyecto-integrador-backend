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

    @GetMapping
    public ResponseEntity<List<MReserva>> listar() {
        return ResponseEntity.ok(sReserva.listarReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MReserva> buscar(@PathVariable Long id) throws Exception {
        return sReserva.encontrarReserva(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔥 NUEVO POST CORRECTO
    @PostMapping
    public ResponseEntity<MReserva> guardar(@RequestBody ReservaCompletaDto dto) throws Exception {

        MReserva reserva = sReserva.guardarReservaCompleta(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws Exception {
        sReserva.eliminarReserva(id);
        return ResponseEntity.ok("Reserva eliminada correctamente");
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(sReserva.existeReserva(id));
    }
}