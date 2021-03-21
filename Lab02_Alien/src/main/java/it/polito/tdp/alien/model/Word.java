package it.polito.tdp.alien.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

public class Word implements Comparable<Word>{

	private String alienWord;
	//private String translation;
	ArrayList<String> Translation = new ArrayList<String>();
	
	public Word(String alienWord, String translation) {
		
		this.alienWord = alienWord;
		Translation.add(translation);
		
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public ArrayList<String> getTranslations() {
		
		return Translation;
	}

	public void addTranslation(String translation) {
		Translation.add(translation);
	}

	@Override
	public String toString() {
		
		String aux = "";
		ArrayList<String> Translationx = new ArrayList<String>(Translation);
		Collections.sort(Translationx);
		for(String s: Translationx) {
			aux += "the alienword "+this.alienWord+" translated is "+s+"\n";
		}
		
		return aux.trim();
	}

	@Override
	public int compareTo(Word o) {
		
		return this.alienWord.compareTo(o.getAlienWord());
	}
	
	
	
}
