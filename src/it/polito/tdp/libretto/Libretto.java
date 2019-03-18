package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti= new ArrayList<Voto>();
	}
/**
 * Aggiunge un nuovo voto al libretto
 * @param v
 */
	public void add(Voto v) {
		voti.add(v);
		
	}
	/**
	 * Seleziona l sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti puntegio da ricerca
	 * @return lista di {@link Voto} avent quel punteggio
	 */
	
	
	public List<Voto> cercaVoti(int punti) {
		List<Voto> result= new ArrayList<Voto>();
		for (Voto v : this.voti)
		{
			if(v.getPunti()==punti)
				result.add(v);
		}
		return result;
	}
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente , oppure{@code null} se non esiste
	 */
	
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v : this.voti) {
			if( v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	/**
	 * Dato un {@link Voto}determina se esiste già un voto con uguale corso e punteggio
	 * @param v
	 * @return {@code true}, se ha trovato un corso e punteggio uguali
	 * 			{@code falso} se non ha trovato il corso oppure l'ha trovato ma voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato==null) 
			return false;
			if(trovato.getPunti()== v.getPunti())
				return true;
			else 
				return false;
		
	}
	
}
