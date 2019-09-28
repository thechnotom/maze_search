/*
Developer: Thomas Roller
File:      MazeTest.java
Class:     MazeTest
Java:      SE8

Tests the Maze class
*/

import java.util.Scanner;

public class MazeTest {
	public static void main (String [] args) {

		String [] maze1 =      {"##########",
					"#S       #",
					"# #### ###",
					"#    #   #",
					"## # # # #",
					"#  # # # #",
					"# #### ###",
					"#   #   ##",
					"# #   # F#",
					"##########"};

		String [] maze2 =      {"##########",
					"#S       #",
					"##### ####",
					"#F       #",
					"##########"};

		String [] maze3 =      {"##########",
					"#S       #",
					"##### ####",
					"#        #",
					"# ##### ##",
					"#       F#",
					"##########"};

		String [] maze4 =      {"##################################################",
					"#S           #             #           #         #",
					"# ########## ########### ### ########### ####### #",
					"# #        #           # #    #  #   #   #       #",
					"# # ###### # ########### # #### ## # # ### #######",
					"# # #      #       #     #       # # # #         #",
					"# # ############## # ##### # ##### # # # ####### #",
					"#                # # #   # # #     # # #       # #",
					"### ############ # # # ### # # ##### # ###########",
					"#   #            # # #   # #   #   #             #",
					"# ### # ###### ### # ### # # ### ############### #",
					"#   # #    # # #     #     # #           # #     #",
					"### # #### # ######### ##### # # # ##### # ### ###",
					"#   # #  #             #     # # # #   # # # # # #",
					"# ### # ########## ##### ##### # # # ###   # # # #",
					"#     #  #         #   # #   # # # #   # # # #   #",
					"# ##### ## ########### # # # # # # ### # ##### # #",
					"#        # #         # # # # # # #             # #",
					"########## ## # ## # # ### # # # ############# # #",
					"#          #  # #  # # # # # # #             # # #",
					"# ########## ##### ### # # # # ### ######### # # #",
					"# #           #        # # # #   # #       # # # #",
					"# # ########### ###### # # # ### # # ########### #",
					"# # #         #      # #   #     # #             #",
					"# # # ######### ### ## ########### # # # ####### #",
					"# # # #       # #    #             # # # #       #",
					"### # # ##### # ########## ######### # # # #######",
					"#   # #     # #          #         # # # #       #",
					"# ### ####### ########## ########### # # ####### #",
					"#     #              # #             # # #       #",
					"############# ###### # ############### # # #######",
					"#   #     # #      #                   # #       #",
					"# # # # # # # ########################## ####### #",
					"# #   # #          #                           # #",
					"####### ########## ########################### ###",
					"#                #                           #   #",
					"######### ###### #################################",
					"#   #   # #    # #         #                     #",
					"# # # # # ## ### ##### # # # ### ############# ###",
					"# #   #   #  #       # # #   #   #           #   #",
					"# ####### ## ######### # # ##### # ### ### ##### #",
					"#       #              # # #     # #   # # #   # #",
					"# ##### ################ # # ##### # # # # # # # #",
					"# #     #                # #     # # # # # # # # #",
					"# # ##### # ########## ### ### ### # # # # # # # #",
					"# #     # # #          # # # # # # # # # #   # # #",
					"# # ######### ########## # # # # # # # # ##### # #",
					"# #         # #            # # # # # #       #   #",
					"# ######### ############## # # # # ######### #####",
					"#         #              # # #   #   #          F#",
					"##################################################"};

		String [] maze5 =      {"##########",
					"#        #",
					"#      S #",
					"#        #",
					"#        #",
					"#        #",
					"#    F   #",
					"#        #",
					"#        #",
					"##########"};

		String [] maze6 =      {"##########",
					"#S       #",
					"# ########",
					"#    #   #",
					"## # # # #",
					"#  # # # #",
					"#        #",
					"#   #   ##",
					"# #   # F#",
					"##########"};

		/*
		char [][] myMaze = maze.convert(maze1);
		System.out.println("=== BREADTH ===\n\n");
		System.out.println(maze.layout(myMaze) + "\n");
		System.out.println(maze.layout('B', myMaze) + "\n");
		System.out.println(maze.pathLength(maze.getBreadthPath(myMaze)) + "\n");
		System.out.println(maze.pathList(maze.getBreadthPath(myMaze)) + "\n");
		System.out.println(maze.pathDirections(maze.getBreadthPath(myMaze)) + "\n");

		System.out.println("\n\n\n");

		System.out.println("=== DEPTH ===\n\n");
		System.out.println(maze.layout('D', myMaze) + "\n");
		System.out.println(maze.pathLength(maze.getDepthPath(myMaze)) + "\n");
		System.out.println(maze.pathList(maze.getDepthPath(myMaze)) + "\n");
		System.out.println(maze.pathDirections(maze.getDepthPath(myMaze)) + "\n");

		System.out.println(maze.layout(maze.emptyMaze()) + "\n");
		*/

		/*
		for (int i = 0; i < 25; i += 1) {
			System.out.println(maze.randomNumber(5, 10));
		}
		*/

		System.out.println(Maze.info() + "\n");

		Scanner input = new Scanner(System.in);
		System.out.print("Minimum Path Length: ");
		int minPathLen = input.nextInt();

		/*

		//int max = 50;
		int max = 100;
		//System.out.print("Maximum Tests: ");
		//int maxTests = input.nextInt();
		char [][] premadeMaze = Maze.emptyMaze(50, 25, 5, 5, 15, 45);
		//randomMaze = Maze.randomMaze(0.4, premadeMaze);
		//System.out.println(Maze.layout(randomMaze));
		//System.out.println("\nOpen space: " + Maze.openRectangle(randomMaze) * 100 + "% open");
		//System.out.println(maze.layout(premadeMaze));
		*/

		char [][] premadeMaze = Maze.createCustom();
		if (premadeMaze == null) { System.out.println("Invalid S/F"); return; }
		int length = premadeMaze[0].length - 2;
		int width = premadeMaze.length - 2;

		int maxTests = 1000;
		int minPathLen = 0;
		char [][] randomMaze;
		int count = 0;
		int maxLengthFound = 0;
		int pathLen;
		int numOfPossibleMazes = 0;

		while (true) {
			count += 1;
			System.out.print("Testing maze #" + count + "/" + maxTests + " (size: " + length + "x" + width + ")... ");
			randomMaze = Maze.randomMaze(0.4, premadeMaze);
			System.out.print("generated ");
			System.out.print(String.format("(%.1f", Maze.openRectangle(randomMaze) * 100) +  "% open)... ");
			if (count >= maxTests) {
				System.out.println("Unable to find a possible maze; count: " + count + "\n");
				break;
			}
			System.out.print("testing possibility (" + numOfPossibleMazes + " successes)... ");
			Point [] path = Maze.getBreadthPath(randomMaze);
			pathLen = 0;
			if (path != null) {
				System.out.print("passed... testing path length... ");
				numOfPossibleMazes += 1;
				pathLen = Maze.pathLength(path);
				if (pathLen > maxLengthFound) {
					maxLengthFound = pathLen;
				}
				if (pathLen >= minPathLen) {
					System.out.print("passed ");
					System.out.println("[path length (cur/max/required): " + pathLen + "/" + maxLengthFound + "/" + minPathLen + "]");
					break;
				}
				//break;
			}
			System.out.print("failed ");
			System.out.println("[path length (cur/max/required): " + pathLen + "/" + maxLengthFound + "/" + minPathLen + "]");
		}
		
		System.out.println();
		Point [] breadthPath = Maze.getBreadthPath(randomMaze);
		//System.out.println(maze.layout(randomMaze) + "\n");
		System.out.println(Maze.layout(breadthPath, randomMaze) + "\n");
		//System.out.println("getBreadthPath(): " + maze.getBreadthPath(randomMaze));
		System.out.println("(via iter) The random maze (#" + count + ") is possible: " + Maze.isPossibleIter(randomMaze));
		//System.out.println("(via recr) The random maze (#" + count + ") is possible: " + maze.isPossibleRecr(randomMaze));

		System.out.println("Breadth path length: " + Maze.pathLength(breadthPath));
		//Point [] depthPath = maze.getDepthPath(randomMaze);
		//System.out.println("Depth path length: " + maze.pathLength(depthPath));

		//System.out.println(maze.layout(depthPath, randomMaze) + "\n");
    
	}
}
