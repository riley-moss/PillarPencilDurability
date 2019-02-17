package com.pillar;

public class Pencil {
	private int initialPointDurability;
	private int currentPointDurability;
	
	public Pencil(int pointDurability) {
		this.initialPointDurability = pointDurability;
		this.currentPointDurability = pointDurability;
	}

	public int getPointDurability() {
		return currentPointDurability;
	}
	
	public String write(String input, String adder) {
		String lettersAdded = "";
		for(int i = 0, n = adder.length(); i < n; i++) {
			char letter = adder.charAt(i);
			if(Character.isLowerCase(letter) && currentPointDurability > 0) {
				currentPointDurability--;
				lettersAdded += letter;
			}
			else if(Character.isUpperCase(letter) && currentPointDurability > 1) {
				currentPointDurability -= 2;
				lettersAdded += letter;
			}
			else if (letter == ' ') {
				lettersAdded += letter;
			}
		}
		return input + lettersAdded;
	}

	public void sharpen() {
		currentPointDurability = initialPointDurability;
	}
}
