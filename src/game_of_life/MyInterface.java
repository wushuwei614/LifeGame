package game_of_life;

import java.awt.Color;

public interface MyInterface {
	   public final int SIZE = 100;//二维游戏世界的大小,共SIZE*SIZE个格子
	   public final int CELL_Size =10;//每个格式的边长，Java坐标系单位。
	  
	   public Color cell =new Color(32,98,40);
	   public Color space =new Color(226,245,226);    
	    //当代的状况，格子中是否有生命
	   //public static boolean[][] table = new boolean[SIZE][SIZE];
	    //格子的邻居数目
	  // public static int[][] neighbors = new int[SIZE][SIZE];
	   
	  

}