package score;

public class LinkedList {
	private Node first;

	public LinkedList() {
		first = null;
	}
	
	public LinkedList(int sn, int eng, int math){
        first = new Node(sn, eng, math);
    }
	
	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}
	
	public Node search(int sn) {
		Node tmp = first;
		while (tmp != null) {
			if (tmp.getSn() == sn)
				return tmp;
			tmp = tmp.getLink();
		}
		return null;
	}
	
	public Node getNode(int index) {
		Node tmp = first;
		int i = 0;
		while (i < index && tmp != null) {
			tmp = tmp.getLink();
			i++;
		}
		return tmp;
	}
	
	public String getData(int index) {
		Node tmp = first;
		int i = 0;
		while (i < index && tmp != null) {
			tmp = tmp.getLink();
			i++;
		}
		if (tmp != null)
			return tmp.toString();
		return null;
	}
	
	public void insertAtFront(int sn, int eng, int math) {
		Node newNode = new Node(sn, eng, math);
		newNode.setLink(this.first);
		this.first = newNode;
	}
	
	public void inserInOrdered(int sn , int eng, int math) {
		//Find right position to insert.
		Node tmp = first;
		Node prev = null;
		while (tmp != null) {
			if (sn < tmp.getSn())
				break;
			prev = tmp;
			tmp = tmp.getLink();
		}
		Node newNode = new Node(sn, eng, math);
		if (tmp == this.first) {
			newNode.setLink(this.first);
			this.first = newNode;
		}
		else if (tmp == null)
			prev.setLink(newNode);
		else {
			newNode.setLink(tmp);
			prev.setLink(newNode);
		}
	}
	
	public boolean delete(int sn) {
		Node tmp = this.first;
		Node prev = null;
		while (tmp != null) {
			if (tmp.getSn() == sn)
				break;
			prev = tmp;
			tmp = tmp.getLink();
		}
		
		if (tmp == null)
			return false;
		if (tmp == this.first) 
			this.first = tmp.getLink();
		else {
			prev.setLink(tmp.getLink());
		}
		return true;
	}
	
	

}
