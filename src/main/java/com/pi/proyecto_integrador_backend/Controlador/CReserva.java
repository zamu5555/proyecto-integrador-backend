package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Servicios.SReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class CReserva {

    @Autowired
    private SReserva sReserva;

    @GetMapping
    public List<MReserva> listar() {
        return sReserva.listarReservas();
    }

    @GetMapping("/{id}")
    public Optional<MReserva> buscar(@PathVariable Integer id) {
        return sReserva.encontrarReserva(id);
    }

    @PostMapping
    public MReserva guardar(@RequestBody MReserva reserva) {
        return sReserva.agregarReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        sReserva.eliminarReserva(id);
    }

    @GetMapping("/existe/{id}")
    public boolean existe(@PathVariable Integer id) {
        return sReserva.existeReserva(id);
    }
}