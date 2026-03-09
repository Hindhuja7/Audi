// Design and implement a Trie (Prefix Tree) to store a collection of lowercase 
// words (a–z).
// The Trie should allow duplicate word insertions and maintain the frequency of 
// each word using a counter at the EndOfWord node.

// The program should perform the following operations:
// -Insert Words
// -Display Words with Frequency
// -Delete a Word
// When a word is deleted, decrease its frequency by 1.
// If the frequency becomes 0, remove the word completely from the Trie.
// Display Updated Frequencies
// After deletion, print the updated list of words and their frequencies.
// -Exit the program.

// Example:
// --------
// Enter words:
// hell hello and and and hell and and and

// Words with Frequency:
// and : 6
// hell : 2
// hello : 1

// 1.Delete Word
// 2.Display
// 3.Exit
// 1
// Enter word to delete:
// and

// Updated Trie:
// and : 5
// hell : 2
// hello : 1




// import java.util.*;

// class Trie
// {
//     static final int NUM_CHARS = 26;

//     // Trie Node
//     static class TrieNode
//     {
//         TrieNode[] children = new TrieNode[NUM_CHARS];
//         boolean isEndOfWord;
//         int frequency;

//         TrieNode()
//         {
//             // initialize node
//         }
//     }

//     static TrieNode root;

//     // Method to insert a word into the Trie
//     static void insertWord(String word)
//     {

//     }

//     // Method to delete a word from the Trie
//     static TrieNode deleteWord(TrieNode root, String word, int depth)
//     {

//         return root;
//     }

//     // Method to check whether a node has children
//     static boolean hasChildren(TrieNode node)
//     {

//         return false;
//     }

//     // Method to display all words with their frequencies
//     static void displayWordsWithFrequency(TrieNode root, char[] word, int level)
//     {

//     }

//     // Method to build the Trie from input words
//     static void buildTrie(String[] words)
//     {

//     }

//     public static void main(String args[])
//     {
//         Scanner sc = new Scanner(System.in);
//         root = new TrieNode();

//         System.out.println("Enter words:");
//         String[] words = sc.nextLine().split(" ");

//         buildTrie(words);

//         char[] word = new char[50];

//         while(true)
//         {
//             System.out.println("\nMenu");
//             System.out.println("1. Insert Word");
//             System.out.println("2. Delete Word");
//             System.out.println("3. Display Words with Frequency");
//             System.out.println("4. Exit");

//             int choice = sc.nextInt();
//             sc.nextLine();

//             switch(choice)
//             {
//                 case 1:
//                     System.out.println("Enter word to insert:");
//                     String insertWord = sc.nextLine();
//                     insertWord(insertWord);
//                     break;

//                 case 2:
//                     System.out.println("Enter word to delete:");
//                     String deleteWord = sc.nextLine();
//                     root = deleteWord(root, deleteWord, 0);
//                     break;

//                 case 3:
//                     System.out.println("\nWords with Frequency:");
//                     displayWordsWithFrequency(root, word, 0);
//                     break;

//                 case 4:
//                     System.out.println("Exiting program...");
//                     System.exit(0);
//             }
//         }
//     }
// }
// package trees;

// public class word_count_trie {
    
// }
