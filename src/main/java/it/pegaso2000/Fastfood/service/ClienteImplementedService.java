package it.pegaso2000.Fastfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pegaso2000.Fastfood.model.Cliente;
import it.pegaso2000.Fastfood.repository.ClienteRepository;

@Service
public class ClienteImplementedService implements ClienteService {

	private ClienteRepository clienteRepository;
	
	public ClienteImplementedService(ClienteRepository clienteRepository) {
		// TODO Auto-generated constructor stub
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public List<Cliente> getClienti() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getCliente(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) return cliente.get();
			else return null;
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente, Integer id) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteSrc = clienteRepository.findById(id);
		if(clienteSrc.isPresent()) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		}else return null;
	}

	@Override
	public Boolean deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteSrc = clienteRepository.findById(id);
		if(clienteSrc.isPresent()) {
			clienteRepository.delete(clienteSrc.get());
			return true;
		}else return false;
	}

}
