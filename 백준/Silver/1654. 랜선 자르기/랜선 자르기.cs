using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        string [] inputs = Console.ReadLine().Split(' ');
        int K = int.Parse(inputs[0]);
        int N = int.Parse(inputs[1]);
        
        long [] lanCables = new long[K];
        long maxLen = 0;
        
        for (int i=0; i<K; i++)
        {
            lanCables[i] = long.Parse(Console.ReadLine());
            maxLen = Math.Max(maxLen, lanCables[i]);
        }       
        long result = BinarySearch(lanCables, N, 1, maxLen);
        Console.WriteLine(result);      
    }
    static long BinarySearch(long[] cables, int required, long min, long max)
    {
        while(min<=max)
        {
            long mid = (min + max)/2;
            long count = 0;
            
            foreach(var cable in cables)
            {
                count += cable/mid;     
            }
            if(count < required)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return max;
    }
}