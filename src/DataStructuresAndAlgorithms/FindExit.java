package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class FindExit {
    public static void main(String[] args) {
        int[][] maze = new int[10][10];
        for (int i = 0; i < maze.length; i++) {
            if(i < maze[i].length){
                maze[0][i] = 1;
            }
            if(i == maze.length-1){
                for (int j = 0; j < maze[i].length-1; j++) {
                    maze[i][j] = 1;
                }
            }
            if(i >= 1){
                maze[i][0] = 1;
                maze[i][maze[i].length-1] = 1;
            }
        }
        for (int[] ints : maze) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(setWay(maze,1,1));
    }

    public static boolean setWay(int[][] map, int i, int j){
        System.out.println("==============================");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("==============================");
        if(map[map.length-2][map[map.length-2].length-2] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i+1,j)){
                    return true;
                } else if (setWay(map,i,j+1)) {
                    return true;
                } else if (setWay(map,i-1,j)) {
                    return true;
                } else if (setWay(map,i,j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
