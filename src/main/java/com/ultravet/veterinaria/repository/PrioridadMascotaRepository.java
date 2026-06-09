package com.ultravet.veterinaria.repository;

import com.ultravet.veterinaria.model.PrioridadMascota;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadMascotaRepository extends JpaRepository<PrioridadMascota, Long> {

    Optional<PrioridadMascota> findByNombre(String nombre);
}
