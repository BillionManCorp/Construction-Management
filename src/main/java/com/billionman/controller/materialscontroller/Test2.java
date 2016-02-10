package com.billionman.controller.materialscontroller;
public class Test2 implements Runnable
{
	Test3 t;
	

	@Override
	public void run() {
		int i = 0;
		while(true) {
			t.get();
		}

	}
}/* class Foo ends */