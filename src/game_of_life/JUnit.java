package game_of_life;

import static org.junit.Assert.*;
import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class JUnit {
   public static boolean[][] table = new boolean[100][100];
   public static Game_Map map=new Game_Map(table);
   public static Game_Cell cell=new Game_Cell();
   public static Game_GUI gol=new Game_GUI(cell,map);
  
	@Before
	public void setUp() throws Exception {
		gol.init();//每次测试开始之前恢复初始值   
		cell.InitMap();
	}
	
	 @Test  
	 public void testInit() {   
	    	assertTrue("false!",null!=gol.animator);
	    	//条件为真不提示 message,条件为假时才提 示。   
	    	assertTrue("false!",100==gol.delay);   
	    	assertTrue("false!",false==gol.running);   
	    	assertNotNull(gol.animator);   
	    	}   
	 
	@Test  
	public void testInitMap()   {   
		for(int x=0;x<gol.SIZE;x++)      { 
		   
	      for(int y=0;y<gol.SIZE;y++)       {       
	    	  assertEquals("false!",false,cell.table[x][y]);        
	    	  assertEquals("false!",0,cell.neighbors[x][y]);       
	    	  }      
	      }  
		}
	
	@Test  
	public void testRun() {  
   //如果 gol.run()函数不成功则 animator 为 null。如果不抛出异常，则 e 为空。   
		try {        
			gol.run();        
			assertTrue("false!",null!=gol.animator);           
			} catch (Exception e) {          
				assertNull(e);//如果对象为空，则测试通过         
				}                         
		} 
     
    @Test  
    public void testGetNeighbors() {   
    	cell.table[0][0]=true;   
    	cell.table[0][1]=true;   
    	cell.table[1][0]=true;   
    	cell.table[0][2]=true;   
    	cell.table[2][2]=true;   
    	cell.table[2][1]=true;   
    	cell.getNeighbors();   
    	final int[][] MyNeighbors = new int[gol.SIZE][gol.SIZE];   
    	/* 根据自己设置的处置，给出 MyNeighbors[][]预期的内容   */   
    	MyNeighbors[0][0]=2;MyNeighbors[0][1]=3;   
    	MyNeighbors[0][2]=1;MyNeighbors[0][3]=1;   
    	MyNeighbors[1][0]=3;MyNeighbors[1][1]=6;   
    	MyNeighbors[1][2]=4;MyNeighbors[1][3]=2;  
    	MyNeighbors[2][0]=2;MyNeighbors[2][1]=2;   
    	MyNeighbors[2][2]=1;MyNeighbors[2][3]=1;   
    	MyNeighbors[3][0]=1;MyNeighbors[3][1]=2;   
    	MyNeighbors[3][2]=2;MyNeighbors[3][3]=1;   
    	assertEquals("false!",MyNeighbors,cell.neighbors);  
    	} 
    @Test  
    public void testNextWorld() { 
    	   
    	  cell.table[0][0]=true;  cell.table[0][2]=true;   
    	  cell.table[1][0]=true;  cell.table[1][1]=true;   
    	  cell.table[2][0]=true;  cell.table[2][2]=true;   
    	  cell.neighbors[0][0]=2; cell.neighbors[0][1]=4;   
    	  cell.neighbors[0][2]=1; cell.neighbors[0][3]=1;   
    	  cell.neighbors[1][0]=3; cell.neighbors[1][1]=5;   
    	  cell.neighbors[1][2]=3; cell.neighbors[1][3]=2;   
    	  cell.neighbors[2][0]=2; cell.neighbors[2][1]=4;   
    	  cell.neighbors[2][2]=1; cell.neighbors[2][3]=1;   
    	  cell.neighbors[3][0]=1; cell.neighbors[3][1]=2;   
    	  cell.neighbors[3][2]=1; cell.neighbors[3][3]=1;   
    	  final boolean[][] MyTable = new boolean[gol.SIZE][gol.SIZE];   
    	  /* 根据自己给出 MyNeighbors[][]的内容，给出 MyTable[][]预期的内容    */   
    	  MyTable[0][0]=true;   MyTable[1][0]=true;   
    	  MyTable[2][0]=true;   MyTable[1][2]=true;   
    	  cell.nextWorld();   assertEquals("false!",MyTable,cell.table);  
    	  } 
   
}
