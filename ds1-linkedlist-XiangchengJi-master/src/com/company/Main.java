package com.company;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.add("a");
		list.add("b");
		System.out.println(list); // a b

		list.add(0, "c");
		System.out.println(list); // c a b

		list.add(1, "d");
		System.out.println(list); // c d a b

		list.add(3, "e");
		System.out.println(list); // c d a e b 

		list.add(5, "f");
		System.out.println(list); // c d a e b f

		list.addFirst("k");
		System.out.println(list); // k c d a e b f

		list.addLast("z");
		System.out.println(list); // k c d a e b f z

		System.out.println(list.contains("k")); // true
		System.out.println(list.contains("b")); // true
		System.out.println(list.contains("z")); // true
		System.out.println(list.contains("h")); // false

		System.out.println(list.get(0)); // k
		System.out.println(list.get(1)); // c
		System.out.println(list.get(2)); // d
		System.out.println(list.get(3)); // a
		System.out.println(list.get(4)); // e
		System.out.println(list.get(7)); // z

		System.out.println(list.indexOf("h")); // -1
		System.out.println(list.indexOf("k")); // 0
		System.out.println(list.indexOf("b")); // 5
		System.out.println(list.indexOf("z")); // 7

		System.out.println(list.lastIndexOf("f")); // 6
		System.out.println(list.lastIndexOf("c")); // 1

		System.out.println(list.size()); // 8
		System.out.println(list.poll()); // k
		System.out.println(list.size()); // 7
		System.out.println(list.pollLast()); // z
		System.out.println(list.size()); // 6

		System.out.println(list); // c d a e b f

		System.out.println(list.remove(0)); // c
		System.out.println(list); // d a e b f
		System.out.println(list.remove(4)); // f
		System.out.println(list); // d a e b
		
		System.out.println(list.remove("e")); // e
		System.out.println(list); // d a b
		System.out.println(list.size()); // 3
		
		System.out.println(list.set(0, "h")); // d
		System.out.println(list); // h a b
		System.out.println(list.size()); // 3

		list.clear();
		System.out.println(list); //
	}
}
