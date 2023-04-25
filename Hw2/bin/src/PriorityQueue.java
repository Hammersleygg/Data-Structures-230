
public class PriorityQueue extends Queue
{
	
	public PriorityQueue()
	{
		super();
	}
	
	public void priorityEnqueue(Comparable<Object> item)
	//you need to implement
	{
		//if nothing in queue inserts item as the head
        if(this.head == null){
            this.head = new LinkedListNode(item);
            size++;
        //checks if item should come before head according to f-score, and if so makes it the new head
        }else if(item.compareTo(this.head.getData()) <= 0){
            LinkedListNode temp = new LinkedListNode(item);
            temp.setNext(this.head);
            this.head = temp;
            //size attribute from queue is incremented, or else the priorityQueue will show up as empty for isEmpty()
            size++;
        //now need to find where to insert the item based on the f score    
        }else{
            //loop through queue until item inserted in the proper place.
        	LinkedListNode temp2 = new LinkedListNode(item);
        	LinkedListNode temp = this.head;
        	while(temp != null && temp.getNext() != null && item.compareTo(temp.getData()) != -1) {
        		temp = temp.getNext();
        	}
        	temp2.setNext(temp.getNext());
        	temp.setNext(temp2);
        	size++;
        }
	} 
	

	public Comparable<Object> find(Comparable<Object> item)
	{
		// You need to implement this!
		LinkedListNode temp = this.head;
		while(temp != null) {
			BoardState board = (BoardState)temp.getData();
			if(board.equals((BoardState)item)) {
				return item;
			}
			temp = temp.getNext();
		}
		return null; 
	}
}
//priorityEnque going based off of numbers in compare to
