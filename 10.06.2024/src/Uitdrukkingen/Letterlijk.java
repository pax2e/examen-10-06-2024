package Uitdrukkingen;

public final class Letterlijk extends Uitdrukking {
	
	final int waarde;
	
	/**
	 * @post | getLetterlijk() == waarde
	 */
	public Letterlijk(int waarde) {
		this.waarde = waarde;
	}
	@Override
	final public int getLetterlijk() {
		return this.waarde;
	}

	@Override
	final public String getVariabele() {
		throw new UnsupportedOperationException("bruh");
	}

}
