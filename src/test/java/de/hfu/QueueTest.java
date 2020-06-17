package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void test() {
		
		Queue testQ=new Queue(3);
		int[] sollWert= {0,1,2};
		//int sollWert1=4;
		
		for (int i=0; i<3; i++) {
			
			testQ.enqueue(i);
			//testen, ob tail Wert hochgezählt wird	
			assertEquals(i,testQ.tail);
			
			//testen, ob Werte korrekt eingefügt wurden
			assertEquals(sollWert[i],testQ.queue[i]);
			
			
			//Testen, ob der zuerst eingefügte Wert entfernt wird
			assertEquals(i,testQ.dequeue());
			
		}
		//Testen, ob der Ringspeicher funktioniert = ob 4 an richtiger Stelle eingefügt wurde
		for (int i=0; i<4; i++) {
			testQ.enqueue(i+1);
		}
		int i2=2;
		int sollWert2=4;
		assertEquals(sollWert2,testQ.queue[i2]);
	}
}
