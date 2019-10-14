/*
Developer: Thomas Roller
File:      Maze.java
Class:     Maze
Java:      SE8
*/

import java.util.concurrent.ArrayBlockingQueue;
import java.lang.Math;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Maze {

	private static final char EMPTY = ' ';
	private static final char WALL = '#';
	private static final char START = 'S';
	private static final char FINISH = 'F';

	// Getter methods
	public static char getEMPTY ()  { return EMPTY; }
	public static char getWALL ()   { return WALL; }
	public static char getSTART ()  { return START; }
	public static char getFINISH () { return FINISH; }

	// METHOD
	// Imports a maze from a file as String[]
	public static String[] importMaze (String filename) {
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null) {
				data.add(line);
				line = in.readLine();
			}
			in.close();
      return data.toArray(new String[0]);
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to fine file: \"" + filename + "\"");
		}
		catch (IOException e) {
			System.out.println("Caught IO Exception");
		}
		return null;
	}

	// METHOD
	// Exports a String[] maze to a file
	public static boolean exportMaze (String filename, String[] maze) {
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			for (int i = 0; i < maze.length; ++i) {
				writer.write(maze[i] + "\n");
			}
			writer.close();
			return true;
		}
		catch (IOException e) {
			System.out.println("Caught IOException");
		}
		return false;
	}

	// METHOD
	// Exports a char[][] maze to a file
	public static boolean exportMaze (String filename, char[][] maze) {
		return exportMaze(filename, convert(maze));
	}

	// METHOD
	// Exports a String created by a layout method
	public static boolean exportMaze (String filename, String layout) {
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			writer.write(layout);
			writer.close();
			return true;
		}
		catch (IOException e) {
			System.out.println("Caught IOException");
		}
		return false;
	}

	// METHOD
	// Converts a String array into a 2-dimentional char array
	public static char [][] convert (String [] array) {
		char [][] maze = new char [array.length][array[0].length()];

		for (int row = 0; row < array.length; row += 1) {
			for (int col = 0; col < array[0].length(); col += 1) {
				maze[row][col] = array[row].charAt(col);
			}
		}
		return maze;
	}

	// METHOD
	// Converts a 2-dimentional char array into a String array
	public static String [] convert (char [][] array) {
		String [] maze = new String [array.length];

		for (int row = 0; row < array.length; row += 1) {
			for (int col = 0; col < array[0].length; col += 1) {
				if (col == 0) {
					maze[row] = Character.toString(array[row][col]);
				}
				else {
					maze[row] += array[row][col];
				}
			}
		}
		return maze;
	}

	// METHOD
	// Provides a layout of the maze
	public static String layout (Point [] path, char [][] maze, boolean addSpace) {
		String mazeLayout = "";
		char [][] solutionMaze = solutionToMaze(maze, path);

		for (int row = 0; row < maze.length; row += 1) {
			for (int col = 0; col < maze[0].length; col += 1) {
				if (path != null && (new Point (row, col)).inArray(path) && maze[row][col] == EMPTY) {
					mazeLayout += solutionMaze[row][col];
					if (addSpace) { mazeLayout += " "; }
				}
				else {
					mazeLayout += maze[row][col];
					if (addSpace) { mazeLayout += " "; }
				}
			}
			if (row != maze.length - 1) {
				mazeLayout += "\n";
			}
		}

		return mazeLayout;
	}

	// METHOD
	// Provides a layout of the maze
	public static String layout (Point [] path, char [][] maze) {
		return layout (path, maze, true);
	}

	// METHOD
	// Provides a layout of the maze
	public static String layout (char [][] maze) {
		return layout(null, maze);
	}

	// METHOD
	// Convert a layout String into an array of Strings
	public static String[] convertLayout (String layout) {
		ArrayList<String> data = new ArrayList<String>();
		int index = 0;
		String line = "";
		char currChar;
		while (index < layout.length()) {
			while (index < layout.length()) {
				currChar = layout.charAt(index);
				if (currChar == '\n') { break; }
				line += currChar;
				++index;
			}
			data.add(line);
			line = "";
			++index;
		}
		return data.toArray(new String[0]);
	}

	// METHOD
	// Locate the starting location of the maze
	private static Point locateStart (char [][] maze) {

		for (int row = 0; row < maze.length; row += 1) {
			for (int col = 0; col < maze[0].length; col += 1) {
				if (maze[row][col] == START) {
					return new Point(row, col);
				}
			}
		}
		return null;
	}

	// METHOD
	// Gets the traversable space within a maze
	private static int mazeSpace (char [][] maze) {
		int openSpace = 0;

		for (int row = 0; row < maze.length; row += 1) {
			for (int col = 0; col < maze[0].length; col += 1) {
				if (maze[row][col] == EMPTY || maze[row][col] == START || maze[row][col] == FINISH) {
					openSpace += 1;
				}
			}
		}
		return openSpace;
	}

	// METHOD
	// Gets the used length of a Point array
	private static int arraySize (Point [] array) {
		int size = 0;

		for (int loc = 0; loc < array.length; loc += 1) {
			if (array[loc] != null) {
				size += 1;
			}
		}
		return size;
	}

	// METHOD
	// Calls the recursive isPossibleRecurse method
	public static boolean isPossibleRecr (char [][] maze) {

		char [][] visited = new char [maze.length][maze[0].length];

		boolean possible = isPossibleRecurse (locateStart(maze).getX(), locateStart(maze).getY(), maze, visited);

		// Reset the visited array
		visited = new char [maze.length][maze[0].length];

		return possible;

	}

	// METHOD
	// Uses the iterative getBreadthPath method to determine is the maze is possible
	public static boolean isPossibleIter (char [][] maze) {
		if (getBreadthPath(maze) == null) { return false; }
		return true;
	}

	// METHOD
	// Recursively checks if the maze is possible
	private static boolean isPossibleRecurse (int r, int c, char [][] maze, char [][] visited) {

		if (maze[r][c] == FINISH) {
			return true;
		}

		if (maze[r][c] == WALL || visited [r][c] == '*') {
			return false;
		}

		visited[r][c] = '*';

		return isPossibleRecurse (r + 1, c, maze, visited) || isPossibleRecurse (r - 1, c, maze, visited) ||
			isPossibleRecurse (r, c + 1, maze, visited) || isPossibleRecurse (r, c - 1, maze, visited);

	}

	// METHOD
	// Calls the recursive getDepthPathRecurse method
	public static Point [] getDepthPath (char [][] maze) {

		Point [] path = new Point [mazeSpace(maze)];
		Point [] mazePath;
		char [][] visited = new char [maze.length][maze[0].length];

		path = getDepthPathRecurse (locateStart(maze).getX(), locateStart(maze).getY(), path, maze, visited);

		// Reset the visited array
		visited = new char [maze.length][maze[0].length];

		if (path == null) {
			return null;
		}

		// Reverse the Point array

		mazePath = new Point [arraySize(path)];
		for (int rev = mazePath.length; rev > 0; rev -= 1) {
			mazePath[mazePath.length - rev] = path[rev - 1];
		}

		return mazePath;

	}

	// METHOD
	// Provides the depth search path via recursion
	private static Point [] getDepthPathRecurse (int r, int c, Point [] path, char [][] maze, char [][] visited) {

		if (maze[r][c] == FINISH) {
			path[arraySize(path)] = new Point(r, c);
			return path;
		}

		if (maze[r][c] == WALL || visited [r][c] == '*') {
			return null;
		}

		visited[r][c] = '*';

		if (getDepthPathRecurse (r + 1, c, path, maze, visited) != null) {
			path[arraySize(path)] = new Point(r, c);
			return path;
		}
		if (getDepthPathRecurse (r - 1, c, path, maze, visited) != null) {
			path[arraySize(path)] = new Point(r, c);
			return path;
		}
		if (getDepthPathRecurse (r, c + 1, path, maze, visited) != null) {
			path[arraySize(path)] = new Point(r, c);
			return path;
		}
		if (getDepthPathRecurse (r, c - 1, path, maze, visited) != null) {
			path[arraySize(path)] = new Point(r, c);
			return path;
		}

		return null;

	}

	// METHOD
	// Calls the getBreadthPathLoop method
	public static Point [] getBreadthPath (char [][] maze) {

		Point [] path = new Point [mazeSpace(maze)];
		Point [] mazePathTemp;
		Point [] mazePath;
		char [][] visited = new char [maze.length][maze[0].length];
		ArrayBlockingQueue<Point> queue = new ArrayBlockingQueue<Point>(mazeSpace(maze));

		queue.add(locateStart(maze));
		path[0] = locateStart(maze);

		path = getBreadthPathLoop (locateStart(maze).getX(), locateStart(maze).getY(), path, maze, visited, queue);

		// Reset the visited array
		visited = new char [maze.length][maze[0].length];

		// Reset the queue
		queue = new ArrayBlockingQueue<Point>(mazeSpace(maze));

		if (path == null) {

			return null;

		}

		// Find and reverse the Point array

		mazePathTemp = new Point [10000];
		Point curPrePoint = null;

		if (arraySize(path) - 1 >= 0) {
			curPrePoint = path[arraySize(path) - 1];
		}

		int counter = 0;

		while (curPrePoint != null) {
			mazePathTemp[counter] = curPrePoint;
			curPrePoint = curPrePoint.getPrePoint();
			counter += 1;
		}

		mazePath = new Point [counter];

		for (int rev = mazePath.length; rev > 0; rev -= 1) {
			mazePath[mazePath.length - rev] = mazePathTemp[rev - 1];
		}

		return mazePath;

	}

	// METHOD
	// Provides the maze's path via breadth search (returns the entire search)
	private static Point [] getBreadthPathLoop (int r, int c, Point [] path, char [][] maze, char [][] visited, ArrayBlockingQueue<Point> queue) {

		Point currentLocation;

		while (true) {
			currentLocation = queue.peek();
			if (queue.size() == 0) {
				return null;
			}

			if (maze[currentLocation.getX()][currentLocation.getY()] == FINISH) {
				path[arraySize(path) - 1] = currentLocation;
				return path;
			}

			currentLocation = queue.remove();
			path = addDirections(currentLocation, path, maze, visited, queue);
			currentLocation = queue.peek();
		}
	}

	// METHOD
	// Used to check and add directions (used in getBreadthPathLoop())
	private static Point [] addDirections (Point curLoc, Point [] path, char [][] maze, char [][] visited, ArrayBlockingQueue<Point> queue) {

		if (maze[curLoc.getX() + 1][curLoc.getY()] != WALL && visited[curLoc.getX() + 1][curLoc.getY()] != '*') {
			queue.add(new Point(curLoc.getX() + 1, curLoc.getY(), curLoc));
			if (arraySize(path) > 0) { path[arraySize(path) - 1] = new Point(curLoc.getX() + 1, curLoc.getY(), curLoc); }
			visited[curLoc.getX() + 1][curLoc.getY()] = '*';
		}
		if (maze[curLoc.getX() - 1][curLoc.getY()] != WALL && visited[curLoc.getX() - 1][curLoc.getY()] != '*') {
			queue.add(new Point(curLoc.getX() - 1, curLoc.getY(), curLoc));
			if (arraySize(path) > 0) { path[arraySize(path) - 1] = new Point(curLoc.getX() - 1, curLoc.getY(), curLoc); }
			visited[curLoc.getX() - 1][curLoc.getY()] = '*';
		}
		if (maze[curLoc.getX()][curLoc.getY() + 1] != WALL && visited[curLoc.getX()][curLoc.getY() + 1] != '*') {
			queue.add(new Point(curLoc.getX(), curLoc.getY() + 1, curLoc));
			if (arraySize(path) > 0) { path[arraySize(path) - 1] = new Point(curLoc.getX(), curLoc.getY() + 1, curLoc); }
			visited[curLoc.getX()][curLoc.getY() + 1] = '*';
		}
		if (maze[curLoc.getX()][curLoc.getY() - 1] != WALL && visited[curLoc.getX()][curLoc.getY() - 1] != '*') {
			queue.add(new Point(curLoc.getX(), curLoc.getY() - 1, curLoc));
			if (arraySize(path) > 0) { path[arraySize(path) - 1] = new Point(curLoc.getX(), curLoc.getY() - 1, curLoc); }
			visited[curLoc.getX()][curLoc.getY() - 1] = '*';
		}
		return path;
	}

	// METHOD
	// Provides a method of displaying the path
	public static String pathList (Point [] path) {

		String pathString = "";

		if (path == null) {
			return "No existing path!";
		}

		for (int loc = 0; loc < path.length; loc += 1) {
			if (path[loc] != null) {
				pathString += path[loc];
				if (loc != path.length - 1) {
					pathString += " -> ";
				}
			}
		}
		return pathString;
	}

	// METHOD
	// Provides the length of the path
	public static int pathLength (Point [] path) {

		if (path != null) {
			return path.length;
		}

		return -1;

	}

	// METHOD
	// Provides the path as a char array via v^><
	private static char [] pathDirectionsChar (Point [] path) {

		char [] directions = null;

		if (path != null) {
			directions = new char [arraySize(path)];
			for (int loc = 0; loc < path.length - 1; loc += 1) {

				if (path[loc + 1].getX() > path[loc].getX()) {
					directions[loc] = 'v';
				}
				else if (path[loc + 1].getX() < path[loc].getX()) {
					directions[loc] = '^';
				}
				else if (path[loc + 1].getY() > path[loc].getY()) {
					directions[loc] = '>';
				}
				else if (path[loc + 1].getY() < path[loc].getY()) {
					directions[loc] = '<';
				}
			}
		}
		return directions;
	}

	// METHOD
	// Provides the path as a String array via v^><
	public static String pathDirections (Point [] path) {

		char [] directions = pathDirectionsChar(path);
		String directionsString = "START ";

		if (directions != null) {
			for (int loc = 0; loc < directions.length; loc += 1) {
				directionsString += directions[loc] + " ";
			}
			return directionsString + "FINISH";
		}
		return "No existing path!";
	}

	// METHOD
	// Places the solution into a 2-dimentional char array as the solution is positioned in the maze
	private static char [][] solutionToMaze (char [][] maze, Point [] path) {

		char [] solution = pathDirectionsChar(path);
		char [][] solutionMaze = new char [maze.length][maze[0].length];

		if (path != null) {
			for (int loc = 0; loc < path.length; loc += 1) {
				solutionMaze[path[loc].getX()][path[loc].getY()] = solution[loc];
			}
		}
		return solutionMaze;
	}

	// METHOD
	// Generate a random number
	public static int randomNumber (int min, int max) {
		return (int)(Math.random() * (max - min)) + min;
	}

	// METHOD
	// Provides an empty maze
	public static char [][] emptyMaze (int l, int w, int sX, int sY, int fX, int fY) {
		char [][] maze = new char [l][w];

		for (int i = 0; i < l; i += 1) {
			for (int j = 0; j < w; j += 1) {
				maze[i][j] = EMPTY;
				if (i == 0 || i == maze.length - 1) { maze[i][j] = WALL; }
				if (j == 0 || j == maze[i].length - 1) { maze[i][j] = WALL; }
			}
		}

		boolean valid = true;
		if (sX <= 0 || sX >= w - 1) { valid = false; }	// sX invalid
		if (sY <= 0 || sY >= l - 1) { valid = false; }	// sY invalid
		if (fX <= 0 || fX >= w - 1) { valid = false; }	// fX invalid
		if (fY <= 0 || fY >= l - 1) { valid = false; }	// fY invalid
		if (sX == fX && sY == fY) { valid = false; }	// S and F must be different

		if (!valid) {
			return null;
		}

		maze[sY][sX] = START;
		maze[fY][fX] = FINISH;

		return maze;

	}

	// METHOD
	// Provides an empty maze
	public static char [][] emptyMaze () {
		return emptyMaze (10, 10, 1, 1, 8, 8);
	}

	// METHOD
	// Builds a random maze based on the probability and maze provided
	private static char [][] buildMaze (double prob, char [][] premadeMaze) {
		char [][] maze = copyMaze(premadeMaze);
		//int count = 0;
		for (int i = 1; i < maze.length - 1; i += 1) {
			for (int j = 1; j < maze[i].length - 1; j += 1) {
				if (Math.random() < prob && maze[i][j] != START && maze[i][j] != FINISH) {
					maze[i][j] = WALL;
					//count += 1;
				}
			}
		}
		//System.out.println(count + "/" + maze.length * maze[0].length + " ");

		return maze;
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze (double prob, int min, int max, boolean randomStartFinish) {
		char [][] maze;
		int l = randomNumber(min, max);
		int w = randomNumber(min, max);
		int sX, sY, fX, fY;
		if (randomStartFinish) {
			do {
				sX = randomNumber(2, w - 1);
				sY = randomNumber(2, l - 1);
				fX = randomNumber(2, w - 1);
				fY = randomNumber(2, l - 1);
			} while (sX == fX && sY == fY);
		}
		else {
			sX = 1;
			sY = 1;
			fX = w - 2;
			fY = l - 2;
		}

		maze = emptyMaze(l, w, sX, sY, fX, fY);

		return buildMaze (prob, maze);
	}

	// METHOD
	// Generates a random maze on top of another maze
	public static char [][] randomMaze (double prob, char [][] maze) {
		return buildMaze(prob, maze);
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze (double prob, int min, int max) {
		return randomMaze(prob, min, max, true);
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze (int min, int max) {
		return randomMaze(0.4, min, max, true);
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze (double prob, boolean randomStartFinish) {
		return randomMaze(prob, 5, 30, randomStartFinish);
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze (double prob) {
		return randomMaze(prob, 5, 30, true);
	}

	// METHOD
	// Generates a random maze
	public static char [][] randomMaze () {
		return randomMaze(0.4, 5, 30, true);
	}

	// METHOD
	// Determines how much of the maze is open for a rectangular maze
	public static float openRectangle (char [][] maze) {
		float totalSpace = (maze.length - 2) * (maze[0].length - 2);
		if (totalSpace == 0) { return 0; }
		return mazeSpace(maze) / totalSpace;
	}

	// METHOD
	// Copy a maze
	public static char [][] copyMaze (char [][] source) {
		char [][] maze = new char [source.length][source[0].length];
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[i].length; ++j) {
				maze[i][j] = source[i][j];
			}
		}
		return maze;
	}

	// METHOD
	// Provide a method for user input
	public static char [][] createCustom () {
		Scanner input = new Scanner(System.in);
		System.out.print("Length (vertical): ");
		int length = input.nextInt();
		System.out.print("Width (across): ");
		int width = input.nextInt();
		System.out.print("Start X: ");
		int sX = input.nextInt();
		System.out.print("Start Y: ");
		int sY = input.nextInt();
		System.out.print("Finish X: ");
		int fX = input.nextInt();
		System.out.print("Finish Y: ");
		int fY = input.nextInt();
		input.close();

		return emptyMaze(length, width, sX, sY, fX, fY);
	}

	// METHOD
	// Provides info on the maze components
	public static String info () {
		String information = "";

		information += "=== MAZE CREATION ===\n";
		information += WALL + " - Wall, " + START + " - Start, " + FINISH + " - Finish\n\n";
		information += "=== FUNCTIONALITY ===\n";
		information += "All listed methods are static\n";
		information += "String        layout(Point [] path, char [][] maze)\n";
		information += "String        layout(char [][] maze)\n";
		information += "boolean       isPossibleRecr(char [][] maze)\n";
		information += "boolean       isPossibleIter(char [][] maze)\n";
		information += "Point []      getDepthPath(char [][] maze)\n";
		information += "Point []      getBreadthPath(char [][] maze)\n";
		information += "String        pathList(Point [] path)\n";
		information += "int           pathLength(Point [] path)\n";
		information += "String        pathDirections(Point [] path)\n";
		information += "int           randomNumber(int min, int max)\n";
		information += "char [][]     emptyMaze(int l, int w, int sX, int sY, int fX, int fY)\n";
		information += "char [][]     emptyMaze()\n";
		information += "char [][]     randomMaze(double prob, int min, int max, boolean randomStartFinish)\n";
		information += "char [][]     randomMaze(double prob, int min, int max)\n";
		information += "char [][]     randomMaze(int min, int max)\n";
		information += "char [][]     randomMaze(double prob, boolean randomStartFinish)\n";
		information += "char [][]     randomMaze(double prob)\n";
		information += "char [][]     randomMaze()\n";
		information += "float         openRectangle(char [][] maze)\n";
		information += "char [][]     copyMaze(char [][] source)\n";
		information += "char [][]     createCustom()\n";
		information += "String        info()";

		return information;

	}

}
