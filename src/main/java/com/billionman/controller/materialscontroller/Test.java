/**
 * 
 */
package com.billionman.controller.materialscontroller;

/**
 * @author CTM
 *
 */

public class Test  {
static int xc;

public static void main(String[] args) 
{ 
    Test1 t1 = new Test1("ok");
    Test1 t2 = passValue(t1);
    System.out.println(t1.name);
} 
static Test1 passValue(Test1 nam) {
	nam = new Test1("AK");
//	nam.name = "asd";
	return null;
	
}
}
