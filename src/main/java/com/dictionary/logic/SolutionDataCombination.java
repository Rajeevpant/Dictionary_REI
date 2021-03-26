package com.dictionary.logic;

import java.util.HashSet;
import java.util.Set;

public class SolutionDataCombination {

	public Set<String> getDataSet(String sampleWord) {

		Set<String> wordsall = new HashSet<String>();
		Set<String> setDictionary = new HashSet<String>();
		DataCombination comb = new DataCombination();
		DataCombination.TrieNode root = comb.new TrieNode();
		boolean result = false;
		try {
			char arr[] = sampleWord.toLowerCase().toCharArray();

			// insert all words of dictionary into trie
			int n = Dictionary.Dict.length;
			for (int i = 0; i < n; i++)
				comb.insert(root, Dictionary.Dict[i]);
			if (Dictionary.isEnglishWord(sampleWord.toLowerCase())) {  //Validating if word entered for creating combinations are present in dictionary
				int N = arr.length;
				wordsall = comb.PrintAllWords(arr, root, N);
				for (String str : wordsall) {
					if (Dictionary.isEnglishWord(str)) { // Validating if the word is present in the dictionary
						setDictionary.add(str);
						result = true;
					}
				}
				if (result == false)

					System.out.println("Resulting words not in the dictionary");
			} else {
				System.out.println("Word entered for creating combination not in dictionary");
			}
		} catch (Exception e) {
			System.out.println("Not a valid dictionary word");

		}
		return setDictionary;

	}

}
