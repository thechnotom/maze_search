/*
Developer: Thomas Roller
File:      MazeInst.java
Class:     MazeInst
Java:      SE8
*/

class MazeInst {

  private char [][] maze;
  private Point [] depthSolution;
  private Point [] breadthSolution;

  public MazeInst () {
    // default constructor
  }

  public MazeInst (char [][] maze) {
    setMaze(maze);
  }

  public MazeInst (String [] maze) {
    setMaze(maze);
  }

  public char [][] getCharMaze ()   { return this.maze; }
  public String [] getStringMaze () { return Maze.convert(this.maze); }
  public Point []  getSolution (boolean isBreadth) {
    if (isBreadth) { return this.breadthSolution; }
    return this.depthSolution;
  }

  public void setMaze (char [][] maze) {
    this.maze = maze;
    depthSolution = Maze.getDepthPath(this.maze);
    breadthSolution = Maze.getBreadthPath(this.maze);
  }

  public void setMaze (String [] maze) {
    setMaze(Maze.convert(maze));
  }

  public String layout () {
    return Maze.layout(this.maze);
  }

  public String layoutSolution (boolean isBreadth) {
    if (isBreadth) { return Maze.layout(this.breadthSolution, this.maze); }
    return Maze.layout(this.depthSolution, this.maze);
  }

  public String layoutSolution () {
    return layoutSolution (true);
  }

  public boolean isPossible (boolean iterative) {
    if (iterative) { return Maze.isPossibleIter(this.maze); }
    return Maze.isPossibleRecr(this.maze);
  }

  public boolean isPossible () {
    return isPossible (true);
  }

  public String pathList (boolean isBreadth) {
    if (isBreadth) { return Maze.pathList(this.breadthSolution); }
    return Maze.pathList(this.depthSolution);
  }

  public String pathList () {
    return pathList(true);
  }

  public int pathLength (boolean isBreadth) {
    if (isBreadth) { return Maze.pathLength(this.breadthSolution); }
    return Maze.pathLength(this.depthSolution);
  }

  public int pathLength () {
    return pathLength (true);
  }

  public float openRectangle () {
    return Maze.openRectangle(this.maze);
  }

  // Add static information method
}