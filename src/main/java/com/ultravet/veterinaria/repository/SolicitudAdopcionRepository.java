package com.ultravet.veterinaria.repository;

import com.ultravet.veterinaria.model.Mascota;
import com.ultravet.veterinaria.model.SolicitudAdopcion;
import com.ultravet.veterinaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Long> {

    boolean existsByUsuarioAndMascota(Usuario usuario, Mascota mascota);
}
