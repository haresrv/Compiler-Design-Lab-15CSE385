package lexeme;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.io.*; 
import java.io.FileWriter;

public class lexanalyse {


	public static boolean function(String input)
	{
			String[] keywords={"abstract","assert","boolean","break","byte","case","catch","char","class","const","continue","default","do",
					"double","else","enum","extends","final","finally","float","for","goto","if","implements","import","instanceof",
					"int","interface","long","native","new","package","private","protected","public","return","short","static","strictfp",
					"super","switch","synchronized","this","throw","throws","transient","try","void","volatile","while","true","false","null","System.out.println"};
			
			List<String> list = Arrays.asList(keywords);
			if(list.contains(input)){
			    return true;
			}
			else
			{
				return false;
			}
		
	}
	

    public static void filewrite(String str) 
    { 
        try { 
        	String fileName="C:/Users/TEMP/Downloads/cp.txt";
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(fileName, true)); 
            out.write(str); 
            out.write(String.format("%n"));
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    } 
	
	public static void checker(String input)
	{
		
		String finalise_mat[]={"Nothing","<Nothing read>","<ID>","<IF>","<ID>","<ERR>","<REAL>","<NUM>","<REAL>","<Error>","<Error>"};
		//					  {    	0   ,	1,				 2,		3,		4,		5,		6,		7,		8,		9,          10}	
		
		int edges[][]={
					//[0   ,       1     , 2 ,  3  ,  4 , 5]
				    //[0-9 , a-e&g-h&j-z , f ,   i ,  . , _]
	/*State-1*/				{7 , 4 , 4 , 2 , 5 , 4},
	/*State-2*/				{4 , 4 , 4 , 2 , 9 , 4},
	/*State-3*/				{4 , 4 , 4 , 2 , 9 , 4},
	/*State-4*/				{4 , 4 , 4 , 4 , 9 , 4},
	/*State-5*/				{6 , 9 , 9 , 9 , 9 , 9},
	/*State-6*/				{6 , 9 , 9 , 9 , 9 , 9},
	/*State-7*/				{7 , 9 , 9 , 9 ,10 , 9},
	/*State-8*/				{8 , 9 , 9 , 9 , 9 , 9},
	/*State-9*/				{9 , 9 , 9 , 9 , 9 , 9},
	/*State-10*/			{8 , 9 , 9 , 9 , 9 , 9},

		//					[0 , 1 , 2 , 3 , 4 , 5]
		};
		
		int i;
		int x=1;
		int flag=0;
		for(i=0;i<input.length();i++)
		{
//			System.out.println("-----------------------------");
//			
//			System.out.println("Analysing "+input.charAt(i));
//			System.out.println("Current state"+x);
//			
//			System.out.println("-----------------------------");
			if(input.charAt(i)==';')
			{
				if(input.charAt(0)!=';')
				{
					System.out.println("<"+finalise_mat[x]+","+input.split("[;]",2)[0]+">");
					filewrite("<"+finalise_mat[x]+","+input.split("[;]",2)[0]+">");
				}
				
				if(input.split("[;]",2)[0].length()!=input.length())
				{
				input=input.split("[;]",2)[1];
				i=-1;
				x=1;
				flag=1;
				}
				System.out.println("<SEMICOLON>");
				filewrite("<SEMICOLON>");
			}
			else if(input.charAt(i)=='+')
			{
				if(input.charAt(0)!='+')
					{
					filewrite("<"+finalise_mat[x]+","+input.split("[+]",2)[0]+">");
					System.out.println("<"+finalise_mat[x]+","+input.split("[+]",2)[0]+">");
				
					}
				if(input.split("[+]",2)[0].length()!=input.length())
					{
					input=input.split("[+]",2)[1];
					i=-1;
					x=1;
					flag=1;
					System.out.println("sjkkskj"+input);
					}
				else
				{
					input=input.split("[+]",2)[1];
					i=-1;
					x=1;
					flag=0;
					
				}
				System.out.println("<OPERATOR,+>");
				filewrite("<OPERATOR,+>");
			}
			else if(input.charAt(i)==')')
			{
				filewrite("<CLOSE PARANTHESIS>");
				System.out.println("<CLOSE PARANTHESIS>");
			}
			else if(input.charAt(i)=='(')
			{
				filewrite("<OPEN PARANTHESIS>");
				System.out.println("<OPEN PARANTHESIS>");
			}
			else if(input.charAt(i)=='{')
			{
				filewrite("<OPEN CURLY>");
				System.out.println("<OPEN CURLY>");
			}
			else if(input.charAt(i)=='}')
			{
				filewrite("<CLOSE CURLY>");
				System.out.println("<CLOSE CURLY>");
			}
			else if(input.charAt(i)=='-')
			{
				filewrite("<OPERATOR,->");
				System.out.println("<OPERATOR,->");
			}
			else if(input.charAt(i)=='=')
			{
				if(input.charAt(0)!='=')
				{
					System.out.println("<"+finalise_mat[x]+","+input.split("[=]",2)[0]+">");
					filewrite("<"+finalise_mat[x]+","+input.split("[=]",2)[0]+">");
				}
				if(input.split("[=]",2)[0].length()!=input.length())
				{
				input=input.split("[=]",2)[1];
			 	i=-1;
				x=1;
				flag=1;
//				System.out.println("CHHHHHHHH"+input);
				}
				
				System.out.println("<OPERATOR,=>");
				filewrite("<OPERATOR,=>");
			}
			else if(input.charAt(i)>='0'&&input.charAt(i)<='9'&&x==1)
				{
			
				x=edges[x-1][0];
//				System.out.println("State change "+x);
//				System.out.println(finalise_mat[x]);
				}
			else if((input.charAt(i)=='_')||(input.charAt(i)>='a'&&input.charAt(i)<='h')||(input.charAt(i)>='j'&&input.charAt(i)<='z')&&x==1)
			{
				x=edges[x-1][1];
//				System.out.println("HERE");
//				System.out.println("State change "+x);
//				System.out.println(finalise_mat[x]);
			}
			
			else if(input.charAt(i)=='i'&&x==1)
			{
				x=edges[x-1][3];
				
//				System.out.println("State change "+x);
//				
//				System.out.println(finalise_mat[x]);
				
			}
			else if(input.charAt(i)=='f'&&x==2)
			{
				x=edges[x-1][2];
				
//				System.out.println("State change "+x);
//				
//				System.out.println(finalise_mat[x]);
				
			}
			else if(input.charAt(i)>='0'&&input.charAt(i)<='9'&&(x>=1&&x<11&&x!=7))
			{
				x=edges[x-1][0];
//				System.out.println("State change "+x);
//				System.out.println(finalise_mat[x]);
			}
			else if(input.charAt(i)>='0'&&input.charAt(i)<='9'&&(x==7))
			{
				x=edges[x-1][0];
//				System.out.println("State changes "+x);
//				System.out.println(finalise_mat[x]);
			}
			else if(input.charAt(i)=='.')
			{
				x=edges[x-1][4];
//				System.out.println("State change "+x);
//				System.out.println(finalise_mat[x]);
				
			}
			
			else if((input.charAt(i)!='.')&&!Character.isDigit(input.charAt(i))&&!(Character.isAlphabetic(input.charAt(i))))
			{
				System.out.println("Special Character");
				x=9;
			}
		}

			if(flag!=1)
		{
				System.out.println("Final Identified State is <"+finalise_mat[x]+","+input+">");
				filewrite("<"+finalise_mat[x]+","+input+">");
		}		
	}
	
