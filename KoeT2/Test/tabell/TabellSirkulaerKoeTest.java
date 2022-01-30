package tabell;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import adt.KoeADTTest;

import java.util.*;


import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.tabell.TabellSirkulaerKoe;
public  class TabellSirkulaerKoeTest extends KoeADTTest{
	
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}
		



}
