
//List all the methods that we need
public interface BareBonesArrayList <E>{
	public void add(E a);				//Method adds to the end of list
	public void add(E a, int index);	//Method adds to specified index
	public E remove(int index);			//Method deletes element at index
	public E get(int index);			//Method returns element w/o deleting it
	public void set (E a, int index);	//Method updates the element
	public int getSize();				//Method tell us how many elements exist
	public int indexOf(E a);			//Method searches for element returns -1 if not found


}
