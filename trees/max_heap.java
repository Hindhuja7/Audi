// package trees;

// import java.util.*;
// public class max_heap{
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         int x=sc.nextInt();
//         int[] arr=new int[x];
//         for(int i=0;i<x;i++)
//         {
//             arr[i]=sc.nextInt();
//         }
//         int[] heap=new int[x+1];
//         int y=sc.nextInt();
//         for(int i=0;i<x;i++)
//         {
//             heap[i]=arr[i];
//         }
//         heap[heap.length-1]=y;
//         for(int i=0;i<heap.length;i++)
//         {
//             System.out.print(heap[i]+" ");
//         }  
//         System.out.println("");
//         //int k=heap.length-1;
//         // while(k>0)
//         // {
//         //     int l=(k-1)/2;
//         //     if(heap[l]<heap[k])
//         //     {
//         //         int temp=heap[k];
//         //         heap[k]=heap[l];
//         //         heap[l]=temp;
//         //         k=l;
//         //     }
//         //     else{
//         //         break;
//         //     }
//         // }
        
//          int size = heap.length;

//         int temp = heap[0];
//         heap[0] = heap[size-1];
//         heap[size-1] = temp;

//         size = size - 1;

//         int i = 0;

//         while(true){

//             int left = 2*i + 1;
//             int right = 2*i + 2;
//             int largest = i;

//             if(left < size && heap[left] > heap[largest])
//                 largest = left;

//             if(right < size && heap[right] > heap[largest])
//                 largest = right;

//             if(largest != i){
//                 int t = heap[i];
//                 heap[i] = heap[largest];
//                 heap[largest] = t;

//                 i = largest;
//             }
//             else{
//                 break;
//             }
//         }
//         for(int j=0;j<size;j++)
//         {
//             System.out.print(heap[j]+" ");
//         }
//     }
// }