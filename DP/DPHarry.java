import java.util.*;

class DPHarry
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
			int r=sc.nextInt(),c=sc.nextInt();
			int m[][]=new int[r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					m[i][j]=sc.nextInt();
				}
			}
			for(int i=1;i<r;i++){
				for(int j=0;j<c;j++){
					int tl=0,tp=m[i-1][j],tr=0;
					if(j-1>=0){
						tl=m[i-1][j-1];
					}
					if(j+1<c){
						tr=m[i-1][j+1];
					}
					m[i][j]+=Math.max(tl,Math.max(tp,tr));
				}
			}
			int mx=Integer.MIN_VALUE;
			for(int j=0;j<c;j++){
				if(m[r-1][j] > mx){
					mx=m[r-1][j];
				}
			}
			System.out.println(mx);
		}
	}
}