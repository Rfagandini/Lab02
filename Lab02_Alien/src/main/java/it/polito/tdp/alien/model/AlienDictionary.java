package it.polito.tdp.alien.model;
import java. util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienDictionary {
	
	ArrayList<Word> ArrayWord = new ArrayList<Word>();
	TreeMap<String,Word> MapWord = new TreeMap<String,Word>();
	ArrayList<Word> ArrayChosenOnes = new ArrayList<Word>();
	
	String a;
	String b;
	boolean ValidWord = true;
	boolean JustCreated = false;
	//boolean JustModified = false;
	boolean JustAdded = false;
	boolean incognit = false;
	
	public boolean equals1(String word) {
		
		if(MapWord.size() > 0) {
			if(MapWord.get(word)!=null && ValidWord == true) {
			return true;
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	
	public String StringOutput(String word) {
		
		if(ValidWord == false) {
			return "The format of the given words and/or its translation is not valid";
		}
		
		else if(translateWord(word) == null) {
			return "This word is not in our DataBase, please add it first or try another one";
		}
		else if(JustCreated == true){
			return "A new Word ( "+a+" ) and its translation have been added to our DataBase";	
		}
		else if(equals1(a)==false && incognit == true) {
			return translateWord(word);
		}
		
		else if(equals1(a)==true) {
			return translateWord(word);
		}
		
		return "";
	}
	
	public boolean isAlpha(String str) {
		
		Pattern p = Pattern.compile("^[ ?a-zA-Z]*$");
		Matcher m = p.matcher(str);
		
		return m.matches();
	}
	
	public void AlphaCheck(String NewWord) {
		
		//JustModified = false;
		JustAdded = false;
		JustCreated = false;
		ValidWord = false;
		a = "";
		b = "";
				
		String str1 = NewWord.trim();
		String str = str1.replace("<", "");
		str = str.replace(">", "");
		str = str.toLowerCase();
		str = str.trim();
	
		if((str != null) && (!str.equals("")) && isAlpha(str)) {
			
			ValidWord = true;
			ArrayList<Word> ArrayCoincidenza = new ArrayList<Word>();
			ArrayList<CoincidenceWord> ArrayCoincidence = new ArrayList<CoincidenceWord>();
			if(str.contains(" ") && !str.contains("?")) {
			
				ControlWord(str);
				addWord(a,b);
				
			}
			
			else if(str.contains("?")) {
					
				incognit = true;
				
					for(Word w : ArrayWord) {
						if(w.getAlienWord().length() == str.length()) {
							ArrayCoincidenza.add(w);
							
						}
					}
					
					int counter = 0;
					int checkcounter = 0;
						
					for(Word w : ArrayCoincidenza) {
						counter = 0;
						checkcounter = 0;
						for(int i = 0 ; i < str.length() ; i++) {
							
							if(w.getAlienWord().charAt(i)==str.charAt(i)) {
								counter++;
							}
							if(str.charAt(i) == '?') {
								checkcounter++;
							}
							if(checkcounter > 1) {
								ValidWord = false;
							}
							
						}
		
						CoincidenceWord o = new CoincidenceWord(counter,w);
						ArrayCoincidence.add(o);
						
					}
					
					for(CoincidenceWord cw : ArrayCoincidence) {
						if(cw.getIndexofCoincidence() == str.length()-1) {
							ArrayChosenOnes.add(cw.getWord());
						}
					}
					
					ControlWord(str);
					
					if(b.contains("?")) {
						ValidWord = false;
					}
//					else {
//						
//						for(int j=0 ; j < ArrayChosenOnes.size() ; j++) {
//							
//						//	c[j] = ArrayChosenOnes.get(j).getAlienWord();
//							translateWord();
//							
//						}
//					}
					
					
				}
				
			else {
				
				if(MapWord.size()>0) {
					
					ControlWord(str);
					translateWord(a);
					
				}
			}
		}
		else {
			
			ValidWord = false;
			
		}
	}
	
	public void ControlWord(String NewWord) {
		
		String p[];
		
		if(NewWord.contains(" ")){
			p = NewWord.split(" ");
			a = p[0];
			b = p[1];
		}
		
		else {
			a = NewWord;
		}
		
	}
	
	public void addWord(String AlienWord, String Translation) {
		
		if(equals1(AlienWord)==false && ValidWord == true) {

			Word o = new Word(AlienWord,Translation);
			MapWord.put(AlienWord, o);
			ArrayWord.add(o);
			JustCreated = true;
			
		}
		else {
			MapWord.get(AlienWord).addTranslation(Translation);
			JustAdded = true;
			//JustModified = true;
		}
		
	}
	
	public String translateWord(String AlienWord) {
		
		if(equals1(AlienWord) == false && JustAdded == false && incognit == true ) {
			
			String aux = "";
			
			for(int i=0; i<ArrayChosenOnes.size() ; i++) {
				aux += ArrayChosenOnes.get(i).getAlienWord()+"\n";
			}
			
			return aux.trim();
		}
		else if(equals1(AlienWord) == true && JustAdded == false && incognit == false) {
			return MapWord.get(a).toString();
		}
		else if(equals1(AlienWord)==true && JustAdded == true) {
			return "A new translation of the word "+a+" has been added : "+MapWord.get(a).getTranslations();
		}
		else {
			return null;
		}
	}
	
	public String ShowAllMethod() {
		
		ArrayList<Word> AlienWordOrdine = new ArrayList<Word>(ArrayWord);
		String aux = "";
		Collections.sort(AlienWordOrdine);
		
		for(Word w: AlienWordOrdine) {
			
			aux += w.toString()+"\n";
			
		}
		
		
		return aux.trim();
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public boolean isValidWord() {
		return ValidWord;
	}

	public void setValidWord(boolean validWord) {
		ValidWord = validWord;
	}
	
	
	
}
