/*You are given an integer N which denotes the number of courses numbered from 1 to N and a matrix ‘prerequisites’,
in which each row contains exactly two integers ‘A’ and ‘B’ which represents the course ‘A’ 
has to be studied in some semester before studying course ‘B’.

In one semester, you can take at most k courses as long as you have taken all the prerequisites in the 
previous semesters for the courses you are taking.

You are supposed to find the minimum number of semesters required to study all the courses. 
If it is impossible to study all the courses, then return -1.

Input Format:
-------------
The first line represents N, which denotes the number of courses
The second line represents M, which denotes the number of rows of the matrix prerequisites.
The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], 
denoting that prerequisites[i][0] has to be studied before prerequisites[i][1].
Last line k, denotes number of courses can be taken in a semester.

Output Format:
---------------
Print the minimum number of semesters required to study all the courses

Sample Input 1
--------------
4
3
2 1
3 1
4 1
2

Sample output 1
---------------
3


Explanation: 
------------
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 4.
In the third semester, you can take course 1.

Sample input 2
--------------
4
3
1 3
2 3
3 1
3
Sample output 2
----------------
-1

Constraints:
1<= N <= 50
1<=k<=N
1 <= prerequisites[i][0], prerequisites[i][1] <= N
Prerequisites[i][0] != prerequisites[i][1], for any valid i */
package Graphs;
import java.util.*;
public class parallel_course {
    public static void edge(List<List<Integer>> l,int u,int v)
    {
        l.get(u).add(v);
    }
    public static void parallel(List<List<Integer>> l,int x,int g)
    {
        int[] indegree=new int[x];
        for(int i=0;i<x;i++)
        {
            for(int j:l.get(i))
            {
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<x;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int r=0;
        List<Integer> l1=new ArrayList<>();
        while(!q.isEmpty())
        {
            int g1=Math.min(g,q.size());
            for(int t=0;t<g1;t++)
            {
                int k=q.poll();
                l1.add(k);
                for(int j=0;j<l.get(k).size();j++)
                {
                    int o=l.get(k).get(j);
                    indegree[o]--;
                    if(indegree[o]==0)
                    {
                        q.add(o);
                    }
                }
            }
            r++;
        }
        if(l1.size() != x)
        {
            r=-1;
        }
        System.out.print(r);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
         int m = sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<x;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            edge(l,u-1,v-1);
        }
        int g=sc.nextInt();
        parallel(l,x,g);
    }
}

// public int minNumberOfSemesters(int n, int[][] relations, int k) {
//         List<List<Integer>> l=new ArrayList<>();
//         int[] indegree=new int[n];
//         for(int i=0;i<n;i++)
//         {
//             l.add(new ArrayList());
//         }
//         for(int[] r:relations)
//         {
//             int u=r[0]-1;
//             int v=r[1]-1;
//             l.get(u).add(v);
//             indegree[v]++;
//         }
//         Queue<Integer> q=new LinkedList<>();

//         for(int i=0;i<n;i++)
//         {
//             if(indegree[i]==0)
//             {
//                 q.add(i);
//             }
//         }
//         int r=0;
//         List<Integer> l1=new ArrayList<>();
//         while(!q.isEmpty())
//         {
//             int g1=Math.min(k,q.size());
//             for(int t=0;t<g1;t++)
//             {
//                 int g=q.poll();
//                 l1.add(k);
//                 for(int j=0;j<l.get(g).size();j++)
//                 {
//                     int o=l.get(g).get(j);
//                     indegree[o]--;
//                     if(indegree[o]==0)
//                     {
//                         q.add(o);
//                     }
//                 }
//             }
//             r++;
//         }
//         if(l1.size() != n)
//         {
//             return -1;
//         }
//         return r;
//     }
