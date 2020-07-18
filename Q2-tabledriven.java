package tabledriven;

import java.util.Scanner;
import java.util.*;

public class lexanalyser {
	static Scanner s = new Scanner(System.in);
	
	public static char NextChar(String x,int i){
		
//		System.out.print("Enter your String:");
//		String x=s.nextLine();
//		System.out.println(x);
		return x.charAt(i);
	}
	
	
	public static void main(String a[]){
		Stack ix= new Stack();
		String lexeme="";
		int state=0;
		ix.push(-1);
	
		 Dictionary geek = new Hashtable(); 
		  
	        // put() method 
	        geek.put("123", 1); 
	        geek.put("456", 2); 
	  
		
		System.out.print("Enter your String:");
		String x=s.nextLine();
		int len=x.length();
		
		int CharCat[]={
				//r  0-9  EOF+Other
				  0,  1  , 2  
		};
		
		int Transition[][]={
			   //Register Digit  Other
		 /*s0*/   	{1  ,   3 ,  3 },
		 /*s1*/   	{3  ,   2 ,  3 },
		 /*s2*/   	{3  ,   2 ,  3 },
		 /*s3*/   	{3  ,   3 ,  3 }
		};
		
		String TokenType[]={"Invalid","Invalid","Register","Invalid"};
		int cat;
		
//		for(int i=0;i<len;i++)
//		{
//			System.out.println("i="+ i);
//		
		int i=0;
		
		System.out.println("Entering");
			while(state!=3&&i<len)
			{
				System.out.println("Next iteration: i="+ i+"\n\n");
				char Char=NextChar(x,i);
				lexeme+=Char;
				System.out.println( lexeme + "\n Read Character"+Char+"\n\n");
				
				if(state==2)
				{
					ix.clear();
//					System.out.println("Recognised-->"+TokenType[state]+lexeme+"\n\n");
				}
				System.out.println("Pushing "+state);
				ix.push(state);
				if(Char=='r')
				cat=CharCat[0];
				else if(Char>='0' && Char <='9')
					cat=CharCat[1];
				else
					cat=CharCat[2];
				
				state=Transition[state][cat];
				
			
				
				i++;
				System.out.println("Cate:"+cat+"State"+state);
				System.out.println("Stacked"); 
				Object[] vals = ix.toArray();
			        for (Object obj : vals) {
			            System.out.print(obj+" ");
			        }
			        System.out.println("\n\n");
			}
			while(state!=2 && state!=0 )
			{
				state = (int)ix.pop();
				System.out.println("Popped"+state);
//				System.out.println("Out in the woods"+lexeme);
				i--;
				lexeme="";	
			}
			
			if(state==2)
			{
				ix.clear();
				System.out.println("Recognised-->"+TokenType[state]+lexeme);
			}	
			
//		}
		
		System.out.println("DONE");

	}
}
