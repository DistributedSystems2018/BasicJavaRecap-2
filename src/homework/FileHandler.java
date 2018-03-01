package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class FileHandler {

	private BufferedReader inputReader;
	private PrintWriter outputWriter;
	private FileOutputStream outputStream;

	public FileHandler(String inputPath, String outputPath) {

		File outputFile = new File(outputPath);

		try {
			outputFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try

		{
			inputReader = new BufferedReader(new FileReader(inputPath));
			outputStream = new FileOutputStream(outputFile);
			outputWriter = new PrintWriter(outputStream, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void copyContent() {
		String line;
		try {
			while ((line = inputReader.readLine()) != null) {
				writeToOutput(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyContentReverse() {
		String line;
		Stack<String> lines = new Stack<>();
		try {
			while ((line = inputReader.readLine()) != null) {
				lines.push(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!lines.isEmpty()) {
			writeToOutput(lines.pop());
		}

	}

	public void writeToOutput(String toWrite) {
		outputWriter.println(toWrite);
	}

	public void cleanup() {
		try {
			inputReader.close();
			outputStream.close();
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
