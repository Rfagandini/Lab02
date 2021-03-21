package it.polito.tdp.alien.model;

public class CoincidenceWord {
	
	int IndexofCoincidence;
	Word word;
	
	public CoincidenceWord(int indexofCoincidence, Word word) {
		super();
		IndexofCoincidence = indexofCoincidence;
		this.word = word;
	}

	public int getIndexofCoincidence() {
		return IndexofCoincidence;
	}

	public void setIndexofCoincidence(int indexofCoincidence) {
		IndexofCoincidence = indexofCoincidence;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	
	
}
