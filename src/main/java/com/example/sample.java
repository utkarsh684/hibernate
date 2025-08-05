package com.example;

public class sample {

    public static int[][] multiply(int[][] mat1, int[][] mat2){
        int a1=mat1.length;
        int a2=mat1[0].length;
        int b1=mat2.length;
        int b2=mat2[0].length;

        if(a2!=b1){
            throw new IllegalArgumentException("Number of columns of A must match number of rows of B.");
        }

        int[][] result=new int[a1][b2];

        for(int i=0;i<a1;i++){
            for(int j=0;j<b2;j++){
                for(int k=0;k<a2;k++){
                    result[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        int mat1[][]={{1,2},{3,4}};
        int mat2[][]={{1,2},{3,4}};

        int[][] result=multiply(mat1,mat2);

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
            System.out.println();
        }
    }

}
