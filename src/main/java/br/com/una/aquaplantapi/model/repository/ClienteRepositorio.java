package br.com.una.aquaplantapi.model.repository;

import br.com.una.aquaplantapi.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
