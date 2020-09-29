package com.company;

class Node {

	public Node prev;
	public Node next;
	public Object data;

	public Node(Node prev, Node next, Object data) {
		this.prev = prev;
		this.next = next;
		this.data = data;
	}

}

public class LinkedList {

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		head = new Node(null, null, null);
		tail = new Node(null, null, null);
		clear();
	}

	private void setUp(Node prev, Node cur, Node next) {
		prev.next = cur;
		cur.prev = prev;
		cur.next = next;
		next.prev = cur;
	}

	public boolean add(Object item) {
		Node newNode = new Node(null, null, item);
		Node prev = tail.prev;

		setUp(prev, newNode, tail);
		++size;
		return true;
	}

	public void add(int index, Object item) {
		if (index < 0 || index > size) {
			System.out.println(index + " is out of bounds.");
		}

		Node prev = head;
		for (int i = 0; i < index; ++i) {
			prev = prev.next;
		}

		Node next = prev.next;
		Node newNode = new Node(null, null, item);
		setUp(prev, newNode, next);
		++size;
	}

	public void addFirst(Object item) {
		Node newNode = new Node(null, null, item);
		Node next = head.next;

		setUp(head, newNode, next);
		++size;
	}

	public void addLast(Object item) {
		add(item);
	}

	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	public boolean contains(Object item) {
		Node cur = head.next;
		while (cur != tail) {
			if (cur.data.equals(item)) {
				return true;
			} else {
				cur = cur.next;
			}
		}

		return false;
	}

	public Object get(int index) {
		if (index < 0 || index >= size) {
			System.out.println(index + " is out of bounds.");
		}

		Node prev = head;
		for (int i = 0; i < index; ++i) {
			prev = prev.next;
		}

		return prev.next.data;
	}

	public Object getFirst() {
		if (size <= 0) {
			System.out.println("size is 0!");
		}

		return head.next.data;
	}

	public Object getLast() {
		if (size <= 0) {
			System.out.println("size is 0!");
		}

		return tail.prev.data;
	}

	public int indexOf(Object item) {
		int i = 0;
		Node cur = head.next;
		while (cur != tail) {
			if (cur.data.equals(item)) {
				return i;
			} else {
				i++;
				cur = cur.next;
			}
		}

		return -1;
	}

	public int lastIndexOf(Object item) {
		int i = 0;
		Node cur = tail.prev;
		while (cur != head) {
			if (cur.data.equals(item)) {
				return size - 1 - i;
			} else {
				i++;
				cur = cur.prev;
			}
		}

		return -1;
	}

	public Object poll() {
		Object object = getFirst();
		Node next = head.next.next;

		head.next = next;
		next.prev = head;
		--size;

		return object;
	}

	public Object pollLast() {
		Object object = getLast();
		Node prev = tail.prev.prev;

		tail.prev = prev;
		prev.next = tail;
		--size;

		return object;
	}

	public Object remove(int index) {
		if (index < 0 || index >= size) {
			System.out.println(index + " is out of bounds.");
		}

		Node prev = head;
		for (int i = 0; i < index; ++i) {
			prev = prev.next;
		}

		Node cur = prev.next;
		Node next = cur.next;

		prev.next = next;
		next.prev = prev;
		--size;

		return cur.data;
	}

	public Object remove(Object obj) {
		Node prev = head;
		while (prev.next != tail) {
			Node cur = prev.next;
			if (cur.data.equals(obj)) {
				Node next = cur.next;
				prev.next = next;
				next.prev = prev;
				--size;

				return cur.data;
			} else {
				prev = cur;
			}
		}

		return null;
	}

	public Object set(int index, Object item) {
		if (index < 0 || index >= size) {
			System.out.println(index + " is out of bounds.");
		}

		Node prev = head;
		for (int i = 0; i < index; ++i) {
			prev = prev.next;
		}

		Node cur = prev.next;
		Object object = cur.data;

		cur.data = item;

		return object;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String result = "";
		Node cur = head.next;
		while (cur != tail) {
			result += cur.data.toString() + " ";
			cur = cur.next;
		}

		return result;
	}

}
