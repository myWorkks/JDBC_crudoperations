package com.marolix.oops;

class Parent {
	public void display(int i) {
		System.out.println(i);
	}

}

class Child extends Parent {
	public void display(String s) {
		System.out.println(s);
	}
}

public class OverloadingDemo {
	public void m1(Parent p) {
		System.out.println(p + "this is parent");
	}

	public void m1(Child c) {
		System.out.println(c.hashCode() + "this is child");
	}

	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		Parent p1 = new Child();
		OverloadingDemo o = new OverloadingDemo();
		o.m1(c);
		o.m1(p);
		o.m1(p1);
		//o.m1(null);
		o.m1(new Child());

	}

}
