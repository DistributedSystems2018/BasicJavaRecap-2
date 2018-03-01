package maincode;

import homework.FileHandler;
import homework.FileRegistry;
import homework.IOHandler;

public class Main {

	public static void main(String[] args) {
		// Coordinates as single string
		CoordinateParser cp;
		String coords = "1,2,3,4,5,6,7,8";
		cp = new CoordinateParser(coords);
		cp.findFurthestAway();
		cp.findClosestToFirst();
		System.out.println("--------------------------");
		StringModifier.replaceA("aabbaaaaacaaaahaajakwhaaa");

		String someText = "Hey I am Jonas";
		char changeFrom = 'a';
		char changeTo = 'e';
		String edited = someText.replace(changeFrom, changeTo);
		System.out.println(edited);
		System.out.println("--------------------------");
		Pascal.triangle(4);
		System.out.println("--------------------------");
		Board board = new Board(8, 8);
		board.shootBoardWithArgs(coords);
		System.out.println("--------------------------");
		String[] gameArgs = { "8", "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "1", "1", "1", "2", "1", "2", "2" };
		Tournament t = new Tournament(gameArgs);
		t.playAllRounds();

		System.out.println("--------------------------");

		IOHandler handler = new IOHandler();
		handler.readIO();
		handler.sumIO();
		handler.printIOLength();
		handler.countWordsIO();
		handler.printFibAndPascal();

		// Make sure input text file exists, otherwise exception is thrown
		// Expecting first FileHandler param to contain existing file, otherwise
		// will terminate
		FileHandler fileHandler = new FileHandler("inputfilepath", "outputfilepath");
		fileHandler.copyContent();
		fileHandler.cleanup();
		FileHandler fileHandler2 = new FileHandler("inputfilepath", "outputfilepath");
		fileHandler2.copyContentReverse();
		fileHandler2.cleanup();
		// Give file containing filepaths. All files in registry file expected
		// to contain only integers separated by commas. (new line is fine)
		FileRegistry reg = new FileRegistry("registryfilepath");
		reg.findSmallestNumber();
		reg.findFilesWithoutDuplicates();
		reg.filesWithSumsSorted();

	}

}
