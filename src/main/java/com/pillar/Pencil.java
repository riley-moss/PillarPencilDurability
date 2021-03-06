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
		for (int i = 0, n = adder.length(); i < n; i++) {
			char letter = adder.charAt(i);
			if (Character.isLowerCase(letter) && currentPointDurability > 0) {
				currentPointDurability--;
				lettersAdded += letter;
			} else if (Character.isUpperCase(letter) && currentPointDurability > 1) {
				currentPointDurability -= 2;
				lettersAdded += letter;
			} else if (!Character.isLowerCase(letter) && !Character.isUpperCase(letter) && currentPointDurability > 0) {
				lettersAdded += letter;
			} else if (currentPointDurability == 0 || letter == ' ') {
				lettersAdded += ' ';
			}
		}
		return input + lettersAdded;
	}

	public void sharpen() {
		if (pencilLength > 0) {
			currentPointDurability = initialPointDurability;
			pencilLength--;
		}
	}

	public String erase(String input, String erasedWord) {
		int index = input.lastIndexOf(erasedWord);
		if (index > 0 && erasedWord != "" && eraserDurability > 0) {
			String updatedInput = input.substring(0, index);
			String temp = "";
			for (int i = erasedWord.length() - 1; i > -1; i--) {
				if (eraserDurability > 0) {
					temp = " " + temp;
					if (erasedWord.charAt(i) != ' ')
						eraserDurability--;
				} else
					temp = erasedWord.charAt(i) + temp;
			}
			updatedInput += temp + input.substring(index + erasedWord.length());
			return updatedInput;
		}
		return input;
	}

	public String edit(String input, String edits) {
		int editLength = edits.length();
		int blankSpaceStart = findWhiteSpace(input);
		if (editLength > 0 && blankSpaceStart != -1) {
			String updatedInput = input.substring(0, blankSpaceStart);
			for (int i = 0; i < editLength; i++) {
				if (input.charAt(blankSpaceStart + i) == ' ') {
					updatedInput += edits.charAt(i);
				} else {
					updatedInput += "@";
				}
			}
			updatedInput += input.substring(blankSpaceStart + editLength);
			return updatedInput;
		}
		return input;
	}

	private int findWhiteSpace(String input) {
		for (int i = 1, n = input.length(); i < n; i++) {
			if (input.charAt(i - 1) == ' ' && input.charAt(i) == ' ')
				return i;
		}
		return -1;
	}
}
