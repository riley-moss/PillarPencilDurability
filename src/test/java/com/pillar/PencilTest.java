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

	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsAString() {
		assertEquals("input", pencil.write("input",""));
	}
	
	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsTheStringsAppendedTogether() {
		assertEquals("input output", pencil.write("input", " output"));
	}
	

}
