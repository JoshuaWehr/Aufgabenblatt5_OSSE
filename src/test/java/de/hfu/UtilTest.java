package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {
	final boolean sollWert=true;
	

	@Test
	public void test() {
		for (int i=0; i<12; i++) {
			final int eingabe=1;
			assertEquals(sollWert,Util.istErstesHalbjahr(eingabe));
		}
		
		//fail("Monat ist nicht im ersten Halbjahr.");
	}

}
