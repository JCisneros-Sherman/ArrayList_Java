


public class DHArrayList<E> implements BareBonesArrayList<E>{

//Data 
	private int size;			//How many elements exist				
	private int capacity;		//How big is the array
	private E[] myArray;		//Reference to actual array head  
	private static final int INITIAL_CAPACITY = 10;			//Default capacity

//Constructor	
	public DHArrayList() 
	{
		this.capacity = DHArrayList.INITIAL_CAPACITY;
		this.size = 0;									//No elements on list
		myArray =(E[]) new Object[this.capacity];		//Creates actual Array
	}

//Overloaded constructor with supplied capacity	
	public DHArrayList(int capacity) 
	{
		this.capacity = capacity;
		this.size = 0;
		myArray = (E[]) new Object[this.capacity];
	
	}
	
//Method adds element to the end of the list
	@Override
	public void add(E a)
	{
		if(this.size < this.capacity)		//Verifies if there is space to add element
		{
			myArray[size]=a;				//Add element
			size++;							//Update number of elements	
		}
		else 								//No space -> need to call reallocate()
		{
			System.out.println("There isn't space, calling rellocate");
			this.rellocate();				//Provides space
			this.add(a);					//adds element in need added space
		}
	}

//Method will double the size of array 
	private void rellocate()
	{
		this.capacity *= 2;
		E[] temp = (E[]) new Object[this.capacity];		//New array with double capacity created
		
		for(int i = 0; i< myArray.length; i++) 			//loop to make a copy of all elements
		{
			temp[i] = myArray[i];
		}
		this.myArray = temp;							//updates reference (points to new array). 
	}

//Method adds object at given index	
	@Override
	public void add(E a, int index)
	{
		if(index < 0 || index > size)			//check validity of index
		{	
			System.out.println("Invalid index!");
			return;
		}
		else if(index == size) 					//Adds at the end 
		{
			this.add(a);						//Use Add method
		}
		else 									//We have a valid index. Need to shift next
		{
			if(this.size == this.capacity) 		//checks is there is space for shift
			{
				this.rellocate();				//if array full, reallocates
			}
		}
		for(int i = size; i > index; i--) 		//we now start shifting elements 1 place to the right	
		{									
			this.myArray[i] = this.myArray[i-1];//Copies elements form last one to index
		}
		
		this.myArray[index]= a;					//once elements shifted , insert data
		this.size++;							//update number of elements in array
	}

//Methods deletes element at the given index
	@Override
	public E remove(int index)
	{
		if(index <0 || index>= size) 			//checks validity of index
		{
			System.out.println("Invalid Index");
			return null;
		}										//Now shifting may be required 
		E temp = myArray[index];				//save element so it can be returned
		for(int i = index; i < size -1; i++) 	//Shifting left
		{
			this.myArray[i] = this.myArray[i+1];
		}
		this.size--;							//Decrease # of elements in array
		return temp;							//Return the deleted element
	}
	
//Method return the element at index, but does not delete it	
	@Override
	public E  get(int index) 
	{
		if(index <0 || index>= size)       		//checks validity of index     
		{
			System.out.println("Invalid Index");
			return null;
		}
		return myArray[index];					//if index is valid, return element @ index	
	}

//Method will update element at given index
	@Override
	public void set(E a, int index) 
	{
		if(index <0 || index>= size)			//Checks validity of index
		{
			System.out.println("Invalid Index");
			return;
		}	
	
		myArray[index] = a;						//if index is valid, update the value
		return;
	}
		
//Method returns how many elements are there in the ArrayList
	@Override
	public int getSize()
	{
		
		return this.size;
	}
	
//Method Searches for searches for element and returns -1 if not found
	@Override
	public int indexOf(E a)
	{
		int index= -1;							//used to keep track of index #
		
		for (int i = 0; i < size; i++) 			//checks entire array to find matching element
		{  if(a == null)						//accounts if given value of a = null
			 index = i;							//returns index at which null is located
		else
            if(a.equals(myArray[i]))			//checks for a match of a with any element in myArray
                index = i;						//return index at which match was found
		}
		return index;							//if a not found -1 is returned
	}	
	
//Method converts the date in data structure into a string and returns it 
	public String toString()						//returns contents of array in a String
	{
		String s = " ";
		for(int i = 0; i < this.size; i++) 			//iteration over elements & add to the String
		{
			s = s + myArray[i]+ " , ";				//formatting " , "
			
		}
		return s;									//Returns the String
	}
	
	
	
}

