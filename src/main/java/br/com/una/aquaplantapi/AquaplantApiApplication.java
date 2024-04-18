package br.com.una.aquaplantapi;

import br.com.una.aquaplantapi.model.domain.Cliente;
import br.com.una.aquaplantapi.model.domain.Planta;
import br.com.una.aquaplantapi.model.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AquaplantApiApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(AquaplantApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setEmail("joao@gmail.com");

		System.out.println(cliente);
		Cliente clienteSalvo = clienteRepositorio.save(cliente);

		Planta planta = new Planta();
		planta.setNome("Rosa");
		planta.setCliente(clienteSalvo);

	}
}
