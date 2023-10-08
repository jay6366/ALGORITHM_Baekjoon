using System;
using System.Linq;


class Program
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split(' ');
        int n = int.Parse(input[0]);
        int h = int.Parse(input[1]);
        int[] heights = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

        int start = 0;
        int end = heights.Max();
        int result = 0;

        while (start <= end)
        {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++)
            {
                if (heights[i] >= mid)
                {
                    sum += heights[i] - mid;
                }
            }

            if (sum < h)
            {
                end = mid - 1;
            }
            else
            {
                result = mid;
                start = mid + 1;
            }
        }

        Console.WriteLine(result);
    }
}

