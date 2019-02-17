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
		int pointDegradation = 0;
		for(int i = 0, n = adder.length(); i < n; i++) {
			pointDegradation++;
		}
		return input + adder;
	}
}
