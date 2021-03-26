package com.dictionary.logic;

import java.util.HashSet;
import java.util.Set;

public class DataCombination {
	int SIZE = 26;
	Set<String> words = new HashSet<String>();

	public class TrieNode {
		TrieNode[] Child = new TrieNode[SIZE];

		// isLeaf is true if the node represents
		// end of a word
		boolean leaf;

		// Constructor
		public TrieNode() {
			leaf = false;
			for (int i = 0; i < SIZE; i++)
				Child[i] = null;
		}
	}

// trie Node

	// If not present, inserts key into trie
	// If the key is prefix of trie node, just
	// marks leaf node
	public void insert(TrieNode root, String Key) {
		int n = Key.length();
		TrieNode pChild = root;

		for (int i = 0; i < n; i++) {
			int index = Key.charAt(i) - 'a';

			if (pChild.Child[index] == null)
				pChild.Child[index] = new TrieNode();

			pChild = pChild.Child[index];
		}
		// make last node as leaf node
		pChild.leaf = true;
	}

	// A recursive function to print all possible valid
	// words present in array
	public void searchWord(TrieNode root, boolean Hash[], String str) {
		// if we found word in trie / dictionary

		if (root.leaf == true) {
			words.add(str);
		}

		// traverse all child's of current root
		for (int K = 0; K < SIZE; K++) {
			if (Hash[K] == true && root.Child[K] != null) {
				// add current character
				char c = (char) (K + 'a');

				// Recursively search reaming character
				// of word in trie
				searchWord(root.Child[K], Hash, str + c);
			}
		}

	}

	// Prints all words present in dictionary.
	public Set<String> PrintAllWords(char Arr[], TrieNode root, int n) {

		// create a 'hash' array (Hash[]) that will store all present characters

		boolean[] Hash = new boolean[SIZE];

		for (int i = 0; i < n; i++)
			Hash[Arr[i] - 'a'] = true;

		// temporary node
		TrieNode pChild = root;

		// string to hold output
		String str = "";

		// Traverse all matrix elements. There are only
		// 26 character possible in char array
		for (int i = 0; i < SIZE; i++) {
			// we start searching for word in dictionary
			// if we found a character which is child
			// of Trie root
			if (Hash[i] == true && pChild.Child[i] != null) {
				str = str + (char) (i + 'a');
				searchWord(pChild.Child[i], Hash, str);
				str = "";
			}
		}

		return words; // Returning set of all the possible combinations of the string from dictionary

	}

}
