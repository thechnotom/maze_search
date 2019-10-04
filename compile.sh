#!/bin/bash

echo "Compiling Point.java"
javac Point.java

echo "Compiling Maze.java"
javac Maze.java

echo "Compiling MazeTest.java"
javac MazeTest.java

if [ $# -eq 1 ]; then
  echo "Compiling MazeInst.java"
  javac MazeInst.java

  echo "Compiling MazeInstTest.java"
  javac MazeInstTest.java
fi