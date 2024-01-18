import java.util.*;
// bus conductor chillar problem
public class subsetsum {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int target = sc.nextInt();
        int wallet[]=new int[n];
        for(int i=0;i<n;i++){
            wallet[i]=sc.nextInt();
        }
        boolean[][] m=new boolean[n+1][target+1]; // default all with be filled with false
        for(int i=0;i<n+1;i++){
            m[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(m[i-1][j]==true){ // above value
                    m[i][j]=true;
                }
                else{
                    int coin=wallet[i-1];
                    if(coin<=j){
                        m[i][j]=m[i-1][j-coin];
                    }
                }
            }
        }
        System.out.println(m[n][target]);
    }
}
