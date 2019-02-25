package com.son;

import java.util.Scanner;

public class Main {
    private int n;
    private int k;

    public void in(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            if(line.contains(" ")){
                String[] split = line.split(" ");
                Integer n = Integer.valueOf(split[0]);
                Integer k = Integer.valueOf(split[1]);
                if(n >= 1 && n <= 100000 && k >= 0 && k <= n-1){
                    break;
                }
            }
        }
    }

    public void solve(){
        int result = 0;
        for (int i = k; i <= n-k; i++) {
            result += (n-i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j < n; j++) {
            }
        }



    }

}
