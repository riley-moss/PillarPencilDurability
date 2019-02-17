package com.pillar;

public class Pencil {
	private int initialPointDurability;
	private int currentPointDurability;
	private int pencilLength;
	
	public Pencil(int pencilLength, int pointDurability) {
		this.pencilLength = pencilLength;
		this.initialPointDurability = pointDurability;
		this.currentPointDurability = pointDurability;
	}

	public int getPointDurability() {
		return currentPointDurability;
	}
	
	public int getLength() {
		return pencilLength;
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
		if(pencilLength > 0) {
			currentPointDurability = initialPointDurability;
			pencilLength--;
		}
	}

}
