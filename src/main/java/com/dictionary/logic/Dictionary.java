package com.dictionary.logic;

public class Dictionary {

	public static String Dict[] = { "solve", "resolve", "level", "serve", "severe", "lever", "sore", "goal", "boy",
			"run", "resolver" };

	public static boolean isEnglishWord(String str) {

		// Root Node of Trie

		// insert all words of dictionary into trie
		int n = Dict.length;
		for (int i = 0; i < n; i++) {
			if (str.equals(Dict[i]))
				return true;

		}
		return false;

	}

}
