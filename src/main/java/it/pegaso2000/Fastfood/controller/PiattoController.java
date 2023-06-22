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

import it.pegaso2000.Fastfood.dto.PiattoDto;
import it.pegaso2000.Fastfood.model.Piatto;
import it.pegaso2000.Fastfood.service.PiattoService;

@RestController
@RequestMapping(path = "/api/v1/fastfood/piatto")
public class PiattoController {

	private PiattoService piattoService;
	
	public PiattoController(PiattoService piattoService) {
		// TODO Auto-generated constructor stub
		this.piattoService = piattoService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<PiattoDto>> getPiatti() {
		List<PiattoDto> listaPiatti = 
				piattoService.getPiatti()
					.stream()
						.map(piatto -> {
							return entityToDto(piatto);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(listaPiatti, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<PiattoDto> getPiatto(@PathVariable Integer id) {
		return new ResponseEntity<>(entityToDto(piattoService.getPiatto(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<PiattoDto> savePiatto(@RequestBody PiattoDto piatto) {
		return new ResponseEntity<>(entityToDto(piattoService.savePiatto(dtoToEntity(piatto))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<PiattoDto> updatePiatto(@RequestBody PiattoDto piatto, @PathVariable Integer id) {
		return new ResponseEntity<>(entityToDto(piattoService.updatePiatto(dtoToEntity(piatto), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deletePiatto(@PathVariable Integer id) {
		return new ResponseEntity<>(piattoService.deletePiatto(id), HttpStatus.OK);
	}
	
	private PiattoDto entityToDto(Piatto entity) {
		PiattoDto dto = new PiattoDto(entity.getDescrizione(), entity.getVegetariano(), entity.getPrezzo());
		dto.setId(entity.getId());
		
		return dto;
	}
	
	private Piatto dtoToEntity(PiattoDto dto) {
		Piatto entity = new Piatto();
		entity.setId(dto.getId());
		entity.setDescrizione(dto.getDescrizione());
		entity.setVegetariano(dto.getVegetariano());
		entity.setPrezzo(dto.getPrezzo());
		
		return entity;
	}
}
