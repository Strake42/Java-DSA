public class CatalanNumber{
    public static int catalanRec(int n){
        if(n==0 || n==1)
            return 1;
        
        int ans = 0;
        for(int i=0; i<n; i++){
             ans += catalanRec(i)*catalanRec(n-i-1);
        }
           
        
        return ans;
    }

    public static int catalanMem(int n, int dp[]){
        if(n==0 || n==1)
            return 1;

        if(dp[n] != 0)
            return dp[n];
        
        int ans = 0;
        for(int i=0; i<n; i++){
             ans += catalanRec(i)*catalanRec(n-i-1);
             dp[n] = ans;
        }
           
        
        return dp[n];
    }

    public static int catalanTab(int n){
        int dp[] = new int[n+1];

        dp[0] =1;
        dp[1] =1;

        for(int i=2; i<=n; i++){
            for(int j =0; j<i; j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
                
        }
            

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
       // int dp[] = new int[n+1];

        System.out.println(catalanTab(n));
    }
}