package com.zhu.snake;

import java.awt.Color;
import java.awt.Graphics;
/**
 * �ڵ��࣬ģ��˫������
 * @author GG bone
 *
 */
public class Node {
	public int row;
	public int col;
	
	public Node next;//ָ���һ���ڵ�
	public Node pre;//ָ��ǰһ���ڵ�
	public Direct dir;//�ڵ�ķ���
	
	private final int LENTH = 15;
	
	public Node() {
		super();
	}
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public Node(int row, int col,Direct dir) {
		super();
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	public Direct getDir() {
		return dir;
	}

	public void setDir(Direct dir) {
		this.dir = dir;
	}
	
	/**
	 * ����һ���ڵ�
	 * @param g ����
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(row*15, col*15+20, LENTH, LENTH);
	}
}
