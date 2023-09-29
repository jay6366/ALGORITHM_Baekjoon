using System;
class Program
{
    static void Main()
    {
        int[] numberArray = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int number1 = numberArray[0];
        int number2 = numberArray[1];
        int count = 0;
        
        while(number1!=number2 && number2 >0)
        {
            if(number2 % 2 == 0)
            {
                number2 /= 2;
            }
            else if(number2 % 10 == 1)
            {
                number2 = number2 / 10;
            }
            else
            {
                break;
            }
            count++;
        }
        if(number1 != number2)
        {
            Console.WriteLine(-1);
        }
        else
        {
            Console.WriteLine(count+1);
        }
    }
}