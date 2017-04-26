package man60s;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SbDemo extends JPanel implements MouseMotionListener {
	public static final int width = 700;
	public static final int height = 700;
	// 游戏状态
	public static boolean state = false;
	public int score = 0;
	ArrayList<Figure> list = new ArrayList<Figure>();
	int x,y;
	static int radii = (int) (Math.random() * 10+ 10);
	static long endtTime=System.currentTimeMillis();
	static long time=0;
	Figure F1=new Figure();
	public static void main(String[] args) {
		JFrame frame = new JFrame("~~~");
		SbDemo cb = new SbDemo();
		frame.getContentPane().add(cb);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		cb.action();
	}
	
	public SbDemo(){
		addMouseMotionListener(this);
	}
	
	public void action() {
		get();
	}

	public boolean over() {
		// TODO Auto-generated method stub
		for (Figure ff : list) {
			if(ff==null) {continue;}
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
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		long startTime=System.currentTimeMillis();
		time=(startTime-endtTime)/1000;
		String time1 = "时间："+time;
//		String time2 ="速度："+intevalPeriod+"毫秒/次";
		String time3 ="个数："+list.size();
		g.setColor(Color.red);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString(time1, 580, 30);
//		g.drawString(time2, 580, 50);
		g.drawString(time3, 580, 70);
		g.setColor(Color.black);
		for (Figure ff : list) {
			if(ff==null){continue;}
			g.fillOval(ff.x, ff.y, ff.radii, ff.radii);
		}
		g.drawRect(30, 30, 540, 600);
		g.setColor(Color.blue);
		g.fillOval(F1.x, F1.y,F1.radii, F1.radii);
		if(state) {
			String s = "游戏结束！";
			g.setColor(Color.red);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
			g.drawString(s, 70, 300);
		}
	}

	public void move() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).x > 540 + list.get(i).radii || list.get(i).x < 30
					|| list.get(i).y < 30
					|| list.get(i).y > 600 + list.get(i).radii) {
				list.remove(i);
			}
		}
	}

	public void get() {
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 50;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// task to run goes here
				move();
				state=over();
//				System.out.println("~~~~");
				if(state){
					timer.cancel();}
				Figure f = new Figure();
				int x = (int) (Math.random() * 540 + 1);
				int y = (int) (Math.random() * 600 + 1);
				int radii = (int) (Math.random() * 10 + 5);
				f.x = x;
				f.y = y;
				f.radii = radii;
				int flag = (int) (Math.random()*8 + 1);
				f.flag = flag;
				System.out.println(flag);
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
			}
		};
		
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getX()+","+e.getY());
//		repaint();
		if(state){
			return;}
		x=e.getX()-radii/2;
		y=e.getY()-radii/2;
		if(x<540+radii&&x>30&&y<600+radii&&y>30){
		F1.x=x;
		F1.y=y;
		F1.radii=radii;
		repaint();}
	}
}
