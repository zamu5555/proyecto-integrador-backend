package Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RRenovacion extends JpaRepository<MRenovacion,Integer>  {
}
