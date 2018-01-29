package com.zhu.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * ���࣬�����ߵ��ƶ����Ե������ߣ��ж���Ϸ�Ƿ����
 * @author Administrator
 *
 */

public class Snake {
	private int row;
	private int col;
	
	private Node head;//ͷ�ڵ�
	private Node tail;//β�ڵ�
	private Node node;
	
	private static Egg egg = new Egg();//��
	
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
	 * ���ߵ�ͷ�����һ��һ���ڵ�
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
	 * ɾ���ߵ�β���ڵ�
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
	 * ģ���ߵ��ƶ���ͨ�����ͷ���ڵ㣬ͬʱɾ��β���ڵ�ķ�ʽ��ʵ���ߵ��ƶ�
	 */
	public void move() {
		addHead();
		deleteTail();
	}
	
	/**
	 * �߳Ե���ͷ���ڵ�͵��Ľڵ�������ͬʱ���Ե�����ͷ������һ���ڵ�ʵ���ߵ�������
	 */
	public void eatEgg() {
		if(egg.getRow() == head.row && egg.getCol() == head.col) {
			addHead();
			egg = null;
		}
	}
	
	/**
	 * �ж��ߵ�ͷ���Ƿ�ײǽ���Ƿ�Ӵ��Լ�������
	 * @param head �ߵ�ͷ���ڵ�
	 * @return ײǽ���߽Ӵ����巵��false��û�з���true
	 */
	public boolean isGameOver(Node head) {
		if(head.row < 0 || head.col < 0) {
			System.out.println("����");
			return false;
		}else{
			for(Node node = head.next; node!=null; node =node.next) {
				if(this.head.row == node.row && this.head.col == node.col) {
					System.out.println("����");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * �������߻��������γɵ��߿��Կ�����һ��˫������һ����һ���������������Ϳ�����
	 * @param g ����
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
