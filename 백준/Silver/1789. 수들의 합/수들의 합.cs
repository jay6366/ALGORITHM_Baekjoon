using System;

class Program
{
    static void Main()
    {
        long input = long.Parse(Console.ReadLine());
        long sum = 0;
        long current = 0;
        
        while (sum <= input)
        {
            current += 1;
            sum += current;
        }
        Console.WriteLine(current-1);
    }
}