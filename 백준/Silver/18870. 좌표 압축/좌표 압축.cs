using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int[] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        
        int[] uniqueArray = array.Distinct().ToArray();
        Array.Sort(uniqueArray);
        
        Dictionary<int, int> myMap = new Dictionary<int,int>();
        for (int i=0; i<uniqueArray.Length; i++)
        {
            myMap[uniqueArray[i]] = i;
        }
        
        string answer = string.Join(" ", array.Select(x=>myMap[x]));
        
        Console.WriteLine(answer);
    }
}