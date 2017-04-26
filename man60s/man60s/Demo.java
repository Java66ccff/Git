package man60s;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo extends JPanel implements KeyListener {
	public static final int width = 700;
	public static final int height = 700;
	// ÓÎÏ·×´Ì¬
	public static boolean state = false;
	public int score = 0;
	ArrayList<Figure> list = new ArrayList<Figure>();
	Figure F1 = new Figure();
	static int radii = (int) (Math.random() * 20 + 10);
	static int x = (int) (Math.random() * 540 + 1)-radii/2;
	static int y = (int) (Math.random() * 600 + 1)-radii/2;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("~~~");
		Demo cb = new Demo();
		frame.add(cb);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		frame.addKeyListener(cb);
		cb.F1.x = x;
		cb.F1.y = y;
		cb.F1.radii = radii;
		cb.action();
		System.out.println("~~~~");
	}

	public void action() {
		get();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Figure ff : list) {
			g.fillOval(ff.x, ff.y, ff.radii, ff.radii);
		}
		g.drawRect(30, 30, 540, 600);
		g.setColor(Color.blue);
		g.fillOval(F1.x, F1.y, F1.radii, F1.radii);
		
		if(state) {
			String s = "ÓÎÏ·½áÊø£¡";
			g.setColor(Color.red);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
			g.drawString(s, 70, 300);
		}
	}
	
	public boolean over() {
		// TODO Auto-generated method stub
		for (Figure ff : list) {
			double numx,numy,num,sum;
			numx=Math.pow(Math.abs(ff.x-F1.x), 2);
			numy=Math.pow(Math.abs(ff.y-F1.y),2);
			num=Math.sqrt(numx+numy);
			sum=Math.abs(ff.radii-F1.radii);
//			System.out.println("num"+num+"sum"+sum);
			if(num<=sum) {
				return true;
			}
		}
		return false;
	}

	public void move(){
		for(int i=0;i<list.size();i++){
			if(list.get(i).x>540+list.get(i).radii||
					list.get(i).x<30||
					list.get(i).y<30||
					list.get(i).y>600+list.get(i).radii){
				list.remove(i);
			}
		}
	}

	public void get() {
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 1 * 100;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// task to run goes here
				move();
				state=over();
				if(state){
					timer.cancel();}
				Figure f = new Figure();
				int x = (int) (Math.random() * 540 + 1);
				int y = (int) (Math.random() * 600 + 1);
				int radii = (int) (Math.random() * 10 + 5);
				f.x = x;
				f.y = y;
				f.radii = radii;
				int flag = (int) (Math.random() * 8 + 1);
				f.flag = flag;
				list.add(f);
				for (Figure ff : list) {
					switch (ff.flag) {
					case 1:
						ff.x += ff.radii;
						break;
					case 2:
						ff.x -= ff.radii;
						break;
					case 3:
						ff.y += ff.radii;
						break;
					case 4:
						ff.y -= ff.radii;
						break;
					case 5:
						ff.x += ff.radii;
						ff.y += ff.radii;
						break;
					case 6:
						ff.x -= ff.radii;
						ff.y += ff.radii;
						break;
					case 7:
						ff.x += ff.radii;
						ff.y -= ff.radii;
						break;
					case 8:
						ff.x -= ff.radii;
						ff.y -= ff.radii;
						break;
					default:
						break;
					}
				}
				repaint();
				// System.out.println("Hello !!!");
			}
		};
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(state){return;}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			F1.y = F1.y + F1.radii;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			F1.y -= F1.radii;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			F1.x = F1.x + F1.radii;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			F1.x -= F1.radii;
		} else {

		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println(e.getKeyCode());
	}

}
