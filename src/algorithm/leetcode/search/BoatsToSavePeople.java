package algorithm.leetcode.search;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0 ,j=people.length-1;
        Arrays.sort(people);
        for(;i<=j;){
            if(people[i]+people[j]>limit){
                j--;
            }
            else if(people[i]+people[j]<=limit) {
                i++;
                j--;
            }
        }
        return people.length-j-1;
    }
    public static void main(String[] args){
        int[] boat1 = {3,2,2,1};
        int[] boat2 = {3,5,3,4};
        int[] boat3 = {1};
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        System.out.println(boatsToSavePeople.numRescueBoats(boat1,3));
        System.out.println(boatsToSavePeople.numRescueBoats(boat2,5));
        System.out.println(boatsToSavePeople.numRescueBoats(boat3,3));
    }
}
