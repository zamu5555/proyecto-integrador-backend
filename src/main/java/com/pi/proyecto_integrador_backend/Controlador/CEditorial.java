package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MEditorial;
import com.pi.proyecto_integrador_backend.Servicios.SEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
@CrossOrigin("*")
public class CEditorial {

    @Autowired
    private SEditorial sEditorial;

    //  Lista general
    @GetMapping
    public List<MEditorial> listarEditoriales() throws Exception {
        return sEditorial.listarEditoriales();
    }

    //  Buscar por ID
    @GetMapping("/{id}")
    public MEditorial consultarPorId(@PathVariable Integer id) throws Exception {
        return sEditorial.consultarPorId(id);
    }

    //  Buscar por nombre
    @GetMapping("/buscar")
    public List<MEditorial> consultarPorNombre(@RequestParam String nombre) throws Exception {
        return sEditorial.consultarPorNombre(nombre);
    }

    //  Agregar editorial
    @PostMapping
    public MEditorial agregarEditorial(@RequestBody MEditorial editorial) throws Exception {
        return sEditorial.agregarEditorial(editorial);
    }

    //  Modificar editorial
    @PutMapping("/{id}")
    public MEditorial modificarEditorial(@PathVariable Integer id,
                                         @RequestBody MEditorial editorial) throws Exception {
        return sEditorial.modificarEditorial(id, editorial);
    }

    //  Eliminar editorial
    @DeleteMapping("/{id}")
    public String eliminarEditorial(@PathVariable Integer id) throws Exception {
        sEditorial.eliminarEditorial(id);
        return "Editorial eliminada correctamente";
    }
}