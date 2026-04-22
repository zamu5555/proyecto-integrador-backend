package com.pi.proyecto_integrador_backend.Controlador;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import com.pi.proyecto_integrador_backend.Repositorio.IRenovacion;
import com.pi.proyecto_integrador_backend.Servicios.SLibro;
import com.pi.proyecto_integrador_backend.Servicios.SRenovacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Renovaciones")
@CrossOrigin ("/*")
public class CRenovacion {

    @Autowired
    private SRenovacion sRenovacion;

    @GetMapping
    public List<MRenovacion> listarRenovaciones() throws Exception{
        return sRenovacion.listarRenovaciones();
    }

    @GetMapping("/buscarRenovacion")
    public List<MRenovacion> consultarPorFechaRenovacion(@RequestParam LocalDate fechaRenovacion)  throws Exception{
        return sRenovacion.consultarPorFechaRenovacion(fechaRenovacion);
    }


}
