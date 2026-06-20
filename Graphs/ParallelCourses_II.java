// /*You are given an integer N which denotes the number of courses numbered from 1 to N and a matrix ‘prerequisites’,
// in which each row contains exactly two integers ‘A’ and ‘B’ which represents the course ‘A’ 
// has to be studied in some semester before studying course ‘B’.

// In one semester, you can take at most k courses as long as you have taken all the prerequisites in the 
// previous semesters for the courses you are taking.

// You are supposed to find the minimum number of semesters required to study all the courses. 
// If it is impossible to study all the courses, then return -1.

// Input Format:
// -------------
// The first line represents N, which denotes the number of courses
// The second line represents M, which denotes the number of rows of the matrix prerequisites.
// The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], 
// denoting that prerequisites[i][0] has to be studied before prerequisites[i][1].
// Last line k, denotes number of courses can be taken in a semester.

// Output Format:
// ---------------
// Print the minimum number of semesters required to study all the courses

// Sample Input 1
// --------------
// 4
// 3
// 2 1
// 3 1
// 4 1
// 2

// Sample output 1
// ---------------
// 3


// Explanation: 
// ------------
// In the first semester, you can take courses 2 and 3.
// In the second semester, you can take course 4.
// In the third semester, you can take course 1.

// Sample input 2
// --------------
// 4
// 3
// 1 3
// 2 3
// 3 1
// 3
// Sample output 2
// ----------------
// -1

// Constraints:
// 1<= N <= 50
// 1<=k<=N
// 1 <= prerequisites[i][0], prerequisites[i][1] <= N
// Prerequisites[i][0] != prerequisites[i][1], for any valid i */
// import java.util.*;

// public class ParallelCourses {

//     public int minimumSemesters(int N, int[][] relations) {

//         // Step 1: Build graph and indegree array
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             adj.add(new ArrayList<>());
//         }

//         int[] indegree = new int[N + 1];

//         for (int[] rel : relations) {
//             int u = rel[0];
//             int v = rel[1];
//             adj.get(u).add(v);
//             indegree[v]++;
//         }

//         // Step 2: Add all courses with indegree 0
//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 1; i <= N; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }

//         int semester = 0;
//         int completed = 0;

//         // Step 3: BFS (level-wise)
//         while (!queue.isEmpty()) {
//             int size = queue.size();   // number of courses this semester
//             semester++;

//             for (int i = 0; i < size; i++) {
//                 int course = queue.poll();
//                 completed++;

//                 for (int neighbor : adj.get(course)) {
//                     indegree[neighbor]--;

//                     if (indegree[neighbor] == 0) {
//                         queue.offer(neighbor);
//                     }
//                 }
//             }
//         }

//         // Step 4: Check if all courses completed
//         if (completed == N) {
//             return semester;
//         } else {
//             return -1;   // cycle exists
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         ParallelCourses pc = new ParallelCourses();

//         System.out.print("Enter number of courses: ");
//         int N = sc.nextInt();

//         System.out.print("Enter number of relations: ");
//         int M = sc.nextInt();

//         int[][] relations = new int[M][2];

//         System.out.println("Enter relations (u v):");
//         for (int i = 0; i < M; i++) {
//             relations[i][0] = sc.nextInt();
//             relations[i][1] = sc.nextInt();
//         }

//         int result = pc.minimumSemesters(N, relations);

//         System.out.println("Minimum semesters = " + result);
//     }
// }

import java.util.*;

public class ParallelCourses_II {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {

        // Step 1: Build graph + indegree
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        for (int[] rel : relations) {
            int u = rel[0];
            int v = rel[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Step 2: Add all courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int semesters = 0;
        int completed = 0;

        // Step 3: BFS (with limit k per semester)
        while (!queue.isEmpty()) {

            int size = queue.size();
            int canTake = Math.min(size, k);   // limit k

            List<Integer> current = new ArrayList<>();

            // take only k courses
            for (int i = 0; i < canTake; i++) {
                int course = queue.poll();
                current.add(course);
            }

            // process them
            for (int course : current) {
                completed++;

                for (int neighbor : graph.get(course)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            semesters++;
        }

        return semesters;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParallelCourses_II obj = new ParallelCourses_II();

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();

        System.out.print("Enter number of relations: ");
        int m = sc.nextInt();

        int[][] relations = new int[m][2];

        System.out.println("Enter relations (u v):");
        for (int i = 0; i < m; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.print("Enter max courses per semester (k): ");
        int k = sc.nextInt();

        int result = obj.minNumberOfSemesters(n, relations, k);

        System.out.println("Minimum semesters = " + result);
    }
}