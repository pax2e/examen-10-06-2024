package Uitdrukkingen;

/**
 * @invar | getVariabele() != null
 */
public final class Variabel extends Uitdrukking {
	
	/**
	 * @invar | variabele != null
	 */
	final String variabele;
	
	/**
	 * @throws IllegalArgumentException | variabele == null
	 * @post | getVariabele() == variabele
	 */
	public Variabel(String variabele) {
		this.variabele = variabele;
	}
	
	@Override
	final public String getVariabele() {
		return this.variabele;
	}
	

	@Override
	final public int getLetterlijk() {
		throw new UnsupportedOperationException("bruh");
	}


}
