package com.zhu.snake;

import java.awt.Color;
import java.awt.Graphics;
/**
 * 节点类，模拟双向链表
 * @author GG bone
 *
 */
public class Node {
	public int row;
	public int col;
	
	public Node next;//指向后一个节点
	public Node pre;//指向前一个节点
	public Direct dir;//节点的方向
	
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
	 * 画出一个节点
	 * @param g 画笔
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(row*15, col*15+20, LENTH, LENTH);
	}
}
