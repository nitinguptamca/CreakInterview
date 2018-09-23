package data.structure.concept;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo {
	private int maxCapcity;
	Map<Integer, Node> map = new HashMap<>();
	Node head, tail;

	public LRUCacheDemo(int maxCapcity) {
		this.maxCapcity = maxCapcity;
	}

	private class Node {
		int key, value;
		Node next, prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			next = prev = null;
		}
	}

	public static void main(String[] args) {
		LRUCacheDemo lrucache = new LRUCacheDemo(4);
		lrucache.set(1, 100);
		lrucache.set(10, 99);
		lrucache.set(15, 98);
		lrucache.set(10, 97);
		lrucache.set(12, 96);
		lrucache.set(18, 95);
		lrucache.set(1, 94);

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));

	}

	private int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			delete(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	private void set(int key, int value) {
		Node node = new Node(key, value);
		if (map.containsKey(node)) {
			Node old = map.get(key);
			old.value = node.value;
			delete(old);
			setHead(old);
		} else {

			if (map.size() >= maxCapcity) {

				map.remove(tail.key);
				// remove last node
				delete(tail);
				setHead(node);

			} else {
				setHead(node);
			}

			map.put(key, node);
		}

	}

	private void setHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;

		if (tail == null)
			tail = head;
	}

	private void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}

	}

}
