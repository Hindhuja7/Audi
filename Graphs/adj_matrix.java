
// Write a program to implement a Graph using an Adjacency Matrix.
// The program should allow the following operations:

// 1. Add an edge between two vertices.

// 2. Remove an edge between two vertices.

// 3. Check whether an edge exists between two vertices.

// 4. Display the adjacency matrix representation of the graph.

// The graph is undirected, meaning if there is an edge between vertex i and 
// vertex j, then there is also an edge between j and i.

// Example 1:
// ----------
// Input:
// -----
// Vertices = 4
// Edges added:
// 0 1
// 1 2
// 2 0
// 1 3
// Edge checks:
// 0 1
// 0 3
// Edge removed:
// 1 2

// Output:
// ------
// Graph Representation (Adjacency Matrix):
// 0 1 1 0
// 1 0 1 1
// 1 1 0 0
// 0 1 0 0
// Checking if there's an edge between vertices 0 and 1: true
// Checking if there's an edge between vertices 0 and 3: false
// After removing edge between vertices 1 and 2:
// 0 1 1 0
// 1 0 0 1
// 1 0 0 0
// 0 1 0 0



// package Graphs;

// public class adj_matrix {
    
// }
