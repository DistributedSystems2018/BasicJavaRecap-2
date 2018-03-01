package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FileRegistry {

	private HashSet<String> fileNames;
	private ArrayList<FileContainer> fileNumbers;
	private BufferedReader reader;

	public FileRegistry(String path) {
		fileNames = new HashSet<>();
		fileNumbers = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				fileNames.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		bufferFileNumbers();

	}

	private void bufferFileNumbers() {
		for (String fileName : fileNames) {
			try {
				fileNumbers.add(new FileContainer(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void findSmallestNumber() {
		int smallestOverall = fileNumbers.get(0).getSmallestNumber();
		String smallestName = fileNumbers.get(0).getName();
		for (int i = 1; i < fileNumbers.size(); i++) {
			int temp = fileNumbers.get(i).getSmallestNumber();
			if (temp < smallestOverall) {
				smallestOverall = temp;
				smallestName = fileNumbers.get(i).getName();
			}
		}
		System.out.println("File with lowest number:");
		System.out.println(smallestName);
	}

	public void findFilesWithoutDuplicates() {
		System.out.println("Files without duplicates:");
		for (FileContainer file : fileNumbers) {
			if (!file.containsDuplicates()) {
				System.out.println(file.getName());
			}
		}
	}

	public void sumAllFiles() {
		int sum = 0;
		for (FileContainer file : fileNumbers) {
			sum += file.getSum();
		}
		System.out.println(sum);
	}

	public void filesWithSumsSorted() {
		Map<Integer, String> sortedMap = new TreeMap<>();
		for (FileContainer file : fileNumbers) {
			sortedMap.put(file.getSum(), file.getName());
		}

		for (Entry<Integer, String> mapEntry : sortedMap.entrySet()) {
			System.out.println("File: " + mapEntry.getValue() + " has sum : " + mapEntry.getKey());
		}

	}

}
