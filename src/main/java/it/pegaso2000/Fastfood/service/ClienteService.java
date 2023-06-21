package it.pegaso2000.Fastfood.service;

import java.util.List;

import it.pegaso2000.Fastfood.model.Cliente;

public interface ClienteService {

	List<Cliente> getClienti();
	Cliente getCliente(Integer id);
	Cliente saveCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente, Integer id);
	Boolean deleteCliente(Integer id);
}
