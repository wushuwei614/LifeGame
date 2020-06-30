package game_of_life;

public class Game_Cell  implements MyInterface{
	
	
	//当代的状况，格子中是否有生命
	   public static boolean[][] table = new boolean[SIZE][SIZE];
	    //格子的邻居数目
	   public static int[][] neighbors = new int[SIZE][SIZE];
	
	   public void getNeighbors() { 
	        for (int r = 0; r < SIZE; r++){//row行
	            for (int c = 0; c < SIZE; c++){//col列
	                if(r-1 >= 0 && c-1 >= 0   && table[r-1][c-1] )neighbors[r][c]++;
	                if(r-1 >= 0     && table[r-1][c])             neighbors[r][c]++;
	                if(r-1 >= 0 && c+1 < SIZE && table[r-1][c+1])neighbors[r][c]++;
	                if(c-1 >= 0   && table[r][c-1]) neighbors[r][c]++;
	                if(c+1 < SIZE && table[r][c+1]) neighbors[r][c]++;
	                if(r+1 < SIZE && table[r+1][c]) neighbors[r][c]++;
	                if(r+1 < SIZE && c+1 < SIZE && table[r+1][c+1])    neighbors[r][c]++;
	                if(r+1 < SIZE && c-1 >=0 && table[r+1][c-1])       neighbors[r][c]++;
	            }
	        }            
	    }
	    
	    /**
	     * nextWorld()，世代交替。
	     * 生命游戏的核心是计算出下一代的table，产生新一代的二维世界。
	     * 按照每一个neighbors元素
	     */
	    public void nextWorld() {
	        for (int r = 0; r < SIZE; r++){//row
	            for (int c = 0; c < SIZE; c++){//col
	                if (neighbors[r][c] == 3){
	                    table[r][c] = true;
	                }//if (neighbors[r][c] == 2) 不改变table[r][c]。
	                if (neighbors[r][c] < 2)
	                    table[r][c] = false; 
	                if (neighbors[r][c] >= 4)
	                    table[r][c] = false;                 
	                neighbors[r][c] = 0;                
	            }           
	        }
	    }
	    
	    public void SetTable(int x,int y)
		   {
			   table[x][y]=true; 
		   }
	    public void SetNeighbors(int x,int y,int num)
		   {
			  neighbors[x][y]=num; 
		   }
	    public void InitMap() 
	       {
	    	for(int x=0;x<SIZE;x++)
	    	{
	    		for(int y=0;y<SIZE;y++)
	    		{
	    			table[x][y]=false;
	    			neighbors[x][y] = 0;
	    		}
	    	}
	    	
	       }
}