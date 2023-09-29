using System;
using System.Collections.Generic;    
using System.Linq;

class Program
{
    static void Main()
    {
        int[] input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray(); 
        int n = input[0];
        int k = input[1];
       
        List<int> array = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
        
        array.Sort();
        
        Console.WriteLine(array[k-1]);

    }
}