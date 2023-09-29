using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        List<string> array = new List<string>();
        
        for(int i=0; i<n; i++)
        {
            array.Add(Console.ReadLine());
        }
        
        array = array.Distinct().ToList();
        
        array.Sort(
        (a,b)=>{
            if(a.Length != b.Length)
            {
                return a.Length.CompareTo(b.Length);
            }
            return a.CompareTo(b);           
        });
        foreach(string item in array)
        {
            Console.WriteLine(item);
        }
    }
}