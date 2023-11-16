using System;

class Program
{
    static void Main()
    {
        string N = Console.ReadLine();
        char [] characters = N.ToCharArray();
        Array.Sort(characters);
        Array.Reverse(characters);
        Console.WriteLine(new string(characters));      
    }
}