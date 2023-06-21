package it.pegaso2000.Fastfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pegaso2000.Fastfood.model.Piatto;
import it.pegaso2000.Fastfood.repository.PiattoRepository;

@Service
public class PiattoImplementedService implements PiattoService {

	private PiattoRepository piattoRepository;
	
	public PiattoImplementedService(PiattoRepository piattoRepository) {
		// TODO Auto-generated constructor stub
		this.piattoRepository = piattoRepository;
	}
	
	@Override
	public List<Piatto> getPiatti() {
		// TODO Auto-generated method stub
		return piattoRepository.findAll();
	}

	@Override
	public Piatto getPiatto(Integer id) {
		// TODO Auto-generated method stub
		Optional<Piatto> piatto = piattoRepository.findById(id);
		if(piatto.isPresent()) return piatto.get();
			else return null;
	}

	@Override
	public Piatto savePiatto(Piatto piatto) {
		// TODO Auto-generated method stub
		return piattoRepository.save(piatto);
	}

	@Override
	public Piatto updatePiatto(Piatto piatto, Integer id) {
		// TODO Auto-generated method stub
		Optional<Piatto> piattoSrc = piattoRepository.findById(id);
		if(piattoSrc.isPresent()) {
			piatto.setId(id);
			return piattoRepository.save(piatto);
		}else return null;
	}

	@Override
	public Boolean deletePiatto(Integer id) {
		// TODO Auto-generated method stub
		Optional<Piatto> piattoSrc = piattoRepository.findById(id);
		if(piattoSrc.isPresent()) {
			piattoRepository.delete(piattoSrc.get());
			return true;
		}else return false;
	}

}
