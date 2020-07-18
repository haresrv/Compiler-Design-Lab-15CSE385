package rdp;

import java.io.*;
import java.util.*;

public class parseE0 {

    static StringTokenizer st;
    static String curr;

    static void next() {
	try {
		if(curr!=null)
		System.out.println("Consumed -->"+curr);
	    curr=st.nextToken().intern();
	} catch( NoSuchElementException e) {
	    curr=null;
	}
    }

    static void error(String msg) {
	System.err.println(msg);
	System.exit(-1);
    }

    static void parseE() {
	// E -> T E1
    	System.out.println("(E)");
	parseT();
	parseE1();
    }

    static void parseE1() {
    	System.out.println("(E1)");
	// E1 -> T E1 | epsilon
	if (curr.equals("or")||curr.equals("nor")||curr.equals("xor")) {
	    next();
	    parseT();
	    parseE1();
	} else if(curr=="$"||curr==")" ) {
		
	} else {
	    error("Unexpected E1:"+curr);
	}
    }

    static void parseT() {
	// T -> F T1
    	System.out.println("(T)");
	parseF();
	parseT1();
    }

    static void parseT1() {
    	System.out.println("(T1)");
	// T1 -> * F T1 | epsilon
	if (curr.equals("and")||curr.equals("nand")||curr.equals("not")||curr.equals("i")||curr.equals("true")||curr.equals("false")) {
	    next();
	    parseT();
	    parseT1();
	} else if(curr.equals("xor") || curr.equals("or") || curr.equals("nor")||curr==")"||curr=="$") {
		
	} else {
	    error("Unexpected T1:"+curr);
	}
    }
    
    static void parseF()
    {System.out.println("(F)");
    	if (curr.equals("not")) {
    	    next();
    	    parseF();
    	} else if(curr=="i"||curr.equals("true")||curr.equals("false")||curr.equals("(")) {
    		parseP();
    	} else {
    	    error("Unexpected F:"+curr);
    	}
    }
    static void parseP() {
	// P -> ( E ) | i
    	System.out.println("(P)");
	if( curr=="(") {
	    next();
	    parseE();
	    if(curr==")") {
		next();
	    } else {
		error (") expected.");
	    }
	} else if(curr=="i") {
	    next();
	} else if(curr.equals("true")) {
	    next();
	} else if(curr.equals("false")) {
	    next();
	} 
	else {
	    error("Unexpected P :"+curr);
	}
    }

    public static void main(String args []) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
		String line=in.readLine();
		st = new StringTokenizer(line+" $");
		next();
		parseE();
		if(curr=="$"||curr==")") {
		    System.out.println("OK ");
		} else {
		    error("End expected");
		} 
    }
}