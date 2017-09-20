package score;

public class Node {
	public int sn, eng, math, ave;
	public Node link;
	
	public Node(int studentNumber, int english, int math) {
		this.sn = studentNumber;
		this.eng = english;
		this.math = math;
		this.ave = (int)((math + english) / 2);
		this.link = null;
	}
	
	public Node getLink() {
		return this.link;
	}
	
	public void setLink(Node link) {
		this.link = link;
	}
	
	public int getSn() {
		return this.sn;
	}
	
	public int getEn() {
		return this.eng;
	}
	
	public int getMath() {
		return this.math;
	}
	
	public int getAve() {
		return this.ave;
	}
	
	public int[] getData() {
		return new int[] {this.sn, this.eng, this.math, this.ave};
	}
	
	@Override
	public String toString() {
		return String.format("%d\t%d\t%d\t%d", sn, eng, math, ave);
	}

}
