package com.zhu.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 蛇类，包括蛇的移动，吃蛋，画蛇，判断游戏是否结束
 * @author Administrator
 *
 */

public class Snake {
	private int row;
	private int col;
	
	private Node head;//头节点
	private Node tail;//尾节点
	private Node node;
	
	private static Egg egg = new Egg();//蛋
	
	public Snake(int row, int col){
		node = new Node(row, col, Direct.D);
		this.row = row;
		this.col =col;
		head = node;
		tail = node;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	/**
	 * 向蛇的头部添加一个一个节点
	 */
	public void addHead() {
		Node node = null;
		switch(head.dir) {
			case U:
				node = new Node(head.row,head.col-1,head.dir);
				break;
			case D:
				node = new Node(head.row,head.col+1,head.dir);
				break;
			case L:
				node = new Node(head.row-1,head.col,head.dir);
				break;
			case R:
				node = new Node(head.row+1,head.col,head.dir);
				break;	
		}
		node.next = head;
		head.pre = node;
		head = node;
	}
	
	/**
	 * 删除蛇的尾部节点
	 */
	public void deleteTail() {
		/*Node node = new Node();
		node = tail.pre;
		node.next = null;
		tail = null;
		tail = node;*/
		Node node = tail.pre;
		tail = null;
		node.next = null;
		tail = node;
	}
	
	/**
	 * 模拟蛇的移动，通过添加头部节点，同时删除尾部节点的方式，实现蛇的移动
	 */
	public void move() {
		addHead();
		deleteTail();
	}
	
	/**
	 * 蛇吃蛋，头部节点和蛋的节点坐标相同时，吃蛋（向头部增加一个节点实现蛇的增长）
	 */
	public void eatEgg() {
		if(egg.getRow() == head.row && egg.getCol() == head.col) {
			addHead();
			egg = null;
		}
	}
	
	/**
	 * 判断蛇的头部是否撞墙，是否接触自己的身体
	 * @param head 蛇的头部节点
	 * @return 撞墙或者接触身体返回false，没有返回true
	 */
	public boolean isGameOver(Node head) {
		if(head.row < 0 || head.col < 0) {
			System.out.println("死亡");
			return false;
		}else{
			for(Node node = head.next; node!=null; node =node.next) {
				if(this.head.row == node.row && this.head.col == node.col) {
					System.out.println("死亡");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 将整个蛇画出来，形成的蛇可以看做是一个双向链表，一个接一个遍历，并画出就可以了
	 * @param g 画笔
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		if(egg == null) {
			egg = new Egg();
		}else{
			egg.draw(g);
		}
		for(int i=0; i<40; i++) {
			g.drawLine(0, 20 + 15*i, 600, 20 + 15*i);
		}
		for(int j=0; j<40; j++) {
			g.drawLine(0+j*15, 20, 0+j*15, 620);
		}
		if(head == null) {
			return ;
		}
		for(Node node=head; node!=null; node=node.next) {
			node.draw(g);
		}
	}
}
