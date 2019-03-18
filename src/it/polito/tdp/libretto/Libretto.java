package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		
		this.voti = new ArrayList<Voto>();
	}
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno un determinato punteggio
	 * @param punti
	 * @return
	 */
	
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getVoto()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso selezionato
	 * @param nomeEsame
	 * @return
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v: this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * Dato un {@link Voto} determina se esite già un voto con uguale corso e uguale punteggio
	 * @param v
	 * @return 
	 */
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato==null){
			return false;
		}
		if(trovato.getVoto()==v.getVoto()) {
			return true;
		}
		else {
			return false;
		}
	}

}
