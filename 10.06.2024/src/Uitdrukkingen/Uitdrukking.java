package Uitdrukkingen;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class Uitdrukking {
	
	/**
	 * @throws IllegalArgumentException | variabele_naam == null
	 * @post returns
	 */
	public int voorkomens(String variabele_naam) {
		if (variabele_naam == null) 
			throw new IllegalArgumentException("Input mag niet null zijn");
		int voorkomens = 0;
		
		if (this instanceof Variabel l && l.getVariabele() == variabele_naam) {
			voorkomens += 1;
		}
		if (this instanceof Optelling o) {
			voorkomens += o.getLinker().voorkomens(variabele_naam);
			voorkomens += o.getRechter().voorkomens(variabele_naam);
		}
		
		return voorkomens;
	}
	
	public abstract int getLetterlijk();
	public abstract String getVariabele();
	
	public Iterator<Uitdrukking> deelUitdrukkingIterator() {
		return new Iterator<Uitdrukking>() {
			Uitdrukking uitdrukking = Uitdrukking.this;
			
			@Override
			public boolean hasNext() {
				if (uitdrukking instanceof Optelling) {
					return true;
				}
				else
					return false;
			}
			
			@Override
			public Uitdrukking next() {
				Optelling opt = ((Optelling)uitdrukking);
				return opt.getLinker(); //idk klopt niet 
				
			}
		};
	}
	
	public void variabeleIterator(Consumer<? super Variabel> consumer) {
		if (this instanceof Variabel) {
			consumer.accept((Variabel)this);
		}
	}

}
