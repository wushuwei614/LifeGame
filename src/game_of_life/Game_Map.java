package game_of_life;


import java.awt.Graphics;
import javax.swing.JFrame;

public class Game_Map extends JFrame implements MyInterface{
	boolean[][] table0;
	public Game_Map(boolean[][]table) {
		 this.table0=table;
	 }
    public void paint(Graphics g) {
	 for (int x = 0; x < SIZE; x++)
	     for (int y = 0; y < SIZE; y++) {
	          g.setColor(this.table0[x][y]?cell:space);
	          g.fillRect(x * CELL_Size, y * CELL_Size, CELL_Size - 1, CELL_Size - 1);//»­³ö±í¸ñ
	            }
    }

}