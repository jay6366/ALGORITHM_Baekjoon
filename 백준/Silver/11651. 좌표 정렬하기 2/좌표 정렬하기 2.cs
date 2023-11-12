using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

class Program
{
    static void Main()
    {
        using (StreamReader reader = new StreamReader(Console.OpenStandardInput()))
        using (StreamWriter writer = new StreamWriter(Console.OpenStandardOutput()))
        {
            int number = int.Parse(reader.ReadLine());
            List<int[]> arr = new List<int[]>(number);

            for (int i = 0; i < number; i++)
            {
                string[] input = reader.ReadLine().Split(' ');
                int x = int.Parse(input[0]);
                int y = int.Parse(input[1]);
                arr.Add(new int[] { x, y });
            }

            arr.Sort((a, b) => 
            {
                int compare = a[1].CompareTo(b[1]);
                if (compare != 0) return compare;
                return a[0].CompareTo(b[0]);
            });

            StringBuilder sb = new StringBuilder();
            foreach (var item in arr)
            {
                sb.AppendLine($"{item[0]} {item[1]}");
            }
            writer.Write(sb.ToString());
        }
    }
}
