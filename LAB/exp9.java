import java.util.*;
public class exp9 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String txt=sc.nextLine();
        String words[]=sc.nextLine().split(" ");
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<txt.length();i++)
        {
            for(String word:words)
            {
                int len=word.length();
                if(i+len<=txt.length())
                {
                    String sub=txt.substring(i,i+len);
                    if(sub.equals(word))
                    {
                        l.add(new int[]{i,i+len-1});
                    }
                }
            }
        }
        Collections.sort(l,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        for(int i=0;i<l.size();i++)
        {
            int[] pair=l.get(i);
            System.out.print(pair[0]+" "+pair[1]);
            if(i!=l.size()-1)
            {
                System.out.print(",");
            }
        }
    }
}
