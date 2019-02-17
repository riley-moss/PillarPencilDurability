package com.pillar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PencilTest {
	
	Pencil pencil;
	
	@Before
	public void setUp() {
		pencil = new Pencil();
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

}
