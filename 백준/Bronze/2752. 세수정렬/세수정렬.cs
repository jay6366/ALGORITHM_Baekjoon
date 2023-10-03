using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2752
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // 1. 파일 읽기
            string input = Console.ReadLine();
            // 2. 문자열 분리 및 숫자 배열로 변환
            int[] arr = input.Split(' ').Select(int.Parse).ToArray();

            // 3. 배열 정렬
            Array.Sort(arr);

            // 4. 배열을 문자열로 합치기
            string answer = string.Join(" ", arr);

            // 5. 결과 출력
            Console.WriteLine(answer);
        }
    }
}
