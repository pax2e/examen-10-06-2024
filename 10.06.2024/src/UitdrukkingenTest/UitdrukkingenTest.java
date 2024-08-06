package UitdrukkingenTest;

import static org.junit.jupiter.api.Assertions.*;

import Uitdrukkingen.*;

import org.junit.jupiter.api.Test;

class UitdrukkingenTest {

	@Test
	void test() {
		assertEquals(3, new Letterlijk(3).getLetterlijk());
		assertEquals("x", new Variabel("x").getVariabele());
		Optelling opt = new Optelling(new Letterlijk(2), new Variabel("y"));
		assertEquals(2, opt.getLinker().getLetterlijk());
		assertEquals("y", opt.getRechter().getVariabele());

		Optelling opt1 = new Optelling(new Letterlijk(2), new Variabel("y"));
		Optelling opt2 = new Optelling(opt1, new Variabel("y")); // 2x y
		assertEquals(2, opt2.voorkomens("y"));
		
		
	}

}
