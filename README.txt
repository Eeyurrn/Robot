README for ROBOT for SitePoint Technical Test

Author Ian Sergeant Tan

This is a readme describing the classes written in Java using JRE 1.6

Robot.java - This is the class which contains data about the robot and controls its behaviour, with the exception of movement

TableTop.java-This class serves as representation of the TableTop that the robot will move on. Also moves the robot 

RobotMain.java- The runnable class, can use a command line to enter all the commands at once by placing "TEST" in front which will set the class to perform commands automatically. Otherwise, the program will wait for commands by user input and perform them one by one

RobotTest.java- A test class for the Robot, runs individual tests by using the Test mode.

Using the program. 
-Compile using "javac RobotMain.java"
-Run the RobotMain class using "java RobotMain"
-Enter in commands using standard input one by one or VIA command line prefixed with TEST flag:

PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT



-PLACE will put the toy robot on the table in position X,Y and facing NORTH,
  SOUTH, EAST or WEST.

-The origin (0,0) can be considered to be the SOUTH WEST most corner.

-The first valid command to the robot is a PLACE command, after that, any
  sequence of commands may be issued, in any order, including another PLACE
  command. The application should discard all commands in the sequence until a
  valid PLACE command has been executed.

-MOVE will move the toy robot one unit forward in the direction it is
  currently facing.

-LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
  without changing the position of the robot.

-REPORT will announce the X,Y and F of the robot. This can be in any form, but
  standard output is sufficient.
********NORMAL MODE ONLY***********
-Q will exit the program in normal mode.
********COMMAND LINE ONLY***********
-TEST This has to be added as the first argument, this will allow the above commands to be entered in a single command line delimited by spaces. See RobotTest.java for examples on implementation, has to be used in the command line, cannot be used using standard input


Thank you for reading and enjoy the robot.