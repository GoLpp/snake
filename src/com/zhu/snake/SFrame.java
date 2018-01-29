package com.zhu.snake;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
/**
 * 游戏主窗口，窗口的绘制
 * @author GG bone
 *
 */

public class SFrame extends JFrame{
	private static Snake snake = new Snake(6,8);
	private static SFrame sFrame = new SFrame();
	private BufferedImage image = new BufferedImage(600, 620, 1);//双缓冲

	/**
	 * 窗口的定制
	 */
	public SFrame() {
		setTitle("贪吃蛇");
		setSize(600,620);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**
		 *键盘监听事件，上下左右控制方向 
		 */
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch(key){
				case KeyEvent.VK_LEFT :
					if(snake.getHead().dir!=Direct.R){
						snake.getHead().setDir(Direct.L);
						sleep();
						repaint();
					}
					break;
				case KeyEvent.VK_UP :
					if(snake.getHead().dir != Direct.D){
						snake.getHead().setDir(Direct.U);
						sleep();
						repaint();
					}
					break;
				case KeyEvent.VK_RIGHT :
					if(snake.getHead().getDir() != Direct.L){
						snake.getHead().setDir(Direct.R);
						sleep();
						repaint();
					}
					break;
				case KeyEvent.VK_DOWN :
					if(snake.getHead().getDir() != Direct.U){
						snake.getHead().setDir(Direct.D);
						sleep();
						repaint();
					}
					break;
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics g2 = image.getGraphics();
		super.paint(g2);
		snake.draw(g2);
		
		Paint paint = new Paint(snake, sFrame);
		Thread thread = new Thread(paint);
		thread.start();
		g.drawImage(image, 0, 0, null);
	}
	
	public static void main(String[] args) {
		sFrame.setVisible(true);
	}
	
	public static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
