package CSBS;

public class MazeClient {
    public static void main(String[] args) {
        String text = "##########\n" +
                "#        #\n" +
                "# ### ## #\n" +
                "# #    # #\n" +
                "# #  # # #\n" +
                "# ## #####\n" +
                "# #      #\n" +
                "# # #  # #\n" +
                "##### ####\n" +
                "#   #     \n" +
                "# #    # #\n" +
                "##########";
        Maze maze = new Maze(text);
        System.out.println(maze);
        maze.escapeMaze(maze, 6, 1);
    }
}
