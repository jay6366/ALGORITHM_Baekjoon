using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int[] soldiers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[] dp = new int[N];

        for (int i = 0; i < N; i++)
        {
            dp[i] = 1;  
            for (int j = 0; j < i; j++)
            {
                if (soldiers[j] > soldiers[i])
                {
                    dp[i] = Math.Max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = dp.Max();
        Console.WriteLine(N - maxLength);
    }
}
