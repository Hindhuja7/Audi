
// An 8th standard student has been assigned a task as part of punishment for his mistake.

// The task is, there is an input string STR(without any space) and an array of 
// strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
// index and ending index of every string in words[] in the input string STR.

// Note: Print the pairs[s, e] in sorted order.
// (i.e., sort them by their first coordinate, and in case of ties sort them by 
// their second coordinate).

// Input Format
// ------------
// Line-1: string STR(without any space)
// Line-2: space separated strings, words[]

// Output Format
// -------------
// Print the pairs[s, e] in sorted order.


// Sample Input-1:
// ---------------
// thekmecandngitcolleges
// kmec ngit colleges

// Sample Output-1:
// ----------------
// 3 6
// 10 13
// 14 21


// Sample Input-2:
// ---------------
// xyxyx
// xyx xy

// Sample Output-2:
// ----------------
// 0 1
// 0 2
// 2 3
// 2 4

// Explanation: 
// ------------
// Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


// Sample Input-3:
// ---------------
// kmecngitkmitarecsecolleges
// kmit ngit kmec cse

// Sample Output-3:
// ----------------
// 0 3
// 4 7
// 8 11
// 15 17

import java.util.*;
public class IndexPairs{
   

    // Trie Node Structure
    static class TrieNode
    {
        TrieNode[] children=new TrieNode[26];
        boolean endOfWord=false;
    }

    static TrieNode root;

    // Insert word into Trie
    static void insert(String key)
    {
        TrieNode current=root;
        // Write logic to insert word
        for(int i=0;i<key.length();i++)
        {
             int k=key.charAt(i)-'a';
            if(current.children[k]==null)
            {
                current.children[k]=new TrieNode();
            }
            current=current.children[k];
        }
        current.endOfWord=true;
    }
    static void search(String key)
    {
        for(int i=0;i<key.length();i++)
        {
            TrieNode current=root;
            for(int j=i;j<key.length();j++)
            {
                int index=key.charAt(j)-'a';
                if(current.children[index]==null)
                {
                    break;
                }
                current=current.children[index];
                if(current.endOfWord)
                {
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String keys[] = sc.nextLine().split(" ");
        root = new TrieNode();
        for(int i = 0; i < keys.length; i++)
        {
            insert(keys[i]);
        }
        search(s);
    }
}