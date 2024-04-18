package br.com.una.aquaplantapi.model.repository;

import br.com.una.aquaplantapi.model.domain.Planta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepositorio extends JpaRepository<Planta, Long> {
}
