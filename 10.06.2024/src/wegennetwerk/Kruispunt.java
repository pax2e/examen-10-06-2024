package wegennetwerk;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getVertrekkende() != null
 * @invar | getAankomende() != null
 * @invar | getVertrekkende().isEmpty() || getVertrekkende().stream().allMatch(w -> w.getStart() == this)
 * @invar | getAankomende().isEmpty() || getAankomende().stream().allMatch(w -> w.getEind() == this)
 */
public class Kruispunt {
	
	/**
	 * @representationObject
	 * @peerObjects
	 * @invar | vertrekkende != null
	 * @invar | vertrekkende.isEmpty() || getVertrekkende().stream().allMatch(w -> w.getStart() == this)
	 */
	Set<Weg> vertrekkende = new HashSet<Weg>();

	/**
	 * @representationObject
	 * @peerObjects
	 * @invar | aankomende != null
	 * @invar | aankomende.isEmpty() || getAankomende().stream().allMatch(w -> w.getEind() == this)
	 */
	Set<Weg> aankomende = new HashSet<Weg>();
	
	/**
	 * @post | getVertrekkende().isEmpty()
	 * @post | getAankomende().isEmpty()
	 */
	public Kruispunt() {}
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Weg> getVertrekkende() {
		return Set.copyOf(vertrekkende);
	}

	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Weg> getAankomende() {
		return Set.copyOf(aankomende);
	}
	
	

}
