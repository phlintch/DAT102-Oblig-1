package kjedet;

import adt.KoeADTTest;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;

public class KjedetKoeTest extends KoeADTTest{
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}
}
