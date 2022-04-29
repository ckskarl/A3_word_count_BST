package applications;

import java.io.*;
import utilities.Iterator;
import java.util.Scanner;
import exceptions.*;
import structures.*;

/**
 * Application, which is a cross-reference program to constructs a binary search tree with all words includes from a text file.
 * it then records the line numbers on which these words were used.
 * The line numbers should be stored with the file names, which in turn are associated with the nodes of the tree.
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/12/2021
 */
public class WordTracker {
	static String option;
	static String fileOutputPath;
	static String fileInputPath;

	@SuppressWarnings("unchecked")
	/**
	 * Entry point to Java application.
	 * It parse the arguments in command line to check if they are valid.
	 * If valid, start the sorting process by initializing RunSort object.
	 * @param args user inputs in the command line
	 * @throws Exception when file is not found or arguments are incorrect format
	 */
	public static void main(String[] args) throws Exception {
		File repositoryFile = new File("repository.ser");
		BSTReferencedBased<Word> wordTrack=new BSTReferencedBased<Word>();
		BSTReferencedBased<Word> repository=new BSTReferencedBased<Word>();

		try {
			//parsing arguments from user input
			new WordTracker().parseArgs(args);

			//Scans in the new text file to read in the words
			File file = new File(fileInputPath);
			Scanner sc = new Scanner(file);
			int lineNumber = 0;


			//reads in the data from repository.ser, if it cannot find the file, create a new one
			try {
				ObjectInput ois = new ObjectInputStream(new FileInputStream(repositoryFile));
				ois.close();
			}catch (FileNotFoundException e) {
				wordTrack = new BSTReferencedBased<Word>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(repositoryFile));
				oos.writeObject(wordTrack);
				oos.close();
			}
			ObjectInput ois = new ObjectInputStream(new FileInputStream(repositoryFile));
			repository = (BSTReferencedBased<Word>) ois.readObject();
			//load the binary search tree from the repository.ser file read in
			wordTrack = repository;
			ois.close();

			//if user has given a file output path, the result is print to that file instead of terminal
			if (fileOutputPath!=null) {
				PrintStream fileOut = new PrintStream(fileOutputPath);
				System.setOut(fileOut);
			}

			//find words in the input file, if it is a new word, add it to new node of binary tree, if not add information to existing node
			while(sc.hasNextLine()) {
				//increments the line number after each line in the text file has been read
				lineNumber++;
				String lineText = (sc.nextLine()).toLowerCase().trim();
				for(int i = 0; i < lineText.length(); i++) {
					//remove all non alphabet characters but keeps the whitespace
					if(!Character.isLetter(lineText.charAt(i)) && !Character.isWhitespace(lineText.charAt(i))) {
						lineText = lineText.replace(lineText.charAt(i)+"", " ");
						lineText = lineText.replaceAll("\\s+"," ");
					}
				}
				for(String word: lineText.split("\\s")) {
					//create word object
					Word addWord = new Word(lineNumber, fileInputPath, word);
					//create binary search tree for new words
					if(wordTrack.search(addWord)==null){
						//wordInfo.add(addWord);
						wordTrack.add(addWord);
						System.out.println("Added new word: "+ addWord.getWord());
					}
					else {
						wordTrack.search(addWord).addInfo(addWord);
						System.out.println(addWord.getWord()+" is already exist in the list.");
					}
				}
			}

			//Writes the the binary search tree to the file repository.ser
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(repositoryFile));
			oos.writeObject(wordTrack);
			oos.close();
			sc.close();

			//print treee result in alphabetic order along with other information base on user option argument 
			wordTrack.inorderIterator();
			Iterator<Word> wordDisplay = wordTrack.inorderIterator();
			while(wordDisplay.hasNext()) {
				if (option.equals("o")||option.equals("f")||option.equals("l")){
					Word theWord = wordDisplay.next();
					System.out.println("\nWord: " + theWord.getWord());
					BSTNode<Word> target = wordTrack.search(theWord);

					java.util.Iterator<Word> it = target.getInfo().iterator();
					if (option.equals("o")) {
						System.out.println("   Frequency of occurence: "+target.getInfoSize());
					}
					while (it.hasNext()) {
						Word theWordInfo = it.next();
						System.out.println("   File path"+theWordInfo.getFileName());
						if (!option.equals("l")&&!option.equals("o")) {					
						}else {
							System.out.println("     Line:"+theWordInfo.getLineNumber());
						}
					}
				}else {
					throw new InvalidArgFormatException(option);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		} catch (InvalidNumOfArgException e) {

		} catch (InvalidArgFormatException e) {

		}

	}

	/**
	 * Argument Parser
	 * It read and count the input arguments.
	 * @param args the input read from command line
	 * @throws Exception throwing exception when the number of arg is greater than 3 or less then 0, OR if it is missing required arguments type. 
	 */
	private void parseArgs(String[] args) throws Exception {
		int fileOutputArgCount =0;
		int optionArgCount =0;
		int fileInputArgCount=0;
		if(args.length > 3 ||args.length==0) {
			throw new InvalidNumOfArgException(args.length);

		}else {

			for (int i=0;i<args.length;i++) {
				if(args[i].toLowerCase().substring(0,2).equals("-f")){
					fileOutputPath = args[i].substring(2).toLowerCase();
					fileOutputArgCount++;
				}else if(args[i].toLowerCase().substring(0,2).equals("-p") && args[i].length()==3){
					option = args[i].substring(2).toLowerCase();
					optionArgCount++;
				}else {
					fileInputPath = args[i];
					fileInputArgCount++;
				}
			}

			if (fileOutputArgCount>1 || optionArgCount!=1 ||fileInputArgCount!=1) {
				throw new InvalidArgFormatException(fileOutputArgCount,optionArgCount,fileInputArgCount);
			}

		}
	}
}
