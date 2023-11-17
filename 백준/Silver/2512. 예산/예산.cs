using System;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine()); 
        int[] requests = Console.ReadLine().Split(' ').Select(int.Parse).ToArray(); 
        int totalBudget = int.Parse(Console.ReadLine()); 

        Console.WriteLine(AllocateBudget(requests, totalBudget));
    }

    static int AllocateBudget(int[] requests, int totalBudget)
    {
        int left = 0;
        int right = requests.Max(); 
        int result = 0;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            int sum = 0;

            foreach (int request in requests)
            {
                sum += Math.Min(request, mid); 
            }

            if (sum > totalBudget)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
                result = mid;
            }
        }

        return result;
    }
}
