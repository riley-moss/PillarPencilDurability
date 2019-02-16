package com.pillar;

import static org.junit.Assert.*;

import org.junit.Test;

public class PencilTest {

	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsAString() {
		Pencil pencil = new Pencil();
		assertEquals("input", pencil.write("input",""));
	}
	
	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsTheStringsAppendedTogether() {
		Pencil pencil = new Pencil();
		assertEquals("input output", pencil.write("input", " output"));
	}
	

}
