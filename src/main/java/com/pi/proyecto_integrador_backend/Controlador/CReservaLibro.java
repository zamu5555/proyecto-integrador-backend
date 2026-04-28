package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MReservaLibro;
import com.pi.proyecto_integrador_backend.Servicio.SReservaLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva-libro")
@CrossOrigin(origins = "*")
public class CReservaLibro {

    @Autowired
    private SReservaLibro reservaLibroService;

    @GetMapping
    public List<MReservaLibro> listar() {
        return reservaLibroService.listar();
    }

    @GetMapping("/{id}")
    public Optional<MReservaLibro> buscarPorId(@PathVariable Long id) {
        return reservaLibroService.buscarPorId(id);
    }

    @PostMapping
    public MReservaLibro guardar(@RequestBody MReservaLibro reservaLibro) {
        return reservaLibroService.guardar(reservaLibro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaLibroService.eliminar(id);
    }

    @PostMapping("/por-reserva")
    public List<MReservaLibro> buscarPorReserva(@RequestBody MReserva reserva) {
        return reservaLibroService.buscarPorReserva(reserva);
    }
}