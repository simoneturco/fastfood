package it.pegaso2000.Fastfood.dto;

public class ClienteDto {

	private int id;
	private String nome;
	private Boolean vegetariano;
	private int eta;
	
	public ClienteDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteDto(String nome, Boolean vegetariano, int eta) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.vegetariano = vegetariano;
		this.eta = eta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(Boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
}
