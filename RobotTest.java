public class RobotTest
{

	/**
	 * This is a test class which feeds in strings in a command line.
	 */
	public static void main(String[] args)
	{
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
	}

	public static void Test1()
	{
		System.out.println("Test 1");
		TableTop tableTop = new TableTop();
		try
		{
			// Testing a wrong sized array
			tableTop.moveRobot(new int[] { 1, 1, 1 }, null);
		}
		catch (Exception e)
		{

		}
		try
		{// Testing an out of bounds array
			tableTop.moveRobot(new int[] { 5, 5 }, null);
		}
		catch (Exception e)
		{

		}
	}

	public static void Test2()
	{
		System.out.println("Test 2");
		// Testing Place and face
		RobotMain.main(new String[] { "TEST", "PLACE 0,0,NORTH" });
	}

	public static void Test3()
	{
		System.out.println("Test 3");
		// Testing Place, face, move and report
		RobotMain.main(new String[] { "TEST", "PLACE 0,0,NORTH", "MOVE",
				"REPORT" });
	}

	public static void Test4()
	{
		System.out.println("Test 4");
		RobotMain.main(new String[] { "TEST", "PLACE 0,0,NORTH", "LEFT",
				"REPORT" });
	}

	public static void Test5()
	{
		System.out.println("Test 5");
		RobotMain.main(new String[] { "TEST", "PLACE 1,2,EAST", "MOVE", "MOVE",
				"LEFT", "MOVE", "REPORT" });
	}

	public static void Test6()
	{ // Testing invalid move
		System.out.println("Test 6");
		RobotMain.main(new String[] { "TEST", "PLACE 0,0,WEST", "MOVE",
				"RIGHT", "REPORT" });
	}

	public static void Test7()
	{
		System.out.println("Test 7");
		// Testing the robot without placing it
		RobotMain.main(new String[] { "TEST", "MOVE", "RIGHT", "REPORT" });
	}
}
