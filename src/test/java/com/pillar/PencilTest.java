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

	// Tests for write() function
	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsAString() {
		assertEquals("input", pencil.write("input", ""));
	}

	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsTheStringsAppendedTogether() {
		assertEquals("She sells sea shells down by the sea shore",
				pencil.write("She sells sea shells", " down by the sea shore"));
	}
	
	@Test
	public void whenPencilWritesAStringWithPuncuationItReturnsStringProperly() {
		assertEquals("Test String? Maybe.",pencil.write("Test String? ", "Maybe."));
	}

	@Test
	public void whenPencilWithoutAPointWritesAnythingItReturnsTheOriginalString() {
		Pencil noPointPencil = new Pencil(10, 0, 1000);
		assertEquals("input       ", noPointPencil.write("input", " output"));
		assertEquals(0, noPointPencil.getPointDurability());
	}

	@Test
	public void whenPencilDegradesDuringWritingItReturnsAPartialString() {
		Pencil minimalPointPencil = new Pencil(10, 4, 1000);
		assertEquals("Tex ", minimalPointPencil.write("", "Text"));
	}

	// Tests for pencil point degradation
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
	

	// Tests for sharpen() function
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

	// Test for erase()
	@Test
	public void whenPencilErasesNothingThePaperDoesNotChange() {
		assertEquals("input", pencil.erase("input", ""));
	}

	@Test
	public void whenPencilErasesAWordItReturnsTheInputWithSpacesWhereTheWordWas() {
		assertEquals("input     output", pencil.erase("input and output", "and"));
	}

	@Test
	public void whenPencilErasesAWordWithMultipleOccurrencesItErasesTheLastOccurrence() {
		assertEquals("How much wood would a woodchuck chuck if a woodchuck could       wood?",
				pencil.erase("How much wood would a woodchuck chuck if a woodchuck could chuck wood?", "chuck"));
	}

	// Test for eraser degradation
	@Test
	public void whenPencilErasesSomethingItDegradesTheEraser() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input", "and");
		assertTrue(prevEraserDurability > pencil.getEraserDurability());
	}

	@Test
	public void whenPencilErasesALetterItDegradesTheEraserByOne() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input", "a");
		assertTrue(prevEraserDurability == (pencil.getEraserDurability() + 1));
	}

	@Test
	public void whenPencilErasesTwoLettersItDegradesTheEraserByTwo() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input", "an");
		assertTrue(prevEraserDurability == (pencil.getEraserDurability() + 2));
	}

	@Test
	public void whenPencilErasesASpaceItDoesNotDegrade() {
		int prevEraserDurability = pencil.getEraserDurability();
		pencil.erase("input and output and input", " ");
		assertTrue(prevEraserDurability == pencil.getEraserDurability());
	}

	@Test
	public void whenPencilNoEraserErasesItReturnsTheInput() {
		Pencil noEraserPencil = new Pencil(10, 1000, 0);
		assertEquals("input and output", noEraserPencil.erase("input and output", "and"));
	}

	@Test
	public void whenPencilEraserRunsOutItErasesOnlyPartOfInput() {
		Pencil lowEraserPencil = new Pencil(10, 1000, 3);
		assertEquals("Buffalo B   ", lowEraserPencil.erase("Buffalo Bill", "Bill"));
	}

	// Tests for edit() function
	@Test
	public void whenAPencilEditsEmptySpaceWithNothingItReturnsTheInput() {
		String input = pencil.erase("this string has many words", "string");
		assertEquals("this        has many words", pencil.edit(input, ""));
	}

	@Test
	public void whenAPencilEditsEmptySpaceWithALetterItReturnsTheInputWithTheLetterInTheEmptySpace() {
		String input = pencil.erase("this string has many words", "string");
		assertEquals("this a      has many words", pencil.edit(input, "a"));
	}

	@Test
	public void whenAPencilEditsEmptySpaceWithAShortWordItReturnsTheInputWithTheShortWordInTheEmptySpace() {
		String input = pencil.erase("this string has many words", "string");
		assertEquals("this key    has many words", pencil.edit(input, "key"));
	}

	@Test
	public void whenAPencilEditsEmptySpaceWithALongWordItReturnsTheInputWithTheLongWordInTheEmptySpace() {
		String input = pencil.erase("this string has many words", "string");
		assertEquals("this paragra@@s many words", pencil.edit(input, "paragraph"));
	}

	@Test
	public void whenDifferentPencilEditsEmptypSpaceItReturnsInputWithEmptySpaceEditedCorrectly() {
		String input = pencil.erase("An apple a day keeps the doctor away", "apple");
		Pencil diffPencil = new Pencil(5, 2000, 500);
		assertEquals("An artich@k@ay keeps the doctor away", diffPencil.edit(input, "artichoke"));
	}

	@Test
	public void whenPencilEditsStringWithoutBlankSpaceItReturnsTheOriginalString() {
		String input = "An apple a day keeps the doctor away";
		assertEquals(input, pencil.edit(input, "artichoke"));
	}

}
