package com.zhu.snake;

import javax.swing.JOptionPane;
/**
 * 线程类，实现舍移动，吃蛋，结束游戏，重新绘图
 * @author GG bone
 *
 */
public class Paint implements Runnable{
	private Snake snake;
	private SFrame sf;
	public Paint(Snake snake,SFrame sf) {
		this.snake = snake;
		this.sf = sf;
	}
	@Override
	public void run() {
		if(snake.isGameOver(snake.getHead())) {
			snake.move();
			snake.eatEgg();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sf.repaint();
		}else{
			JOptionPane.showMessageDialog(null, "死亡");
			System.exit(0);
		}
	}
}
