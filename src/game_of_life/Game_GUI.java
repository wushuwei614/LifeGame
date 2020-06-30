package game_of_life;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;



public class Game_GUI extends JFrame implements Runnable,MyInterface,MouseListener,MouseMotionListener,KeyListener{
	
    private  Game_Cell cells;
    Game_Map map;
	protected Thread animator;
	protected  int delay;//�ӳ� 
	protected  boolean running=true;//flag����ʶ�̵߳�����״��������������runningΪtrue�����û��жϣ�runningΪfalse��
	
	/*���캯��*/
	public Game_GUI(Game_Cell cells0,Game_Map map0) throws HeadlessException {
		this.cells=cells0;
		this.map=map0;
		setGUI();
		init();
	}
	public void init()  {
        animator = new Thread(this);
        animator.start();
        delay = 100;
        running = false;
        this.map.addMouseListener(this);
	    this.map.addMouseMotionListener(this);
	    this.map.addKeyListener(this);
	    
    }
	public void paint(Graphics g) {
        update(g);
    }

	 public void update(Graphics g) {
		 for (int x = 0; x < SIZE; x++)
		     for (int y = 0; y < SIZE; y++) {
		          g.setColor(this.cells.table[x][y]?cell:space);
		          g.fillRect(x * CELL_Size, y * CELL_Size, CELL_Size - 1, CELL_Size - 1);//�������
		            }
	    }
	 
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		 long tm = System.currentTimeMillis();
	        while (Thread.currentThread() == animator) {
	            if (running == true) {
	                this.cells.getNeighbors();
	                this.cells.nextWorld();
	                System.out.println("rungnig����");	     
	                this.map.repaint();
	            } 
	            try {
	                tm += delay;
	                Thread.sleep(Math.max(0, tm - System.currentTimeMillis()));
	            } catch (InterruptedException e) {
	                break;
	            }
	        } 
	    } // run

	
	/*GUI���*/
	public void setGUI()
	{   
		//���ô���
		this.map.setVisible(true);//�ɼ�
		//this.map.setBackground(new Color(199,237,204));
		this.map.setBounds(150, 150, 500,500);
		this.map.setResizable(false);//���ɵ��ڴ�С
		this.map.setLocationRelativeTo(null);//���ھ���
		this.map.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}			
		});
	}
	

	/*�ⲿ�¼�*/
	public void mouseClicked(MouseEvent e){ }   
    public void mousePressed(MouseEvent e){
    	 int cellX = e.getX()/CELL_Size;
	     int cellY = e.getY()/CELL_Size;
	     this.cells.table[cellX][cellY] =!e.isControlDown();
	     this.map.repaint();
	    
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseDragged(MouseEvent e){
        this.mousePressed(e); 
    }
    public void mouseMoved(MouseEvent e){}     
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){
    	 if(e.getKeyChar()==' '){
             running = !running;
             this.map.repaint();          
         }
    }
	
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        Game_Cell cells=new Game_Cell();
	    Game_Map map=new Game_Map(cells.table);
		Game_GUI game=new Game_GUI(cells,map);
    	}
}