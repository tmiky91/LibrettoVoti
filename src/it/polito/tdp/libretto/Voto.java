package it.polito.tdp.libretto;

import java.time.LocalDate;

public class Voto {
	
	private int voto;
	private String coso;
	private LocalDate data;
	
	public Voto(int voto, String coso, LocalDate data) {
		
		this.voto = voto;
		this.coso = coso;
		this.data = data;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getCoso() {
		return coso;
	}
	public void setCoso(String coso) {
		this.coso = coso;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

}
