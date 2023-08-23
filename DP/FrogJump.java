// Problem Link: https://bit.ly/3JPcoOx

import java.util.* ;
import java.io.*; 
import java.lang.*;


public class FrogJump {
    public static int func(int n,int height[],int dp[]){

        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];

        int left=func(n-1,height,dp)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=func(n-2,height,dp)+Math.abs(height[n]-height[n-2]);
        }

        return dp[n]=Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return func(n-1, heights,dp);
    }
}