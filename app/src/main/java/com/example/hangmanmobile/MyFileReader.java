package com.example.hangmanmobile;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import android.content.Context;


public class MyFileReader {
	
	private Vector<String> words;
	BufferedReader reader;
	
	public MyFileReader( BufferedReader r) {
		words = new Vector<>();
		reader = r;
		readFile();
	}
	
	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min. max is "+max);
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private void readFile() {
		//read file, add all words to vector
		try  {
			String line;

			while ((line = reader.readLine()) != null) {
//				Log.d("test", "line is: "+line);
				if(line.length()>=5) {
					//only add words longer than 5 letters
					words.addElement(line);
//					System.out.println(line);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRandomWord() {
		int randNum = getRandomNumberInRange(0, words.size());
		return words.get(randNum);
	}

	/*
	public static void main(String[] args) {
		//test
		MyFileReader fileReader = new MyFileReader("words.txt");
		String word = fileReader.getRandomWord();
		
		System.out.println("the word is: "+word);
	}
	*/

}
