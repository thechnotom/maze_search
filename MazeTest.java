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


		Maze maze = new Maze();

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

		System.out.println(maze.info() + "\n");
                /*
		Scanner input = new Scanner(System.in);
		System.out.print("Size: ");
		int max = input.nextInt();
		System.out.print("Minimum Path Length: ");
		int minPathLen = input.nextInt();
                */
		//int max = 50;
		char [][] randomMaze;
		int max = 100;
		int minPathLen = 0;
		int maxTests = 1000;
		//System.out.print("Maximum Tests: ");
		//int maxTests = input.nextInt();
		int count = 0;
		int maxLengthFound = 0;
		int pathLen;
		int numOfPossibleMazes = 0;
		char [][] premadeMaze = maze.emptyMaze(50, 25, 5, 5, 15, 45);
		//System.out.println(maze.layout(premadeMaze));
		while (true) {
			count += 1;
			System.out.print("Testing maze #" + count + "/" + maxTests + " (size: " + max + ")... ");
			//randomMaze = maze.randomMaze(0.4, max, max, false);
			randomMaze = maze.randomMaze(0.4, premadeMaze);
			System.out.print("generated... ");
			//randomMaze = maze.emptyMaze (15, 5, 1, 1, 2, 123);
			if (count >= maxTests) {
				System.out.println("Unable to find a possible maze; count: " + count + "\n");
				break;
			}
			System.out.print("testing possibility (" + numOfPossibleMazes + " successes)... ");
			Point [] path = maze.getBreadthPath(randomMaze);
			//if (maze.isPossibleIter(randomMaze)) {
			pathLen = 0;
			if (path != null) {
				System.out.print("passed... testing path length... ");
				numOfPossibleMazes += 1;
				pathLen = maze.pathLength(path);
				if (pathLen > maxLengthFound) {
					maxLengthFound = pathLen;
				}
				if (pathLen >= minPathLen) {
					System.out.print("passed ");
					System.out.println("[path length (cur/max/required): " + pathLen + "/" + maxLengthFound +"/" + minPathLen + "]");
					break;
				}
				//break;
			}
			System.out.print("failed ");
			System.out.println("[path length (cur/max/required): " + pathLen + "/" + maxLengthFound +"/" + minPathLen + "]");
		}
		System.out.println();
		Point [] breadthPath = maze.getBreadthPath(randomMaze);
		//System.out.println(maze.layout(randomMaze) + "\n");
		System.out.println(maze.layout(breadthPath, randomMaze) + "\n");
		//System.out.println("getBreadthPath(): " + maze.getBreadthPath(randomMaze));
		System.out.println("(via iter) The random maze (#" + count + ") is possible: " + maze.isPossibleIter(randomMaze));
		//System.out.println("(via recr) The random maze (#" + count + ") is possible: " + maze.isPossibleRecr(randomMaze));

		System.out.println("Breadth path length: " + maze.pathLength(breadthPath));
		//Point [] depthPath = maze.getDepthPath(randomMaze);
		//System.out.println("Depth path length: " + maze.pathLength(depthPath));

		//System.out.println(maze.layout(depthPath, randomMaze) + "\n");

	}
}
