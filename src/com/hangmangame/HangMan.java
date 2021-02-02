package com.hangmangame;

import java.util.Scanner;

public class HangMan {

	private boolean running = true;
	private Words w = new Words();
	private Scanner scanner = new Scanner(System.in);
	private int triesRemaining= 6;
	private char lastGuess;

	public void run() {
		
		do {
			displayWord();
			getUserInput();
			checkUserInput();
		} while (running);
	}

	private void checkUserInput() {
		boolean isCorrect = w.addGuess(lastGuess);
		
		if (isCorrect) {
			if( w.isComplete()) {
				System.out.println("You have won");
				System.out.println("La palabla es: " + w);
				running = false;
			}
		}else {
			triesRemaining--;
			if(this.triesRemaining == 0) {
				System.out.println("No tienes mas intentos, JUEGO TERMINADO");
				running = false;
			}
		}
		

		
		
	}

	private void getUserInput() {

		try {
			System.out.println("Intentos restantes: " + triesRemaining);
			System.out.println("Ingrese Letra \n");
			String letra = scanner.nextLine();
			w.addGuess(letra.charAt(0));
			lastGuess = letra.charAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void displayWord() {
		System.out.println(w);
	}

	public void close() {
		scanner.close();
	};

}
