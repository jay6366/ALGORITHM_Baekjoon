using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        List<Tuple<int, int>> meetings = new List<Tuple<int, int>>();

        for (int i = 0; i < N; i++)
        {
            int[] times = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            meetings.Add(new Tuple<int, int>(times[0], times[1]));
        }

        var sortedMeetings = meetings.OrderBy(m => m.Item2).ThenBy(m => m.Item1).ToList();

        int count = 0;
        int endTime = 0;

        foreach (var meeting in sortedMeetings)
        {
            if (meeting.Item1 >= endTime)
            {
                endTime = meeting.Item2;
                count++;
            }
        }

        Console.WriteLine(count);
    }
}
