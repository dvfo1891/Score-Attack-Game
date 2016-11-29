import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends Frame {

	static final int WIDTH = 800;
	static final int HEIGHT = 500;
	Unit hero = new Unit(30,30,30,3, this, Unit.Direction.STOP);
	RedBallUnit redBallUnit1 = new RedBallUnit(100,100,30,2, this, Unit.Direction.RU);
	RedBallUnit redBallUnit2 = new RedBallUnit(500,500,30,2, this, Unit.Direction.D);
	List <Unit> units = new ArrayList<Unit>();
	
	public void paint(Graphics g) {
		hero.draw(g);
		redBallUnit1.draw(g);
		redBallUnit2.draw(g);
		for(int i=0; i<units.size(); i++){
			Unit unit = units.get(i);
			unit.draw(g);
		}
	}

	public void lauchFrame(){
		this.setTitle("嘿嘿嘿");
		this.setLocation(300,150);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		new Thread(new paintThread()).start();
	}
	
	public static void main(String[] args) {
		GameFrame g = new GameFrame();
		g.lauchFrame();
	}
	
	private class paintThread implements Runnable{
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
			hero.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			hero.keyPressed(e);
		}
	}
	
	
	
	
	
}
