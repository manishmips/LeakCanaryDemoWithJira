package com.mt.myleakcanary.util;

import android.util.Log;

import java.util.Arrays;
import java.util.BitSet;

public class Util {

    public static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * (totalCount + 1) / 2;
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        Log.d("Missing number :",(expectedSum-actualSum)+"");
        return expectedSum - actualSum;
    }

//    Read more: https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html#ixzz7UNKHgVHi


    public static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
            Log.d("Missing number :",(++lastMissingIndex)+"");

        }

    }


//    Read more: https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html#ixzz7UNPB9Mwd

   static int getSum(int arr[],int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }

    // Function to find two missing numbers in range
// [1, n]. This function assumes that size of array
// is n-2 and all array elements are distinct
    public static void findTwoMissingNumbers(int arr[],int n)
    {
        // Sum of 2 Missing Numbers
        int sum = (n*(n + 1)) /2 - getSum(arr, n-2);

        // Find average of two elements
        int avg = (sum / 2);

        // Find sum of elements smaller than average (avg)
        // and sum of elements greater than average (avg)
        int sumSmallerHalf = 0, sumGreaterHalf = 0;
        for (int i = 0; i < n-2; i++)
        {
            if (arr[i] <= avg)
                sumSmallerHalf += arr[i];
            else
                sumGreaterHalf += arr[i];
        }


        String cout = new String();

        // The first (smaller) element = (sum of natural
        // numbers upto avg) - (sum of array elements
        // smaller than or equal to avg)
        int totalSmallerHalf = (avg*(avg + 1)) / 2;
        int smallerElement = totalSmallerHalf - sumSmallerHalf;
        Log.d("Missing: 1missing Element",smallerElement+"");

        // The second (larger) element = (sum of both
        // the elements) - smaller element
        Log.d("Missing:2 missing Element",(sum-smallerElement)+"");
    }
}
