using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace _11047
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var nk = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int n = nk[0];
            int k = nk[1];

            int[] coins = new int[n];
            for (int i=0; i<n; i++)
            {
                coins[i] = int.Parse(Console.ReadLine());
            }
            int count = 0;
            for (int i = n-1; i >= 0; i--)
            {
                if(k >= coins[i])
                {
                    count += k / coins[i];
                    k %= coins[i];
                }
            }
            Console.WriteLine(count);
        }
    }
}
