package it.pegaso2000.Fastfood.dto;

public class PiattoDto {

	private int id;
	private String descrizione;
	private Boolean vegetariano;
	private int prezzo;
	
	public PiattoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PiattoDto(String descrizione, Boolean vegetariano, int prezzo) {
		// TODO Auto-generated constructor stub
		this.descrizione = descrizione;
		this.vegetariano = vegetariano;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Boolean getVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(Boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
}
