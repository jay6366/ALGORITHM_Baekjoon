using System;

class Program
{
    static void Main()
    {
        int T = int.Parse(Console.ReadLine());
        for (int i = 0; i < T; i++)
        {
            string s = Console.ReadLine();
            Console.WriteLine(IsPalindrome(s));
        }
    }

    static int IsPalindrome(string s)
    {
        int left = 0, right = s.Length - 1;
        while (left < right)
        {
            if (s[left] != s[right])
            {
                if (IsSubPalindrome(s, left + 1, right) || IsSubPalindrome(s, left, right - 1))
                    return 1; 
                return 2; 
            }
            left++; right--;
        }
        return 0; 
    }

    static bool IsSubPalindrome(string s, int left, int right)
    {
        while (left < right)
        {
            if (s[left] != s[right])
                return false;
            left++; right--;
        }
        return true;
    }
}
