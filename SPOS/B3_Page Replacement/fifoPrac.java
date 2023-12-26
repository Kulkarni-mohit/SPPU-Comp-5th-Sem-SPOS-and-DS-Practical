// import java.util.Scanner;

// public class fifoPrac {

//     public static void main(String args[]){

//         Scanner sc = new Scanner(System.in);

//         int capacity, noofpages, index=0, fault = 0, hit = 0;
//         double hitRatio, faultRatio;
//         System.out.print("Enter the number of pages you want to enter: ");
//         noofpages = sc.nextInt();
//         int pages[] = new int[noofpages];

//         for(int i=0; i<noofpages; i++){
//             pages[i]=sc.nextInt();
//         }
//         System.out.print("Enter the capacity of frame: ");
//         capacity = sc.nextInt();

//         int Frame[] = new int[capacity];
//         int table[][] = new int[noofpages][capacity];

//         for(int i=0; i<capacity;i++){
//             Frame[i] = -1;
//         }

//         for(int i=0; i<noofpages; i++){
//             int search = -1;

//             for(int j=0; j<capacity; j++){
//                 if(pages[i]==Frame[j]){
//                     search = j;
//                     hit++;
//                     System.out.printf("%3s", "H");
//                     break;
//                 }
//             }

//             if (search ==-1){
//                 Frame[index]=pages[i];
//                 fault++;
//                 index++;
//                 System.out.printf("%3s", "F");
//                 if(capacity == index){
//                     index = 0;
//                 }
//             }
//             System.arraycopy(Frame, 0, table[i],0, capacity);
//         }
//         System.out.println();
//         for(int i=0;i<capacity;i++){
//             for(int j=0;j<noofpages;j++){
//                 System.out.printf("%3d", table[j][i]);
//             }
//             System.out.println();
//         }
        
//         faultRatio = ((double)fault/noofpages)*100;
//         hitRatio = ((double)hit/noofpages)*100;

//         System.out.printf("Hit Ratio:%.2f \nFault Ratio:%.2f ", hitRatio, faultRatio);

//         sc.close();

//     }
// }


import java.util.*;

public class fifoPrac{
    public static void main(String[] args){

        int capacity, noofpages, index=0, hit=0,fault=0;
        boolean isfull = false;
        float hitRatio,faultRatio;
        ArrayList<Integer> a= new ArrayList<>(); 

        Scanner sc = new Scanner(System.in);

        noofpages = sc.nextInt();
        int pages[] = new int[noofpages];

        capacity = sc.nextInt();
        int frame[]= new int[capacity];
        int table[][] = new int[noofpages][capacity];

        for(int i=0;i<noofpages; i++){
            pages[i]=sc.nextInt();
        }

        for(int i=0;i<capacity;i++){
            frame[i]=-1;
        }

        for(int i=0; i<noofpages; i++){
            if (a.contains(pages[i])){
                a.remove(pages[i]);
            }
            a.add(pages[i]);
            int search = -1;
            for(int j=0; j<capacity; j++){
                if(pages[i] == frame[j]){
                    search=j;
                    hit++;
                    System.out.printf("%3s", 'H');
                    break;
                }
            }
            if(search==-1){
                if(isfull){
                    int min = noofpages;
                    for(int j=0;j<capacity;j++){
                        if(a.contains(frame[j])){
                            int temp = a.indexOf(frame[j]);
                            if(temp>min){
                                min = temp;
                                index=j;
                            }
                        }
                    }
                }
                        fault++;
                        frame[index]=pages[i];
                        System.out.printf("%3s","F");
                        index++;
                        if(index==capacity){
                            isfull = true;
                            index=0;
                        }
            }
            System.arraycopy(frame,0,table[i],0,capacity);
        }
System.out.println();
        for(int i=0;i<capacity;i++){
            for(int j=0;j<noofpages;j++){
                System.out.printf("%3d", table[j][i]);
            }
            System.out.println();
        }


    }
}