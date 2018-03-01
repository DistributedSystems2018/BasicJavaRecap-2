package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FileContainer {

	private String filename;
	private ArrayList<Integer> fileNumber;
	private int sum;

	public FileContainer(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		sum = 0;
		filename = path;
		fileNumber = new ArrayList<>();
		try {
			String[] tokens = reader.readLine().split(",");

			for (String token : tokens) {
				int num = Integer.parseInt(token);
				fileNumber.add(num);
				sum += num;
			}
		} catch (NumberFormatException e) {
			System.out.println("File contains unexpected element!");
		}
		reader.close();
	}

	public int getSmallestNumber() {
		int smallestNum = fileNumber.get(0);
		for (int i = 1; i < fileNumber.size(); i++) {
			if (fileNumber.get(i) < smallestNum) {
				smallestNum = fileNumber.get(i);
			}
		}
		return smallestNum;
	}

	public int getSum() {
		return sum;
	}

	public String getName() {
		return filename;
	}

	public boolean containsDuplicates() {
		Set<Integer> asSet = new HashSet<>(fileNumber);
		return (fileNumber.size() != asSet.size());
	}

	public ArrayList<Integer> getSortedArr() {
		ArrayList<Integer> sorted = fileNumber;
		Collections.sort(sorted);
		return sorted;
	}

}
