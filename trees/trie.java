
// // // // 1. Write a Java program to implement a Trie (Prefix Tree) that stores a set of 
// // // // lowercase English words.
// // // // The program should support operations such as Insert, Search, Delete and Display.

// // // // Initially, the program reads a line containing words separated by spaces and 
// // // // inserts them into the Trie.
// // // // After constructing the Trie, the program should repeatedly accept numeric 
// // // // options from the user to perform the following operations:

// // // // 1.Insert – Insert a new word into the Trie.
// // // // 2.Search – Check whether a given word exists in the Trie.
// // // // 3.Delete – Delete a word from the Trie if it exists.
// // // // 4.Display – Display all the words currently stored in the Trie.
// // // // 5.Exit – Terminate the program.

// // // // All words consist only of lowercase English letters (a–z).

// // // // Input Format:
// // // // ------------
// // // // - A list of words separated by spaces to initialize the Trie.
// // // // - A number representing the operation to be performed.
// // // // - If the option is 1, 2, or 3, the next input will be a word related to that 
// // // // operation.
// // // // - The last input will always be 5, which terminates the program.

// // // // Output Format:
// // // // -------------
// // // // - The program should display appropriate messages based on the operation 
// // // // performed.
// // // // - After Insert, display the updated content of the Trie.
// // // // - For Search, print whether the word is present or not.
// // // // - After Delete print whether deletion was successful and display the updated 
// // // // Trie.
// // // // - For Display, print all words currently stored in the Trie.

// // // // Example 1:
// // // // ---------
// // // // Input
// // // // -----
// // // // apple ape ant animal
// // // // 4
// // // // 2 apple
// // // // 1 ball
// // // // 3 ape
// // // // 4
// // // // 5

// // // // Output
// // // // ------
// // // // //(4)
// // // // Content of Trie:
// // // // animal
// // // // ant
// // // // ape
// // // // apple

// // // // //(2)
// // // // apple is present

// // // // //(1)
// // // // Content of Trie:
// // // // animal
// // // // ant
// // // // ape
// // // // apple
// // // // ball

// // // // //(3)
// // // // ape is deleted

// // // // //(3)
// // // // Content of Trie after deletion:
// // // // animal
// // // // ant
// // // // apple
// // // // ball

// // // // //(4)
// // // // Content of Trie:
// // // // animal
// // // // ant
// // // // apple




// // import java.util.*;

// // public class trie
// // {
// //     static final int NUM_CHARS = 26;
// //     static boolean isDeleted = false;

// //     // Trie Node Structure
// //     static class TrieNode
// //     {
// //         TrieNode[] children;
// //         boolean endOfWord;

// //         TrieNode()
// //         {
// //             // Initialize children array and isEndOfWord
// //         }
// //     }

// //     static TrieNode root;

// //     // Insert word into Trie
// //     static void insert(String key)
// //     {
// //         TrieNode current=root;
// //         // Write logic to insert word
// //         for(int i=0;i<key.length();i++)
// //         {
// //              int k=key.charAt(i)-'a';
// //             if(current.children[k]==null)
// //             {
// //                 current.children[k]=new TrieNode();
// //             }
// //             current=current.children[k];
// //         }
// //         current.endOfWord=true;
// //     }

// //     // Search word in Trie
// //     static boolean search(String key)
// //     {
// //         // Write logic to search word
// //           TrieNode current=root;
// //         // Write logic to insert word
// //         for(int i=0;i<key.length();i++)
// //         {
// //              int k=key.charAt(i)-'a';
// //             if(current.children[k]==null)
// //             {
// //                 return false;
// //             }
// //             current=current.children[k];
// //         }
// //         return current.endOfWord=true;
// //     }

// //     // Check if node has children
// //     static boolean isEmpty(TrieNode root)
// //     {
// //         TrieNode current=root;
// //         // Write logic
// //         for(int i=0;i<26;i++)
// //         {
// //             if(current.children[i]!=null)
// //             {
// //                 return false;
// //             }
// //         }
// //         return true;;
// //     }

