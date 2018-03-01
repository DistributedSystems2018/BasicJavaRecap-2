package com.elte;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1

        String[] argsCoordinates = {"2.4","2", "1", "1", "10", "9.8", "-9", "-9.8"};
        List<Coordinate> coords = parseCoordinatesFromCommandLine(argsCoordinates);

        System.out.println("\nNumber 1:\n");
        Coordinate auxiliarCoord = new Coordinate(0f,0f);

        for (Coordinate coord : coords) {
            if (coord.getDistanceFrom(new Coordinate(0,0)) > auxiliarCoord.getDistanceFrom(new Coordinate(0,0))){
                auxiliarCoord = coord;
            }
        }

        System.out.println("Furthest point from (0,0) is: " + auxiliarCoord);

        // 2
        System.out.println("\nNumber 2:\n");

        auxiliarCoord = coords.get(0);

        for (int i = 1; i < coords.size(); i++) {
            if (coords.get(i).getDistanceFrom(coords.get(0)) > auxiliarCoord.getDistanceFrom(coords.get(0))){
                auxiliarCoord = coords.get(i);
            }
        }

        System.out.println("Furthest point from " + coords.get(0) + " is: " + auxiliarCoord);

        // 3
        System.out.println("\nNumber 3:\n");

        String[] argsA = {"aajsdvhaaaaj","aaa3321asd", "1asssaaasda", "1asasassasasasasasaas"};

        System.out.println("Without repetition: ");
        for (String arg : argsA){
            System.out.println(arg.replaceAll("[a]+", "a"));
        }

        // 4
        System.out.println("\nNumber 4:\n");

        String[] argsText = {"My name is Pedro. I am 20 years old.","y0", "a1", "m6"};

        String text = argsText[0];

        for (int i = 1; i < argsText.length; i++){
            text = text.replaceAll(String.valueOf((argsText[i].toCharArray())[0]),
                    String.valueOf((argsText[i].toCharArray())[1]));
        }

        System.out.println("Text after alterations: " + text);

        // 5
        System.out.println("\nNumber 5:\n");

        int argsN = 10;

        System.out.print("Pascal's up to " + argsN + " row: \n");
        for (int i = 1 ; i < argsN; i++){
            for (Integer element: getRowPascalTriangle(i)) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // 6
        System.out.println("\nNumber 6:\n");

        String[] argsBoard = {"10","20", "3", "3.2", "4", "2", "9.9", "19.9", "6", "0", "3", "17", "4", "9"};

        Board board = new Board(Integer.parseInt(argsBoard[0]),Integer.parseInt(argsBoard[1]));
        coords = parseCoordinatesFromCommandLine(Arrays.copyOfRange(argsBoard, 2, argsBoard.length));
        if (board.markHitFields(coords)){
            System.out.println("All coordinates are valid.\n Printing board:");
        }else{
            System.out.println("One or more coordinates aren't valid.\n Printing board:");
        }
        System.out.println(board);

        // 7
        System.out.println("\nNumber 7:\n");

        String[] argsTournament = {"8", "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8",
                "1", "1", "1", "2", "1", "2", "2"};

        Tournament t1 = new Tournament(argsTournament);
        t1.printMatches();

        // Homework
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHomework - Number 1:\n");

        // 1
        System.out.println("Type anything:");
        String nextLine1 = sc.nextLine();
        System.out.println(nextLine1);


        System.out.println("Type two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum: " + (a + b));

        sc.nextLine();
        System.out.println("Type a phrase:");
        String nextLine2 = sc.nextLine();
        System.out.println("Number of characters: " + nextLine2.toCharArray().length);
        System.out.println("Number of words: " + nextLine2.split("[ ]+").length);

        System.out.println("Type a number for Fibonacci and Pascal calculation: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci's " + n + " number: " + getNthFib(n));
        System.out.print("Pascal's " + n + " row: ");
        for (Integer element: getRowPascalTriangle(n)) {
            System.out.print(element + " ");
        }
        System.out.println();


        // 2
        System.out.println("\nHomework - Number 2:\n");

        PrintWriter pw1;
        PrintWriter pw2;

        try {
            sc.close();
            sc = new Scanner(new File("src/dummy1.txt"));
            pw1 = new PrintWriter("src/dummy2.txt");
            pw2 = new PrintWriter("src/dummy3.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading/writing on files.");
            e.printStackTrace();
            return;
        }

        // Normal
        while (sc.hasNext()){
            pw1.println(sc.nextLine());
        }
        pw1.close();

        sc.close();
        try{sc = new Scanner(new File("src/dummy1.txt"));} catch (FileNotFoundException e){e.printStackTrace();return;}

        // Reversed
        Stack<Character> stack = new Stack<>();
        while (sc.hasNext()){
            for (Character c : sc.nextLine().toCharArray()){
                stack.push(c);
            }
            stack.push('\n');
        }

        while (!stack.empty()){
            pw2.print(stack.pop());
        }

        pw2.close();
        sc.close();

        System.out.println("Finished copying to files.");


        // 3
        System.out.println("\nHomework - Number 3:\n");

        try{sc = new Scanner(new File("src/filenames.txt"));} catch (FileNotFoundException e){e.printStackTrace();return;}

        List<String> filenames = new ArrayList<>();

        while(sc.hasNext()){
            filenames.add(sc.nextLine());
        }

        sc.close();

        Integer smallestNumber = Integer.MAX_VALUE;
        int smallestNumberIndex = -1;
        List<Integer> allNumbers = new ArrayList<>();
        Set<Integer> auxSet = new HashSet<>();
        List<Integer> nonDuplicateFilenamesIndexes = new ArrayList<>();
        Map< String ,Integer > fileSums = new HashMap<>();

        for (int i = 0; i < filenames.size(); i++){
            try{sc = new Scanner(new File(filenames.get(i)));} catch (FileNotFoundException e){e.printStackTrace();return;}
            int sum = 0;
            while (sc.hasNext()){
                int nextInt = sc.nextInt();
                allNumbers.add(nextInt);
                auxSet.add(nextInt);
                sum += nextInt;

                if (nextInt < smallestNumber){
                    smallestNumber = nextInt;
                    smallestNumberIndex = i;
                }
            }

            fileSums.put(filenames.get(i), sum);
            if (auxSet.size() == allNumbers.size()){
                nonDuplicateFilenamesIndexes.add(i);
            }
            auxSet.clear();
            allNumbers.clear();
        }

        ComparatorInts cp = new ComparatorInts(fileSums);

        Map< String ,Integer > orderedMap = new TreeMap<>(cp);
        orderedMap.putAll(fileSums);


        System.out.println("Smallest number filename: " + filenames.get(smallestNumberIndex));
        System.out.print("Non duplicate filenames: ");
        for (Integer index : nonDuplicateFilenamesIndexes){
            System.out.print(filenames.get(index) + " ");
        }
        System.out.println();
        System.out.println("Sum of filenames by increasing order: ");
        for (String filename: orderedMap.keySet()) {
            System.out.println("Filename: " + filename + " Sum: " + fileSums.get(filename));
        }



    }

    private static List<Integer> getRowPascalTriangle(int n){
        List<Integer> row = new ArrayList<>();

        row.add(1);

        for (int k = 0; k < n; k++){
            row.add(row.get(k) * (n - k) / (k + 1));
        }

        return row;
    }

    private static int getNthFib(int n){
        int i = 0;
        int j = 1;

        for (int k = 2; k < n; k++){
            int aux = j;
            j  = i + j;
            i = aux;
        }
        return j;
    }

    public static List<Coordinate> parseCoordinatesFromCommandLine(String[] s){
        // Adding coordinates from command-line
        List<Coordinate> coords = new ArrayList<>();

        double aux = 0f;
        for (int i = 1; i <= s.length; i++) {
            if (i % 2 == 0) {
                coords.add(new Coordinate(aux, Double.parseDouble(s[i - 1])));
            } else {
                aux = Double.parseDouble(s[i - 1]);
            }
        }
        return coords;
    }
}

