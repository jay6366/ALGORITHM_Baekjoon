using System;

class Program
{
    static int N;
    static (int S, int B)[] ingredients;
    static int minDifference = int.MaxValue;

    static void Main()
    {
        N = int.Parse(Console.ReadLine());
        ingredients = new (int S, int B)[N];

        for (int i = 0; i < N; i++)
        {
            string[] inputs = Console.ReadLine().Split(' ');
            ingredients[i] = (int.Parse(inputs[0]), int.Parse(inputs[1]));
        }

        FindMinDifference(0, 1, 0);
        Console.WriteLine(minDifference);
    }

    static void FindMinDifference(int index, int totalS, int totalB)
    {
        if (index > 0)
        {
            int difference = Math.Abs(totalS - totalB);
            minDifference = Math.Min(minDifference, difference);
        }

        for (int i = index; i < N; i++)
        {
            FindMinDifference(i + 1, totalS * ingredients[i].S, totalB + ingredients[i].B);
        }
    }
}
