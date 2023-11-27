using System;

class Program
{
    static int[] arr; 
    static bool[] visited;     

    static void Main(string[] args)
    {
        string[] tokens = Console.ReadLine().Split();
        int N = int.Parse(tokens[0]);
        int M = int.Parse(tokens[1]);

        arr = new int[M];
        visited = new bool[N + 1];

        Backtrack(N, M, 0);
    }

    static void Backtrack(int N, int M, int depth)
    {
        if (depth == M)
        {
            Console.WriteLine(string.Join(" ", arr));
            return;
        }

        for (int i = 1; i <= N; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                arr[depth] = i;
                Backtrack(N, M, depth + 1);
                visited[i] = false; 
            }
        }
    }
}
