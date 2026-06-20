import java.util.*;
public class exp12 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        String s=sc.next();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<a.length();i++)
        {
            int u=a.charAt(i)-'a';
           int v=b.charAt(i)-'a';
           l.get(u).add(v);
           l.get(v).add(u);
        }
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<s.length();i++)
        {
            int k=s.charAt(i)-'a';
            boolean[] visited = new boolean[26];
            Stack<Integer> st=new Stack<>();
            st.push(k);
            int small=k;
            while(!st.isEmpty())
            {
                int p=st.pop();
                if(visited[p]) continue;
                visited[p]=true;
                small=Math.min(small,p);
                for(int x:l.get(p))
                {
                    if(!visited[x])
                    {
                        st.push(x);
                    }
                }
            }  
            str.append((char)('a'+small));       
        }
        System.out.print(str);

    }
}
