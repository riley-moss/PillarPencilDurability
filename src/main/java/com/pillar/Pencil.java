package com.pillar;

public class Pencil {
	private int pointDurability;
	
	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
	}

	public int getPointDurability() {
		return pointDurability;
	}
	
	public String write(String input, String adder) {
		String lettersAdded = "";
		for(int i = 0, n = adder.length(); i < n; i++) {
			char letter = adder.charAt(i);
			if(Character.isLowerCase(letter) && pointDurability > 0) {
				pointDurability--;
				lettersAdded += letter;
			}
			else if(Character.isUpperCase(letter) && pointDurability > 1) {
				pointDurability -= 2;
				lettersAdded += letter;
			}
			else if (letter == ' ') {
				lettersAdded += letter;
			}
		}
		return input + lettersAdded;
	}
}
