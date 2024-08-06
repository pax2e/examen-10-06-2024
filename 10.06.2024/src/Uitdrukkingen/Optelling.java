package Uitdrukkingen;

/**
 * @invar | getLinker() != null
 * @invar | getRechter() != null
 */
public final class Optelling extends Uitdrukking {
	
	/**
	 * @invar | linker != null
	 */
	final Uitdrukking linker;
	/**
	 * @invar | rechter != null
	 */
	final Uitdrukking rechter;
	
	/**
	 * @throws IllegalArgumentException | links == null || rechts == null
	 * @post | getLinker() == links
	 * @post | getRechter() == rechts
	 */
	public Optelling(Uitdrukking links, Uitdrukking rechts) {
		if (links == null || rechts == null) 
			throw new IllegalArgumentException("Inputs mogen niet null zijn");
		this.linker = links;
		this.rechter = rechts;
	}
	
	final public Uitdrukking getLinker() {
		return this.linker;
	}
	
	final public Uitdrukking getRechter() {
		return this.rechter;
	}
	

	@Override
	final public int getLetterlijk() {
		throw new UnsupportedOperationException("bruh");
	}

	@Override
	final public String getVariabele() {
		throw new UnsupportedOperationException("bruh");
	}


}
