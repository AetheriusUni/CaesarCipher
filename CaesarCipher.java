import java.util.Scanner;

public class CaesarCipher 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the number of lines you will have: ");
		int numlin = reader.nextInt();
		int lincnt = 0;
		System.out.print("Enter your message: ");
		String original;
		while(lincnt<=numlin)
		{
			original = reader.nextLine();
			System.out.print(cipher(original,1));
			lincnt++;
		}
	}
	
	static String cipher(String msg, int shift)
	{
		String forprint = "";
		char[] c = msg.toCharArray();
		char[] ciphered = new char[msg.length()];
		for(int i = 0; i < msg.length(); i++)
		{
			if(lcheck(c[i]))
			{
				ciphered[i] = (char)(c[i]+shift);
			}
			else if(ucheck(c[i]))
			{
				ciphered[i] = (char)(c[i]+shift);
			}
			else
			{
				ciphered[i] = c[i];
			}
			forprint = forprint + ciphered[i];
		}
		return forprint;
	}
	static boolean lcheck(char c)
	{
		String lower = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < lower.length(); i++)
		{
			if(c==lower.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
	static boolean ucheck(char c)
	{
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < upper.length(); i++)
		{
			if(c==upper.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
}
