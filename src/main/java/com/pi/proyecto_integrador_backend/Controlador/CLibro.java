package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import com.pi.proyecto_integrador_backend.Servicios.SLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@CrossOrigin("*")
public class CLibro {

    @Autowired
    private SLibro sLibro;

    //  Lista general
    @GetMapping
    public List<MLibro> listarLibros() throws Exception {
        return sLibro.listarLibros();
    }

    //  Buscar por ID
    @GetMapping("/{id}")
    public MLibro consultarPorId(@PathVariable Integer id) throws Exception {
        return sLibro.consultarPorId(id);
    }

    //  Buscar por nombre
    @GetMapping("/buscar")
    public List<MLibro> consultarPorNombre(@RequestParam String nombre) throws Exception {
        return sLibro.consultarPorNombre(nombre);
    }

    // Agregar libro
    @PostMapping
    public MLibro agregarLibro(@RequestBody MLibro libro) throws Exception {
        return sLibro.agregarLibro(libro);
    }

    // Modificar libro
    @PutMapping("/{id}")
    public MLibro modificarLibro(@PathVariable Integer id, @RequestBody MLibro libro) throws Exception {
        return sLibro.modificarLibro(id, libro);
    }

    //  Eliminar libro
    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable Integer id) throws Exception {
        sLibro.eliminarLibro(id);
        return "Libro eliminado correctamente";
    }
}