class MazeInstTest {
  public static void main (String [] args) {

		String [] testMaze =      {"##################################################",
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

    MazeInst myMaze = new MazeInst(testMaze);

    System.out.println(myMaze.layoutSolution(true) + "\n");
    System.out.println("Breadth path length: " + myMaze.pathLength(true));

  }
}