import java.util.Scanner;

public class binaryknapsack {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int capacity = sc.nextInt();
        int wt[]=new int[n];
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int[][] m = new int[n+1][capacity+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<capacity+1;j++){
                int execIthItem=m[i-1][j];
                int incIthItem=0;
                int wtIthItem=wt[i-1];
                int valIthItem=val[i-1];
                if(wtIthItem<=j){
                    incIthItem=valIthItem + m[i-1][j-wtIthItem];
                }
                m[i][j]=Math.max(incIthItem,execIthItem);
            }
        } 

        for(int i=0;i<n+1;i++){
            for(int j=0;j<capacity+1;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }

    }
}
