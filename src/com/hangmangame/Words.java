package com.hangmangame;

import java.util.Random;

public class Words {
	
	private String[] words = { "padre", "familia", "perro", "horoscopo", "abominacion" };
	private String palablaElegida;
	private Random rm = new Random();
	private char[] characters;
	
	
	
	public Words() {
		palablaElegida = words[rm.nextInt(words.length)];
		characters = new char[palablaElegida.length()];
		System.out.println(palablaElegida);
	};
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for(char c: characters) {
			sb.append(c == '\u0000'? '_': c);
			sb.append(' ');
		}
		
		return sb.toString();
	}


	//checks player char selected
	public boolean addGuess(char c) {
		boolean correct = false;
		
		for(int i = 0; i < palablaElegida.length(); i++) {
			if( c == palablaElegida.charAt(i)) {
				characters[i] = c;
				correct = true;
			}
		}
		return correct;
	}
	
	public boolean isComplete() {
		
		for(char c: characters) {
			if(c == '\u0000') {
				return false;
			}
		}
		return true;
		
	}
}
