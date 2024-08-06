package wegennetwerk;

import java.util.stream.Stream;

/**
 * @invar | getStart() == null || getStart().getVertrekkende().contains(this)
 * @invar | getEind() == null || getEind().getAankomende().contains(this)
 */
public class Weg {

	/**
	 * @invar | startkruispunt == null || startkruispunt.getVertrekkende().contains(this)
	 * @peerObject
	 */
	Kruispunt startkruispunt;
	
	/**
	 * @invar | eindkruispunt == null || eindkruispunt.getAankomende().contains(this)
	 * @peerObject
	 */
	Kruispunt eindkruispunt;
	
	public Weg() {} //start=null, eind=null
	
	/**
	 * @peerObject
	 * @post | result == null || result.getVertrekkende().contains(this)
	 */
	public Kruispunt getStart() {
		return startkruispunt;
	}

	/**
	 * @peerObject
	 * @post | result == null || result.getAankomende().contains(this)
	 */
	public Kruispunt getEind() {
		return eindkruispunt;
	}
	
	/**
	 * @throws IllegalArgumentException | start == null
	 * @throws IllegalStateException | getStart() != null
	 * @mutates_properties | this.getStart()
	 * @post | getStart() == start
	 * @post | start.getVertrekkende().contains(this)
	 */
	public void setStart(Kruispunt start) {
		if (start == null) {
			throw new IllegalArgumentException("Gewenste startkruispunt kan niet null zijn");
		}
		if (getStart() != null) {
			throw new IllegalStateException("Startkruispunt moet null zijn om startkruispunt in te stellen");
		}
 		this.startkruispunt = start;
		start.vertrekkende.add(this);
	}
	
	/**
	 * @pre  | eind != null
	 * @pre  | getEind() == null
	 * @mutates_properties | this.getEind()
	 * @post | getEind() == eind
	 * @post | eind.getAankomende().contains(this)
	 */
	public void setEind(Kruispunt eind) {
		this.eindkruispunt = eind;
		eind.aankomende.add(this);
	}
	
	/**
	 * @pre | getStart() != null
	 * @pre | getStart().getVertrekkende().contains(this)
	 * @mutates_properties | this.getStart()
	 * @post | getStart() == null
	 * @post | !old(getStart()).getVertrekkende().contains(this)
	 */
	public void ontkoppelStart() {
		getStart().vertrekkende.remove(this);
		this.startkruispunt = null;
	}
	
	/**
	 * @pre | getEind() != null
	 * @pre | getEind().getAankomende().contains(this)
	 * @mutates_properties | this.getEind()
	 * @post | getEind() == null
	 * @post | !old(getEind()).getAankomende().contains(this)
	 */
	public void ontkoppelEind() {
		getEind().aankomende.remove(this);
		this.eindkruispunt = null;
	}
	
	
	public Stream<Weg> tweedeOrdeWegen() {
		return getEind().getVertrekkende().stream().flatMap(w -> Stream.of(w));
	}
	
}
