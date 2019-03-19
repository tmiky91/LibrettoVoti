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
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoInConflitto(v)) {
			voti.add(v);
			return true;
		}
		else {
			return false;
		}
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
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);
		if(pos==-1) {
			return null;
		}
		else {
			return this.voti.get(pos);
		}
	}
	
	/**
	 * Dato un {@link Voto} determina se esite già un voto con uguale corso e uguale punteggio
	 * @param v
	 * @return 
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos= this.voti.indexOf(v);
		if(pos==-1) {
			return false;
		}
		else {
			return v.getVoto() == this.voti.get(pos).getVoto();
		}
		/*
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
		*/
	}
	
	/**
	 * Mi dice se il {@link Voto} è in conflitto con uno dei voti esistenti. 
	 * Se il voto non esiste non c'è conflitto. Se esiste ed ha punteggio diverso c'è conflitto.
	 * @param v
	 * @return
	 */
	public boolean votoInConflitto(Voto v) {
		int pos= this.voti.indexOf(v);
		if(pos==-1) {
			return false;
		}
		else {
			return v.getVoto() != this.voti.get(pos).getVoto();
		}
	}
	
	public String toString() {
		return voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti) {
			nuovo.add(v.clone());
		}
		for(Voto v: nuovo.voti) {
			int punti = v.getVoto();
			if(punti<24) {
				punti = punti +1;
			}
			else if(punti <=28) {
				punti = punti + 2;
			}
			v.setVoto(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List cancellare = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getVoto()<24) {
				cancellare.add(v);
			}
		}
		this.voti.removeAll(cancellare);
	}
}
