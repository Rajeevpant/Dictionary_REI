
package dictionary;

//import java.util.Dictionary;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import dictionary.Dictionary.TrieNode;

//import utilities.Dictionary;

public class WordResolver {
	String str;
	Scanner sc;

	@Test
public void matchWords()
	{ 
 Set<String> wordsnew=new HashSet<String>();
  sc = new Scanner(System.in); // System.in is a standard input stream
  System.out.print("Enter a string: ");
  str = sc.nextLine().toLowerCase();
  char arr[] = str.toCharArray();
  
  // Root Node of Trie 
  TrieNode root = new TrieNode();
  
  // insert all words of dictionary into trie
  int n = Dictionary.Dict.length;
  for (int i = 0; i < n; i++)
	  Dictionary.insert(root, Dictionary.Dict[i]);
  
  // char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;
  int N = arr.length;
  Assert.assertFalse(Dictionary.isEnglishWord(str),"Its not a valid word");
  wordsnew=Dictionary.PrintAllWords(arr, root, N);
  for(String str:wordsnew)
  System.out.println(str);
  }

	@AfterMethod
	public void tearup() {
		sc.close();
	}
}
