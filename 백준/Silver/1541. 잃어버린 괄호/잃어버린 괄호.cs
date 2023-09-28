using System;
using System.Linq;

class Program
{
    static void Main()
    {
        string [] input = Console.ReadLine().Split('\n');
        string [] groups = input[0].Split('-');
        int answer = 0;
        
        
        for (int i=0; i<groups.Length; i++)
        {
            int current = groups[i].Split('+').Select(int.Parse).Sum();
            if(i==0)
            {
                answer += current;
            }
            else
            {
                answer -= current;
            }
        }
        Console.WriteLine(answer);
    }
}