package com.coderhouse.jpa_practica;

import com.coderhouse.jpa_practica.entities.Cliente;
import com.coderhouse.jpa_practica.entities.Domicilio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.coderhouse.jpa_practica.services.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaPracticaApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(JpaPracticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			try {
				// Se crea un cliente
				Cliente cliente = new Cliente("Juan", "Perez", 12345678);
				Cliente anderson = new Cliente("Anderson", "Ocaña", 123456789);

				// Se crea los domicilios
				Domicilio domicilioParticular = new Domicilio("Calle 1", 123);
				Domicilio domicilioLaboral = new Domicilio("Calle 2", 456);

				Domicilio domicilioParticular2 = new Domicilio("Calle 3", 789);
				Domicilio domicilioLaboral2 = new Domicilio("Calle 4", 101112);

				domicilioParticular.setCliente(cliente);
				domicilioLaboral.setCliente(cliente);

				domicilioLaboral2.setCliente(anderson);
				domicilioParticular2.setCliente(anderson);

				List<Domicilio> domicilios = new ArrayList<Domicilio>();
				domicilios.add(domicilioParticular);
				domicilios.add(domicilioLaboral);

				List<Domicilio> domicilios2 = new ArrayList<Domicilio>();
				domicilios2.add(domicilioParticular2);
				domicilios2.add(domicilioLaboral2);

				cliente.setDomicilios(domicilios);
				anderson.setDomicilios(domicilios2);

				// Crear cliente con domicilios
				daoFactory.create(cliente);
				daoFactory.create(anderson);

				// Buscar cliente guardado
				Cliente clienteGuardado = daoFactory.getCliente(cliente.getId());

				System.out.println(clienteGuardado.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
