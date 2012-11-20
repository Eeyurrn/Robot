/**
 * Representation of the Robot
 * @author Ian Tan
 *
 */
public class Robot
{
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	private int[] position = new int[2];
	private int direction;
	private TableTop tableTop;
	private boolean isPlaced = false;

	/**
	 * Default constructor
	 */
	public Robot()
	{
		this(0, 0, 0);
	}
/**
 * Constructor 
 * @param x position on X axis
 * @param y position on Y axis
 * @param direction direction the robot is facings
 */
	public Robot(int x, int y, int direction)
	{
		position[0] = x;
		position[1] = y;
		this.direction = direction;
	}

	public void move()
	{
		try
		{
			tableTop.moveRobot(position, this);
		}
		catch (Exception e)
		{

		}
	}

	public void left()
	{
		if (direction == NORTH)
		{
			direction = WEST;
		}
		else
		{
			direction -= 1;
		}
	}

	public void right()
	{
		if (direction == WEST)
		{
			direction = NORTH;
		}
		else
		{
			direction += 1;
		}
	}
/**
 * Reports the position.
 */
	public void report()
	{
		System.out.println(position[0] + "," + position[1] + ","
				+ getDirectionName());
	}

	public String getDirectionName()
	{
		switch (direction)
		{
		case 0:
			return "NORTH";
		case 1:
			return "EAST";
		case 2:
			return "SOUTH";
		case 3:
			return "WEST";
		default:
			return null;
		}
	}

	public int[] getPosition()
	{
		return position;
	}

	public void setPosition(int[] position)
	{
		this.position = position;
	}

	public int getDirection()
	{
		return direction;
	}

	public void setDirection(int direction)
	{
		if (direction < NORTH || direction > WEST)
		{
			System.out.println("BAD DIRECTION");
			return;
		}
		this.direction = direction;
	}

	public TableTop getTableTop()
	{
		return tableTop;
	}

	public void setTableTop(TableTop tableTop)
	{
		this.tableTop = tableTop;
	}

	public boolean isPlaced()
	{
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced)
	{
		this.isPlaced = isPlaced;
	}

}
