package com.pillar;

public class Pencil {
	private int pencilLength;
	private int initialPointDurability;
	private int currentPointDurability;
	private int eraserDurability;
	
	public Pencil(int pencilLength, int pointDurability, int eraserDurability) {
		this.pencilLength = pencilLength;
		this.initialPointDurability = pointDurability;
		this.currentPointDurability = pointDurability;
		this.eraserDurability = eraserDurability;
	}

	public int getPointDurability() {
		return currentPointDurability;
	}
	
	public int getLength() {
		return pencilLength;
	}

	public int getEraserDurability() {
		return eraserDurability;
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

	public String erase(String input, String erasedWord) {
		int index = input.lastIndexOf(erasedWord);
		if(index > 0 && erasedWord != "") {
			String updatedInput = input.substring(0, index);
			for(int i = 0, n = erasedWord.length(); i < n; i++) {
				updatedInput += " ";
			}
			updatedInput += input.substring(index + erasedWord.length());
			eraserDurability--;
			return updatedInput;
		}
		return input;
	}


}
