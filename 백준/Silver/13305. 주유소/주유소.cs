using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int [] Distances = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int [] costsPerLitres = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int Sum = 0;
        int mincost = costsPerLitres[0];
        for (int i = 0; i<N-1; i++)
        {
            if (costsPerLitres[i] < mincost)
            {
                mincost = costsPerLitres[i];                
            }
            Sum += Distances[i] * mincost;
        }
        Console.WriteLine(Sum.ToString());
    }
}