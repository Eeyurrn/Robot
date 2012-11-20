import java.util.Scanner;

/**
 * This is the main class for the Robot, note put "TEST" in front if all
 * commands are being fed through a command line. Otherwise the program will
 * perform commands one by one, with the user entering the next command. Enter
 * "Q" to exit the program
 * 
 * @author Ian Tan
 * 
 */
public class RobotMain
{

	static Robot robot = new Robot();
	static TableTop tableTop = new TableTop();
	static boolean testMode = false;
	static String[] allDirections =
	{ "NORTH", "EAST", "SOUTH", "WEST" };

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			if (args[0].compareTo("TEST") == 0)
			{
				testMode = true;
			}
			if (testMode)
			{
				for (String string : args)
				{
					performCommands(string);
				}
			}
		}
		else
		{
			readCommand();
		}
	}
/**
 * Reads Commands entered by user using standard input
 */
	public static void readCommand()
	{
		Scanner scanner = new Scanner(System.in);
		String command = "";
		while (command.compareTo("Q") != 0)
		{
			command = scanner.nextLine();
			performCommands(command);
		}
	}

	public static void performCommands(String string)
	{
		if (string.startsWith("PLACE"))
		{
			robot.setTableTop(tableTop);
			String placement = string.split(" ")[1];
			place(placement);
			robot.setPlaced(true);
		}
		if (string.compareTo("MOVE") == 0 && robot.isPlaced())
		{
			robot.move();
		}
		else if (string.compareTo("REPORT") == 0 && robot.isPlaced())
		{
			robot.report();
		}
		else if (string.compareTo("LEFT") == 0 && robot.isPlaced())
		{
			robot.left();
		}
		else if (string.compareTo("RIGHT") == 0 && robot.isPlaced())
		{
			robot.right();
		}
	}

	public static void place(String placement)
	{
		int x, y, direction;
		String[] details = placement.split(",");

		x = Integer.parseInt(details[0]);
		y = Integer.parseInt(details[1]);
		direction = -1;

		String temp = details[2].toUpperCase();
		temp = temp.trim();

		for (int i = 0; i < 4; i++)
		{
			if (temp.compareTo(allDirections[i]) == 0)
			{
				direction = i;

				break;
			}
		}
		robot.setPosition(new int[]
		{ x, y });
		robot.setDirection(direction);

	}

}
