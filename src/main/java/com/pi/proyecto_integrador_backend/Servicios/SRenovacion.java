package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import com.pi.proyecto_integrador_backend.Repositorio.IRenovacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SRenovacion {
    @Autowired
    private IRenovacion iRenovacion;

    // Lista general de renovacines
    public List<MRenovacion> listarRenovaciones() throws Exception{
        return iRenovacion.findAll();
    }

    // Encontrar renovacion por fecha
    public List<MRenovacion> consultarPorFechaRenovacion (LocalDate fechaRenovacion) throws Exception{

        try {
            return  iRenovacion.findByfechaRenovacion(fechaRenovacion);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
