package com.pillar;

import static org.junit.Assert.*;

import org.junit.Test;

public class PencilTest {

	@Test
	public void whenPencilIsPassedTwoStringsToWriteItReturnsAString() {
		Pencil pencil = new Pencil();
		assertEquals("input", pencil.write("input","output"));
	}
	

}