using System;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int shareCount = 0;
        bool flag = false;
        
        while (number >= 0)
        {
            if (number == 0 || number % 5 == 0)
            {
                shareCount += number/5;
                flag = true;
                Console.WriteLine(shareCount);
                break;
            }
            number -= 3;
            shareCount += 1;
        }
        if(!flag)
        {
            Console.WriteLine(-1);
        }
    }
}
