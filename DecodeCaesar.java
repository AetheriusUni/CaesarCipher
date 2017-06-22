

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

	public class DecodeCaesar {
		public static void main(String[] args) throws IOException
		{
			
			String path;
			String aLine;
			// file is read correctly
			// setup to be able to read the text file
			
		//	int lenpass = 8;
			int lincnt = 0;			// counts lines in file
		//	ArrayList<String> pass = new ArrayList<String>();
			// for all those password files
			for(int i = 0; i <= 8 ; i++ )
			{
				// decides name of path
				
				
					path = "/Users/kirkwagner/Desktop/epasswords/encpwd" + i + ".txt";
				
				
				
					File file = new File(path);
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					StringBuffer sb = new StringBuffer();
				
				
				while((aLine=br.readLine())!=null)
				{
					lincnt = lincnt + 1;
					sb.append(aLine);
				}
				//fr.close();
			
		//setting the ciphered text to a variable
			int numlin = 1;		
			
			String original;
			System.out.println(path);
			while(lincnt<=numlin)
			{ 
				
				original = sb.toString();
				for(int j =0; j<26;j++)
				{
				System.out.println("correct shift is  "+j + " "+decipher(original,j));
				
				}
				lincnt++;
			}
			lincnt=0;
		}
	}
		static String decipher(String msg, int shift)
		{
			String forprint = "";
			char[] c = msg.toCharArray();
			char[] ciphered = new char[msg.length()];
			for(int i = 0; i < msg.length(); i++)
			{
				if(lcheck(c[i]))
				{	if(c[i]-shift < 97)
					{
					ciphered[i] = (char)((int)(c[i]-shift)+26);
					}
					else
					{
					ciphered[i] = (char)((int)(c[i]-shift));
					}
				}
				else if(ucheck(c[i]))
				{
					ciphered[i] = (char)((int)(c[i]-shift));
					
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


