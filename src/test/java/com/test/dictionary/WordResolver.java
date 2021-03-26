package com.test.dictionary;

import org.testng.annotations.Test;

import com.dictionary.logic.SolutionDataCombination;

//import utilities.Dictionary;

public class WordResolver {
	String str;

	// Valid word search

	@Test
	public void matchValidWord() {
		// Root Node of Trie
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet("resolver"));

	}

	// Searching with null

	@Test
	public void matchnullWords() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet(null));

	}

	// Search with alphanumeric words

	@Test
	public void alphanumericWords() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet("abcd123"));

	}

	// Search term in capital letters

	@Test
	public void capitalLetters() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet("RESOLVER"));
	}

	// Search term appended with other characters

	@Test
	public void repeatedLetters() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet("ResolverResolver"));
	}
	// Blank search

	@Test
	public void emptyCharacter() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet(" "));
	}

	// Search with special characters

	@Test
	public void specialChar() {
		SolutionDataCombination sl = new SolutionDataCombination();
		System.out.println(sl.getDataSet("@#$%^&"));
	}

}
