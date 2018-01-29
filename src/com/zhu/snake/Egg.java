package com.zhu.snake;

import java.awt.Graphics;

/**
 * ���࣬���ǰ���һ��������ɵ�Node�ڵ�
 * @author GG bone
 *
 */
public class Egg {
	private Node node;
	private int row;
	private int col;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Egg() {
		row = (int)(Math.random()*15);
		col = (int)(Math.random()*15);
		node = new Node(row,col);
	}
	
	public void draw(Graphics g) {
		node.draw(g);
	}
}
