package com.pillar;

public class Pencil {
	private int pointDurability;
	
	public Pencil() {
		pointDurability = 0;
	}

	public int getPointDurability() {
		return pointDurability;
	}
	
	public String write(String input, String adder) {
		pointDurability--;
		return input + adder;
	}
}
