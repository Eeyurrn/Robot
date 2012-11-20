import java.util.HashMap;

/**
 * The TableTop that the robot travels on. Underlying representation is a
 * HashMap using an array with the coordinates as a Key, the value stored is the
 * robot
 * 
 * @author Ian Tan
 * 
 */
public class TableTop extends HashMap<int[], Robot>
{
/**
 * Constructor
 */
	//The maximum coordinates for each axis.
	private final int MIN =0;
	private final int MAX =4;
	public TableTop()
	{
		// Sets the TableTop up. Null entries in the hashmap indicate an empty
		// space
		super();
	}
/**
 * Processes the Movement of the Robot.
 */
	public void moveRobot(int[] position, Robot robot) throws Exception
	{

		checkPosition(position);

		int direction = robot.getDirection();
		int posX, posY;

		posX = robot.getPosition()[0];
		posY = robot.getPosition()[1];
		int[] newPos;
		switch (direction)
		{
		case Robot.NORTH:
			// Sets current position as empty by adding null to the hashmap
			newPos = new int[]
			{ posX, posY + 1 };
			checkPosition(newPos);
			// Sets current position as occupied and sets Robot's own position.
			super.put(new int[]
			{ posX, posY }, null);
			super.put(newPos, robot);
			robot.setPosition(newPos);
			break;
		case Robot.EAST:

			newPos = new int[]
			{ posX + 1, posY };
			checkPosition(newPos);
			super.put(new int[]
			{ posX, posY }, null);
			super.put(newPos, robot);
			robot.setPosition(newPos);
			break;
		case Robot.SOUTH:

			newPos = new int[]
			{ posX, posY - 1 };
			checkPosition(newPos);
			super.put(new int[]
			{ posX, posY }, null);
			super.put(newPos, robot);
			robot.setPosition(newPos);
			break;
		case Robot.WEST:
			newPos = new int[]
			{ posX - 1, posY };
			checkPosition(newPos);
			super.put(new int[]
			{ posX, posY }, null);
			super.put(newPos, robot);
			robot.setPosition(newPos);
			break;
		default:
			break;
		}

	}
/**
 * Places robot on the table top
 * @param position Position of robot
 * @param robot Robot object to be placed
 */
	public void placeRobot(int[] position, Robot robot)
	{
		try
		{
			if (checkPosition(position))
			{
				super.put(position, robot);
			}
		}
		catch (Exception e)
		{
			
		}
	}
/**
 * Provides the sanity checking of the position array. Ensures the robot does not go out of bounds. 
 * @param position
 * @return
 * @throws Exception Explaining the reasons for the error.
 */
	public boolean checkPosition(int[] position) throws Exception
	{
		if (position.length != 2)
		{
			throw new Exception(
					"Postion array is wrong size:position array must contain 2 integers");
		}
		for (int i = 0; i < position.length; i++)
		{
			if (position[i] < MIN || position[i] > MAX)
			{
				throw new Exception(
						"Position is out of bounds: please set x and y coordinate between 0 and 4");
			}
		}
		return true;
	}

}
