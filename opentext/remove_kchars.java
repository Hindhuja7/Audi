import java.util.*;

public class remove_kchars {
    static class Node {
        char ch;
        int count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int k=sc.nextInt();
           Stack<Node> st=new Stack<>();
            if (k == 1) {
            System.out.print("");
            return;
        }
           for(int i=0;i<s.length();i++)
           {
            if(st.isEmpty())
            {
                Node n=new Node();
                n.ch=s.charAt(i);
                    n.count=1;
                    st.push(n);
                    continue;
            }
            Node temp=st.peek();
            if(temp.ch==s.charAt(i))
            {
                temp.count++;
            }
            else{
                Node n=new Node();
                n.ch=s.charAt(i);
                n.count=1;
                st.push(n);
            }
            if(st.peek().count==k)
                {
                    st.pop();
                }
           }
           StringBuilder sb = new StringBuilder();
        for (Node n : st) {
            for (int i = 0; i < n.count; i++) {
                sb.append(n.ch);
            }
        }
        System.out.print(sb.toString());
        
    }
}
