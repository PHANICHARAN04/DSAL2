import java.util.Scanner;

public class pascal {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int [][] m= new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            m[i][0]=1;  // nC0
            m[i][i]=1;  // nCn
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                m[i][j]=m[i-1][j]+m[i-1][j-1];
            }
        }
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}
