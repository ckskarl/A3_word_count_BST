package structures;

import java.io.Serializable;

/**
 * This class constructs the word object that is instantiated and used by the
 * WordTracker and used throughout the program. Each Word object holds relevant
 * information on the what the specific word is, which file the word was found
 * in, and what line of the file the word was found.
 * 
 * @author Alex Fleury, Christian Lay, Brandon Donkersloot, Kin Shing Chong
 *
 */
public class Word implements Comparable<Word>, Serializable {

	private static final long serialVersionUID = 1L;
	int lineNumber;
	String fileName = "";
	String word = "";

	/**
	 * Return the line number value of the Word object.
	 * 
	 * @return lineNumber is the document line number location
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Sets the lineNumber the word was located on in the document being read based
	 * on the document line number.
	 * 
	 * @param lineNumber is the document line number location
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * Return the file name value of Word object.
	 * 
	 * @return fileName is the document name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the fileName to the document name that the word is being read from.
	 * 
	 * @param fileName is the file name of the current document
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Returns the word value of the Word object.
	 * 
	 * @return word is the Word object word attribute
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Sets the word of the Word object to the current word being read.
	 * 
	 * @param word is the value read from the current document
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Constructor of the Word object that sets all attribute values to the current
	 * data being read.
	 * 
	 * @param lineNumber value of the current line in the document
	 * @param fileName   value of the name in the current document
	 * @param word       value of the current word in the document
	 */
	public Word(int lineNumber, String fileName, String word) {
		super();
		this.lineNumber = lineNumber;
		this.fileName = fileName;
		this.word = word;
	}

	/**
	 * Constructor of Word object that only sets the word attribute to the current
	 * data being read.
	 * 
	 * @param word String of the current word in the document
	 */
	public Word(String word) {
		this.word = word;
	}

	/**
	 * Compares the current Word object to a second Word object.
	 * 
	 * @param anotherWord Word object that is being compared to
	 * @return integer value: 0 if Word objects are equal,less than 0 if the parameter
	 *         object is less than the first, >0 if the parameter object is greater
	 */
	@Override
	public int compareTo(Word anotherWord) {
		return this.word.compareTo(anotherWord.word);
	}

	/**
	 * Returns the string value of the Word object.
	 * 
	 * @return Word object string value
	 */
	@Override
	public String toString() {
		return this.getWord();
	}

}
