using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        int testCases = int.Parse(Console.ReadLine());

        for (int t = 0; t < testCases; t++)
        {
            int n = int.Parse(Console.ReadLine());
            List<Tuple<int, int>> applicants = new List<Tuple<int, int>>();

            for (int i = 0; i < n; i++)
            {
                string[] inputs = Console.ReadLine().Split(' ');
                int documentRank = int.Parse(inputs[0]);
                int interviewRank = int.Parse(inputs[1]);
                applicants.Add(new Tuple<int, int>(documentRank, interviewRank));
            }

            applicants.Sort((x, y) => x.Item1.CompareTo(y.Item1));

            int maxHire = 1; 
            int bestInterviewRank = applicants[0].Item2;

            for (int i = 1; i < n; i++)
            {
                if (applicants[i].Item2 < bestInterviewRank)
                {
                    maxHire++;
                    bestInterviewRank = applicants[i].Item2;
                }
            }

            Console.WriteLine(maxHire);
        }
    }
}
