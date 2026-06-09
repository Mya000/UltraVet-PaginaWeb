package com.ultravet.veterinaria.repository;

import com.ultravet.veterinaria.model.EstadoSolicitud;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitud, Long> {

    Optional<EstadoSolicitud> findByNombre(String nombre);
}
