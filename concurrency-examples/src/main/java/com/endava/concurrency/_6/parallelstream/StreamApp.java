package com.endava.concurrency._6.parallelstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamApp {

	public static void main(String[] args) {
		readFilePrint("pg103.txt");
		readFileProcess("pg103.txt");


		readFileProcessCountParallel("pg103.txt", "Speedy");
		readFileProcessCountParallel("pg104.txt", "Henrietta");


	}

	/**
	 * read a file and print the content in the console
	 * using streams
	 * @param fileName
	 */
	public static void readFilePrint(String fileName) {
		
		ClassLoader classLoader = StreamApp.class.getClassLoader();
		
		//read file into stream, try-with-resources
		System.out.println("classLoader.getResource(fileName).getFile() : " + classLoader.getResource(fileName).getFile().substring(1));
		try (Stream<String> stream = Files.lines(Paths.get(classLoader.getResource(fileName).getFile().substring(1)))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * counting distinct words from the file
	 * @param fileName
	 */
	public static void readFileProcess(String fileName) {
		ClassLoader classLoader = StreamApp.class.getClassLoader();
		
		long uniqueWords = 0;
		try {
			uniqueWords = Files.lines(Paths.get(classLoader.getResource(fileName).getFile().substring(1)))
			        .flatMap(line -> Arrays.stream(line.split(" ")))
			        .distinct()
			        .count();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("uniqueWords: " + uniqueWords);
		
	}
	
	/**
	 * 
	 * @param fileName filename from resource folder
	 * @param strToCount the word to be search and count
	 */
	public static void readFileProcessCountParallel(String fileName, String strToCount) {
		ClassLoader classLoader = StreamApp.class.getClassLoader();
		Long speedy = 0L;
		try {
			speedy = Files.lines(Paths.get(classLoader.getResource(fileName).getFile().substring(1)))
					.flatMap(line -> Arrays.stream(line.split(" ")))
					.parallel()
					.filter(s -> s.trim().contains(strToCount))
					.count();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		System.out.println(strToCount + ": " + speedy);

	}

}
