package it.pegaso2000.Fastfood.service;

import java.util.List;

import it.pegaso2000.Fastfood.model.Piatto;

public interface PiattoService {

	List<Piatto> getPiatti();
	Piatto getPiatto(Integer id);
	Piatto savePiatto(Piatto piatto);
	Piatto updatePiatto(Piatto piatto, Integer id);
	Boolean deletePiatto(Integer id);
}
