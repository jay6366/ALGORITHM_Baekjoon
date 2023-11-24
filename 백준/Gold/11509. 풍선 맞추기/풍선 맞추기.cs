using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int[] heights = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int arrows = 0;
        int[] arrowsHeight = new int[N];

        for (int i = 0; i < N; i++)
        {
            int currentHeight = heights[i];
            bool isArrowFound = false;

            for (int j = 0; j < arrows; j++)
            {
                if (arrowsHeight[j] == currentHeight + 1)
                {
                    arrowsHeight[j]--;
                    isArrowFound = true;
                    break;
                }
            }

            if (!isArrowFound)
            {
                arrowsHeight[arrows] = currentHeight;
                arrows++;
            }
        }

        Console.WriteLine(arrows);
    }
}
