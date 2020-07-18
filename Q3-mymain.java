

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class mymain {

	public static int sod(int m)
	{
		int sum=0,n=0;
		 while(m > 0)
	        {
	            n = m % 10;
	            sum = sum + n;
	            m = m / 10;
	        }
	        System.out.println("Sum of Digits:"+sum);
	        return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		 {
		 CharStream input = new ANTLRFileStream("C:\\Users\\cb.en.u4cse17119\\eclipse-workspace\\token2\\src\\input");
		/* give your filepath in the above place*/
		 Hello lexer = new Hello(input);
		 Token token;
		 while ((token = lexer.nextToken()).getType()!=-1) {
			 System.out.println("<---Next Token--->");
	      if(token.getType()==1)
	      {
	    	  System.err.println("Token is-->"+token.getText());

	    	  int yy=Integer.parseInt(token.getText().substring(0,2));
	    	  int mm=Integer.parseInt(token.getText().substring(2,4));
	    	  int dd=Integer.parseInt(token.getText().substring(4,6));
	    	  
	    	  System.out.println("Person born in "+dd+" /"+mm+"/19"+yy);
	    	  
	    	  int c=Integer.parseInt(token.getText().substring(10,11));
	    	  
	    	  if(c==0)
	    		  System.out.println("SA Citizen");
	    	  else if(c==1)
	    		  System.out.println("Resident Citizen");
	    	  else
	    	  {  System.out.println("Citizenship can't be recognised..");
	    	  		continue;
	    	  }
	    	
	    	  int a=Integer.parseInt(token.getText().substring(11,12));
	    	  int z=Integer.parseInt(token.getText().substring(12,13));
	    	  System.out.println("\nc="+c);
	    	  System.out.println("a="+a);
	    	  System.out.println("z="+z);
	    	  
	    	  int A=Integer.parseInt(token.getText().substring(0,1))+Integer.parseInt(token.getText().substring(2,3))+Integer.parseInt(token.getText().substring(4,5))+Integer.parseInt(token.getText().substring(6,7))+Integer.parseInt(token.getText().substring(8,9))+Integer.parseInt(token.getText().substring(10,11));				
	    	  System.out.println("\nLuhn's Alog\nA="+A);
	    	  
	    	  int B=Integer.parseInt(token.getText().substring(1,2));
	    	  System.out.println("B="+B);
	    	  B+=(Integer.parseInt(token.getText().substring(3,4)));
	    	  B*=10;
	    	  System.out.println("B="+B);
	    	  B+=(Integer.parseInt(token.getText().substring(5,6)));
	    	  B*=10;
	    	  System.out.println("B="+B);
	    	  B+=(Integer.parseInt(token.getText().substring(7,8)));
	    	  B*=10;
	    	  System.out.println("B="+B);
	    	  B+=(Integer.parseInt(token.getText().substring(9,10)));
	    	  B*=10;
	    	  System.out.println("B="+B);
	    	  B+=(Integer.parseInt(token.getText().substring(11,12)));
	    	  
	    	  System.out.println("B="+B);
	    	  int C=2*B;
	    	  C=sod(C);
	    	  
	    	  int D=A+C;
	    	  System.out.println("D="+D);
	    	  int Z=10 - (D%10);
	    	  System.out.println("Z="+Z);
	    	  if(z==Z)
	    		  System.out.println("Checksum valid\n\n Valid ID Card");
	    	  else
	    		  System.out.println("Checksum Invalid"+Z);

	    	  

	      
	      
	      }
	      else
	      {
	    	  System.err.println("Invalid");
	    		 System.err.println(token.getText());
	    		 
			
	      }
		
		 	
		 }
		 
		 }
		 catch(Exception e){

		 System.out.println(e);
		 }
	}

}
