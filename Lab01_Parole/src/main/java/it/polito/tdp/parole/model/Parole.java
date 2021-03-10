package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
		
	ArrayList<String> parole;
	public Parole() {
		this.parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
	    ArrayList<String> p = new ArrayList<String>();
	    p.addAll(parole);
	    
	    Collections.sort(p);
		return p;
	}
	
	public void reset() {
		this.parole.clear();
	}
	
	public void cancellaParola(String word) {
		for(String s : this.parole)
			if(s.equals(word))
				this.parole.remove(word);
	}

}
