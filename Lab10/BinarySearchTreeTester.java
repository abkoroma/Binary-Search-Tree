import java.io.PrintStream;



public class BinarySearchTreeTester {
	public static int score;
	public static PrintStream out;
	public static PrintStream err;
	public static int testNumber;
	
	public static void main(String[] args) {
		score = 0;
		out = System.out;
		err = System.out;
		testNumber = 1;
		out.println("CORE");
		addTest(10); //Tests using the drawTree() method so you can test add without doing toString yet.
		toStringTest(10); //Other tests require toString, so we test this one first.
		removeTest(10); //Depends on add and toString
		searchTest(10); //Depends on addTest
		

		out.println("BONUS");

		out.println("The below score assumes correct submission and that you obtained full style points.  Your actual score may be up to 20 points fewer.");
		out.println("Completed " + (testNumber-1) + " out of " + (testNumber-1) + " Tests for a total score of: 40 (no crashes) + 20 (submission and style) + " + score + " (from tests) = " + (60+score));
	}
	
	private static int addTest(int pnts)
	{
		
		boolean correct = true;
		String comment = "";
		String testName = "addTest";
		String expectedTree = "|	|	|-------8\n" + 
				"|	|-------7\n" + 
				"|-------6\n" + 
				"5\n" + 
				"|	|	|-------4\n" + 
				"|	|-------3\n" + 
				"|-------2\n" + 
				"|	|-------1\n";
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		try {
			b.add(5);
			b.add(6);
			b.add(7);
			b.add(8);
			b.add(2);
			b.add(3);
			b.add(4);
			b.add(1);
			if(!evalTree(b, expectedTree))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int toStringTest(int pnts)
	{
		
		boolean correct = true;
		String comment = "";
		String testName = "toStringTest";
		String expected = "[1, 2, 3, 4, 5, 6, 7, 8]";
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		try {
			b.add(5);
			b.add(6);
			b.add(7);
			b.add(8);
			b.add(2);
			b.add(3);
			b.add(4);
			b.add(1);
			if(!eval(b, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int removeTest(int pnts)
	{
		
		boolean correct = true;
		String comment = "";
		String testName = "removeTest";
		String expected = "[1, 2, 4, 7, 8]";
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		try {
			b.add(5);
			b.add(6);
			b.add(7);
			b.add(8);
			b.add(2);
			b.add(3);
			b.add(4);
			b.add(1);
			b.remove(3);
			b.remove(5);
			b.remove(6);
			if(!eval(b, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	

	private static int searchTest(int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "searchTest";
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		try {
			b.add(5);
			b.add(6);
			b.add(7);
			b.add(8);
			b.add(2);
			b.add(3);
			b.add(4);
			b.add(1);
			if(!b.search(5))
			{
				correct = false;
				comment = "Said 5 was not in the tree, but it is";
			}
			if(!b.search(4))
			{
				correct = false;
				comment = "Said 4 was not in the tree, but it is";
			}
			if(b.search(10))
			{
				correct = false;
				comment = "Said 10 was in the tree, but it isn't";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
 	private static boolean eval(BinarySearchTree<Integer> b, String expected)
	{
		if(b.toString().equals(expected))
		{
			out.println("(PASS) Expected:  " + expected + "\nand matched with: " + b);
			return true;
		}
		out.println("(FAIL) Expected: " + expected + "\nbut got:         " + b);
		return false;
	}
 	
 	private static boolean evalTree(BinarySearchTree<Integer> b, String expected)
	{
 		String s = b.drawTree();
		if(s.equals(expected))
		{
			out.println("(PASS) Expected:  \n" + expected + "\n\nand matched with: \n" + s);
			return true;
		}
		out.println("(FAIL) Expected: \n" + expected + "\nbut got:         \n" + s);
		return false;
	}

	private static int disp(boolean equal, int pnts, String test, String comment) {
		String output = "TEST " + testNumber + ") " + test + " -> ";
		if(!equal)
			output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
		else
			output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
		output += " " + comment;
		out.println(output + "\n");
		testNumber++;
		if(equal)
		{
			score += pnts;
			return pnts;
		}
		else
			return 0;
	}


}
