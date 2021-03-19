package dictionary;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	static final int SIZE = 26;
	static String Dict[] = { "solve", "resolve", "serve","severe","lever", "sore","goal", "boy", "run" };
    static Set<String> words=new HashSet<String>();
	// trie Node
	static class TrieNode {
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

	// If not present, inserts key into trie
	// If the key is prefix of trie node, just
	// marks leaf node
	static void insert(TrieNode root, String Key) {
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

	static boolean isEnglishWord(String str) {
		

		// Root Node of Trie
		

		// insert all words of dictionary into trie
		int n = Dict.length;
		for (int i = 0; i < n; i++)
		{		
		if(str.equals(Dict[i]))
			return false;
		
		}
		return true;
		

	}

	// A recursive function to print all possible valid
	// words present in array
	static void searchWord(TrieNode root, boolean Hash[], String str) {
		// if we found word in trie / dictionary
		
		if (root.leaf == true)
		{
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
	static Set<String> PrintAllWords(char Arr[], TrieNode root, int n) {
		// create a 'has' array that will store all
		// present character in Arr[]
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
		
		return words;
	
	}

}
