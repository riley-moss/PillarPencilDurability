package com.pillar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {
	
	Pencil pencil;
	
	@Before
	public void setUp() {
		pencil = new Pencil(10, 40000, 1000);
	}
	
	//Tests for write() function
	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsAString() {
		assertEquals("input", pencil.write("input",""));
	}
	
	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsTheStringsAppendedTogether() {
		assertEquals("input output", pencil.write("input", " output"));
	}
	
	@Test
	public void whenPencilWithoutAPointWritesAnythingItReturnsTheOriginalString() {
		Pencil noPointPencil = new Pencil(10, 0, 1000);
		assertEquals("input ", noPointPencil.write("input", " output"));
		assertEquals(0, noPointPencil.getPointDurability());
	}
	
	//Tests for pencil point degradation
	@Test
	public void whenPencilWritesSomethingItDegradesThePoint() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", " output");
		assertTrue(prevPointDurability > pencil.getPointDurability());
	}
	
	@Test
	public void whenPencilWritesALowercaseLetterItDegradesbyOne() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", "a");
		assertTrue(prevPointDurability == (pencil.getPointDurability() + 1));
	}
	
	@Test
	public void whenPencilWritesTwoLowercaseLettersItDegradesbyTwo() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", "aa");
		assertTrue(prevPointDurability == (pencil.getPointDurability() + 2));
	}
	
	@Test
	public void whenPencilWritesAnUpperCaseLetterItDegradesbyTwo() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", "A");
		assertTrue(prevPointDurability == (pencil.getPointDurability() + 2));
	}
	
	@Test
	public void whenPencilWritesTwoUpperCaseLettersItDegradesbyFour() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", "AA");
		assertTrue(prevPointDurability == (pencil.getPointDurability() + 4));
		
	}

	@Test
	public void whenPencilWritesAnUpperCaseAndLowercaseItDegradesByThree() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", "Aa");
		assertTrue(prevPointDurability == (pencil.getPointDurability() + 3));		
	}
	
	@Test
	public void whenPencilWritesASpaceItDoesNotDegrade() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", " ");
		assertTrue(prevPointDurability == (pencil.getPointDurability()));
	}
	
	//Tests for sharpen() function
	@Test
	public void whenPencilIsSharpenedItsPointDurabilityReturnsToInitialValue() {
		int prevPointDurability = pencil.getPointDurability();
		pencil.write("input", " output");
		pencil.sharpen();
		assertTrue(prevPointDurability == (pencil.getPointDurability()));
	}
	
	@Test
	public void whenPencilIsSharpenedItsLengthIsReducedByOne() {
		int prevPencilLength = pencil.getLength();
		pencil.sharpen();
		assertTrue(prevPencilLength == (pencil.getLength() + 1));
	}
	
	@Test
	public void whenPencilLengthBecomesZeroItsPointDurabilityCannotBeRestored() {
		Pencil pencilStub = new Pencil(0, 10000, 1000);
		int prevPointDurability = pencilStub.getPointDurability();
		pencilStub.write("input", " output");
		pencilStub.sharpen();
		assertTrue(prevPointDurability > (pencilStub.getPointDurability()));
	}
	
	//Test for erase()
	@Test
	public void whenPencilErasesNothingThePaperDoesNotChange() {
		assertEquals("input", pencil.erase("input",""));
	}
	
	@Test
	public void whenPencilErasesAWordItReturnsTheInputWithSpacesWhereTheWordWas() {
		assertEquals("input     output", pencil.erase("input and output","and"));
	}
	
	@Test
	public void whenPencilErasesAWordWithMultipleOccurrencesItErasesTheLastOccurrence() {
		assertEquals("input and output     input", pencil.erase("input and output and input","and"));
	}
	
	//Test for eraser degradation
	@Test
	public void whenPencilErasesSomethingItDegradesTheEraser() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input","and");
		assertTrue(prevEraserDurability > pencil.getEraserDurability());
	}
	
	@Test
	public void whenPencilErasesALetterItDegradesTheEraserByOne() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input","a");
		assertTrue(prevEraserDurability == (pencil.getEraserDurability() + 1));
	}
}
