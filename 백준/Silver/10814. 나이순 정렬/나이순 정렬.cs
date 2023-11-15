using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        List<Tuple<int, string>> members = new List<Tuple<int, string>>();

        for (int i = 0; i < N; i++)
        {
            string[] inputs = Console.ReadLine().Split(' ');
            int age = int.Parse(inputs[0]);
            string name = inputs[1];
            members.Add(new Tuple<int, string>(age, name));
        }

        var sortedMembers = members.OrderBy(member => member.Item1).ToList();

        foreach (var member in sortedMembers)
        {
            Console.WriteLine($"{member.Item1} {member.Item2}");
        }
    }
}
