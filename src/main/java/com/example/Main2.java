package com.example;

public class Main2 {

    private static void quickSort(int[] nums,int low, int high){
        if(low<high){
            int pivot=partition(nums,low,high);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }

    private static int partition(int[] nums,int low,int high){
        int pivot=nums[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[high];
        nums[high]=temp;
        return i+1;
    }

    public static void main(String[] args){
        int[] nums={2,3,4,2,11,9,6,54};
        System.out.println("Array before sorting");
        for(int n:nums){
            System.out.print(n+" ");
        }
        System.out.println();
        quickSort(nums,0,nums.length-1);
        System.out.println("Array after sorting");
        for(int n:nums){
            System.out.print(n+" ");
        }
        System.out.println();
    }


}
