
package com.zhu.snake;

import javax.swing.JOptionPane;
/**
 * �߳��࣬ʵ�����ƶ����Ե���������Ϸ�����»�ͼ
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
			JOptionPane.showMessageDialog(null, "����");
			System.exit(0);
		}
	}
}
