package com.uttarainfo.test.MailIt.Model;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(9);
        B.add(8);
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                for(int k=0;k<A.size();k++){
                    if(k==i){
                        System.out.print(B.get(j));
                        System.out.print("\t");
                    }
                    else {
                        System.out.print(A.get(k));
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
        }
    }
}