// //     // Delete word from Trie
// //     static TrieNode delete(TrieNode root, String key, int depth)
// //     {
// //         TrieNode current=root;
// //         int index=key.charAt(depth)-'a';
// //         if(current.children[index]==null)
// //         {
// //             return null;
// //         }
// //         if(depth==key.length())
// //         {
// //             current.endOfWord=false;
// //             if(current.children[index]==null)
// //             {
// //                 return null;
// //             }
// //         }
// //         if(current.children[index]!=null)
// //         {
// //             current.children[index]=delete(current.children[index],key,depth+1);
// //         }
// //         if(isEmpty(current) && current.endOfWord==false)
// //         {
// //            return null;
// //         }
// //         // Write logic to delete word
// //         return current;
// //     }

// //     // Check if node is leaf
// //     static boolean isLeafNode(TrieNode root)
// //     {
// //         // Write logic
// //         for(int i=0;i<26;i++)
// //         {
// //             if(root.children[i]!=null)
// //             {
// //                 return false;
// //             }
// //         }
// //         return true;
// //     }

// //     // Display words in Trie
// //     public 

// //     public static void main(String args[])
// //     {
// //         Scanner sc = new Scanner(System.in);

// //         // Read initial words
// //         String keys[] = sc.nextLine().split(" ");

// //         root = new TrieNode();

// //         // Construct Trie
// //         for(int i = 0; i < keys.length; i++)
// //         {
// //             insert(keys[i]);
// //         }

// //         char[] str = new char[50];
// //         String word;

// //         while(true)
// //         {
// //             System.out.println("Enter option:");
// //             System.out.println("1. Insert");
// //             System.out.println("2. Search");
// //             System.out.println("3. Delete");
// //             System.out.println("4. Display");
// //             System.out.println("5. Exit");

// //             int opt = sc.nextInt();
// //             sc.nextLine();

// //             // Write menu handling logic
// //         }
// //     }


// import java.util.*;

// public class IndexPairs {

//     // Trie Node
//     static class TrieNode {
//         TrieNode[] children = new TrieNode[26];
//         boolean isEndOfWord = false;
//     }

//     TrieNode root = new TrieNode();

//     // Insert word into Trie
//     private void insert(String word) {
//         TrieNode node = root;

//         for (char c : word.toCharArray()) {
//             int idx = c - 'a';

//             if (node.children[idx] == null) {
//                 node.children[idx] = new TrieNode();
//             }

//             node = node.children[idx];
//         }

//         node.isEndOfWord = true;
//     }

//     // Main function
//     public List<int[]> indexPairs(String text, String[] words) {

//         // Step 1: Build Trie
//         for (String word : words) {
//             insert(word);
//         }

//         List<int[]> result = new ArrayList<>();

//         // Step 2: Traverse text
//         for (int i = 0; i < text.length(); i++) {

//             TrieNode node = root;

//             for (int j = i; j < text.length(); j++) {

//                 int idx = text.charAt(j) - 'a';

//                 // If no path → stop
//                 if (node.children[idx] == null)
//                     break;

//                 node = node.children[idx];

//                 // If word ends → add pair
//                 if (node.isEndOfWord) {
//                     result.add(new int[]{i, j});
//                 }
//             }
//         }

//         return result;
//     }

//     // Print result
//     private static void printResult(List<int[]> pairs) {
//         System.out.print("[");
//         for (int i = 0; i < pairs.size(); i++) {
//             System.out.print("[" + pairs.get(i)[0] + "," + pairs.get(i)[1] + "]");
//             if (i != pairs.size() - 1)
//                 System.out.print(", ");
//         }
//         System.out.println("]");
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         String text = sc.nextLine();
//         String[] words = sc.nextLine().split(" ");

//         IndexPairs obj = new IndexPairs();

//         List<int[]> result = obj.indexPairs(text, words);

//         printResult(result);
//     }
// }



import java.util.*;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // INSERT
    void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }

        node.setEnd();
    }

    // CHECK ALL PREFIXES
    boolean checkAllPrefixes(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);

            // important check
            if (!node.isEnd()) {
                return false;
            }
        }

        return true;
    }
}

public class LongestWord {

    public static String completeString(String[] words) {

        Trie trie = new Trie();

        // Step 1: insert all words
        for (String word : words) {
            trie.insert(word);
        }

        String longest = "";

        // Step 2: check each word
        for (String word : words) {

            if (trie.checkAllPrefixes(word)) {

                if (word.length() > longest.length() ||
                   (word.length() == longest.length() && word.compareTo(longest) < 0)) {

                    longest = word;
                }
            }
        }

        // Step 3: return result
        return longest.equals("") ? "None" : longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        System.out.println(completeString(words));
    }
}