package com.pillar;

import static org.junit.Assert.*;

import org.junit.Test;

public class PencilTest {

	@Test
	public void whenPencilIsPassedAStringToWriteItReturnsAString() {
		Pencil pencil = new Pencil();
		assertEquals("string output", pencil.write("string output"));
	}

}
