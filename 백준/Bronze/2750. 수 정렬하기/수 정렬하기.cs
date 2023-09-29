using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        List<int> array = new List<int>();
        
        for(int i=1; i<=number; i++)
        {
            array.Add(int.Parse(Console.ReadLine()));
        }
        array.Sort();
        
        string answer = "";
        for(int i=0; i<array.Count; i++)
        {
            answer += array[i] + "\n";
        }
        Console.WriteLine(answer);
    }
}