package wegennetwerktest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import wegennetwerk.*;

class Tests {

	@Test
	void test() {
		Weg w1 = new Weg();
		Weg w2 = new Weg();
		Kruispunt k1 = new Kruispunt();
		Kruispunt k2 = new Kruispunt();
		
		assertNull(w1.getStart());
		assertNull(w1.getEind());
		assertTrue(k1.getAankomende().isEmpty());
		assertTrue(k1.getVertrekkende().isEmpty());
		
		assertThrows(IllegalArgumentException.class, () -> w1.setStart(null));
		
		w1.setStart(k1);
		assertEquals(k1, w1.getStart());
		assertNull(w1.getEind());
		HashSet<Weg> expected = new HashSet<Weg>();
		expected.add(w1);
		assertTrue(k1.getVertrekkende().equals(expected));
		assertTrue(k1.getAankomende().equals(new HashSet<Weg>()));
		
		assertThrows(IllegalStateException.class, () -> w1.setStart(k2));
		
		w1.setEind(k2);
		assertEquals(k1, w1.getStart());
		assertEquals(k2, w1.getEind());
		assertTrue(k1.getVertrekkende().equals(expected));
		assertTrue(k2.getAankomende().equals(expected));
		
		w1.ontkoppelStart();
		assertNull(w1.getStart());
		assertEquals(k2, w1.getEind());
		assertTrue(k1.getVertrekkende().equals(new HashSet<Weg>()));
		assertTrue(k2.getAankomende().equals(expected));
		
		w1.ontkoppelEind();
		assertNull(w1.getStart());
		assertNull(w1.getEind());
		assertTrue(k1.getVertrekkende().equals(new HashSet<Weg>()));
		assertTrue(k2.getAankomende().equals(new HashSet<Weg>()));
	}
	
	

}
