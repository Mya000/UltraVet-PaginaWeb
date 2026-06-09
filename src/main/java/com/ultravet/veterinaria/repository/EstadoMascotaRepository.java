package com.ultravet.veterinaria.repository;

import com.ultravet.veterinaria.model.EstadoMascota;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoMascotaRepository extends JpaRepository<EstadoMascota, Long> {

    Optional<EstadoMascota> findByNombre(String nombre);
}
