using System;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int [] arr = new int[number];
        for (int i = 0; i < number; i++)
        {
            arr[i] = int.Parse(Console.ReadLine());
        }
        Array.Sort(arr);
        Console.WriteLine(string.Join("\n",arr));
    }
     
}