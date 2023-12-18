//Josahandi Cisneros
//Feb 16, 2021
//ArrayListDriver.java
//CSC 311-01



//We create ArrayList Object and test methods
public class ArrayListDriver {

	public static void main(String[] args)
	{
		
		DHArrayList<Integer> list = new DHArrayList<>(1); //ArrayList is created

		list.add(10);
		System.out.println(list);		//the toString() method is called
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);
		list.add(40);
		System.out.println(list);
		list.add(50);
		System.out.println(list);
		list.add(null);
		System.out.println(list);
		list.add(100, 3);
		System.out.println(list);
		list.remove(15);
		System.out.println(list);
		Integer value = list.get(0);
		System.out.println("The value at location 0 is " + value);
		Integer valueb = list.indexOf(50);
		System.out.println("The index of 50 is " + valueb);
		
		
	}

}