	public static void main(String a[]) throws IOException{
	
Scanner s=new Scanner(System.in);
System.out.println("Enter anything Type your program in txt file and import in program:");

String inputz= s.nextLine();
System.out.println("Reading from File\n-------------------------\n");

File file = new File("C:/Users/TEMP/Downloads/cp.java"); 

BufferedReader br = new BufferedReader(new FileReader(file)); 

String st; 
while ((st = br.readLine()) != null) 
  {
	  String[] sp=st.split("(?=\\()|(?=\\))|(?=\\{)|(?=\\})|(\")|(\\s+)");
	for(String input:sp)
	  { 
if(input.equals("("))
{
	filewrite("<OPEN PARANTHESIS>");
	System.out.println("<OPEN PARANTHESIS>");
}
	else if(input.equals(")"))
	{
		filewrite("<CLOSE PARANTHESIS>");
		System.out.println("<CLOSE PARANTHESIS>");	
	}
else if(input.equals("{")){
	filewrite("<OPEN CURLY>");
	System.out.println("<OPEN CURLY>");
}
else if(input.equals("}"))
{
	filewrite("<CLOSE CURLY>");
	System.out.println("<CLOSE CURLY>");	
}
else if(function(input))
{
	filewrite("<Keyword,"+input+">");
	System.out.println("<Keyword,"+input+">");
}
else 
	{
//	System.out.println("Calling Checker"+input);
	checker(input);}
	  }
  }

System.out.println("Output written to file");
}
	
	
}
