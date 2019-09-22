# maze_search

Developer: Thomas Roller (thechnotom)
Purpose:   Side project
Language:  Java

=== Description ===

Solve, generate, and display mazes using static methods.

=== Files ===

Maze.java
MazeTest.java
Point.java

=== Methods ===

All listed methods are static

RETURN        METHOD

String        layout(Point [] path, char [][] maze)
String        layout(char [][] maze)
boolean       isPossibleRecr(char [][] maze)
boolean       isPossibleIter(char [][] maze)
Point []      getDepthPath(char [][] maze)
Point []      getBreadthPath(char [][] maze)
String        pathList(Point [] path)
int           pathLength(Point [] path)
String        pathDirections(Point [] path)
int           randomNumber(int min, int max)
char [][]     emptyMaze(int l, int w, int sX, int sY, int fX, int fY)
char [][]     emptyMaze()
char [][]     randomMaze(double prob, int min, int max, boolean randomStartFinish)
char [][]     randomMaze(double prob, int min, int max)
char [][]     randomMaze(int min, int max)
char [][]     randomMaze(double prob, boolean randomStartFinish)
char [][]     randomMaze(double prob)
char [][]     randomMaze()
float         openRectangle(char [][] maze)
char [][]     copyMaze(char [][] source)
String        info()