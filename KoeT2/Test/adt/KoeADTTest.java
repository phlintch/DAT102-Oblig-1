package adt;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.tabell.TabellSirkulaerKoe;

public abstract  class KoeADTTest {

	private KoeADT<Integer> koeKjedet;
//	private KoeADT<Integer> koeTabell;
	private Integer o1 = 1;
	private Integer o2 = 2;
	private Integer o3 = 3;
	private Integer o4 = 4;
	private Integer o5 = 5;
	
	protected abstract KoeADT<Integer> reset();
	

	@BeforeEach
	public void setup() {
		koeKjedet = reset();
	//	koeTabell = reset();
	}
	@Test 
	public void innKoeTest() {
		koeKjedet.innKoe(o1);
		assertEquals(o1, koeKjedet.foerste());
		koeKjedet.innKoe(o2);
		assertEquals(o1, koeKjedet.foerste());
	}
	@Test
	public void erTomTest() {
		assertTrue(koeKjedet.erTom());
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koeKjedet.foerste();
		});
	}
	@Test
	public void foersteTest() {
		koeKjedet.innKoe(o1);
		assertTrue(koeKjedet.foerste().equals(o1));
		koeKjedet.innKoe(o2);
		assertFalse(koeKjedet.foerste().equals(o2));
		assertTrue(koeKjedet.foerste().equals(o1));
	}
	@Test
	public void utKoeTest() {
		koeKjedet.innKoe(o1);
		koeKjedet.innKoe(o2);
		koeKjedet.utKoe();
		assertEquals(o2,koeKjedet.foerste());
		assertFalse(koeKjedet.erTom());
	}
//	@Test						trengs ikke ser det ut som? må sjekkes, tror 
//	public void BasisKonstruktorTest () {
//			assertTrue(koeTabell.erTom());
//	}
//	@Test
//	public void TABinnKoeTest() {
//		assertTrue(koeTabell.erTom());	
//		koeTabell.innKoe(o1);
//		assertFalse(koeTabell.erTom());
//		assertEquals(o1, koeTabell.foerste());
//		koeTabell.innKoe(o2);
//		koeTabell.innKoe(o3);
//		koeTabell.innKoe(o4);
//		assertEquals(o1, koeTabell.foerste());
//	}
//	@Test
//	public void TAButKoeTest() {
//		koeTabell.innKoe(o1);
//		koeTabell.innKoe(o2);
//		assertFalse(koeTabell.erTom());
//		assertEquals(o1, koeTabell.utKoe());
//		assertFalse(koeTabell.erTom());
//		assertEquals(o2,koeTabell.foerste());
//		koeTabell.utKoe();
//		assertTrue(koeTabell.erTom());
//	}
//	@Test
//	public void TABfoersteTest() {
//		assertTrue(koeTabell.erTom());
//		koeTabell.innKoe(o1);
//		assertEquals(o1,koeTabell.foerste());
//	}
//	@Test
//	public void TAButvidTEST() {
//		koeTabell = new TabellSirkulaerKoe<Integer>(2);
//		koeTabell.innKoe(o1);
//		koeTabell.innKoe(o2); // den skal nå være full, og må utvide
//		koeTabell.innKoe(o3);
//		koeTabell.utKoe();
//		koeTabell.utKoe();
//		assertEquals(koeTabell.foerste(), o3);
//	}
}
