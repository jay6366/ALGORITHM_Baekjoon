using System;
using System.Linq;

class Program
{
    static void Main(string [] args)
    {
        int N = int.Parse(Console.ReadLine());
        int [] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        
        Array.Sort(array);
        
        int sum = 0;
        int answer = 0;
        
        for(int i=0; i<N; i++)
        {
            sum += array[i];
            answer += sum;
        }
        Console.WriteLine(answer);
    }
}