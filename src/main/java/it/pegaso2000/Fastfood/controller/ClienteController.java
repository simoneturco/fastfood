package it.pegaso2000.Fastfood.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pegaso2000.Fastfood.dto.ClienteDto;
import it.pegaso2000.Fastfood.model.Cliente;
import it.pegaso2000.Fastfood.service.ClienteService;

@RestController
@RequestMapping(path = "api/v1/fastfood/cliente")
public class ClienteController {

	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		// TODO Auto-generated constructor stub
		this.clienteService = clienteService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<ClienteDto>> getClienti() {
		List<ClienteDto> listaClienti = 
				clienteService.getClienti()
					.stream()
						.map(cliente -> {
							return entityToDto(cliente);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(listaClienti, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<ClienteDto> getCliente(@PathVariable Integer id) {
		return new ResponseEntity<>(entityToDto(clienteService.getCliente(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<ClienteDto> saveCliente(@RequestBody ClienteDto cliente) {
		return new ResponseEntity<>(entityToDto(clienteService.saveCliente(dtoToEntity(cliente))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<ClienteDto> updateCliente(@RequestBody ClienteDto cliente, @PathVariable Integer id) {
		return new ResponseEntity<>(entityToDto(clienteService.updateCliente(dtoToEntity(cliente), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteCliente(@PathVariable Integer id) {
		return new ResponseEntity<>(clienteService.deleteCliente(id), HttpStatus.OK);
	}
	
	private ClienteDto entityToDto(Cliente entity) {
		ClienteDto dto = new ClienteDto(entity.getNome(), entity.getVegetariano(), entity.getEta());
		dto.setId(entity.getId());
		
		return dto;
	}
	
	private Cliente dtoToEntity(ClienteDto dto) {
		Cliente entity = new Cliente();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setVegetariano(dto.getVegetariano());
		entity.setEta(dto.getEta());
		
		return entity;
	}
}
