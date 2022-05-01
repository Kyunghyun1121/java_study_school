interface MyIterable{
	public boolean hasNext();
	public Integer next();
}

class IntVector{
	Integer[] ilist;
	int max;
	IntVector(){
		ilist = new Integer[100];
		max = 0;
	}
	void insert(Integer o){
		ilist[max++] = o;
	}
	Integer get(int i){
		return ilist[i];
	}
	// IntVector의 inner클래스로서 IntIterator를 정의해보라.
	public MyIterable getIterator() {
		return new IntIterator();
	}
	class IntIterator implements MyIterable{
		public int coun = 0;
		public boolean hasNext() {
			if(coun<max)return true;
			else return false;
		}
		public Integer next() {
			return ilist[coun++];
		}
	}

}
public class IntVecIterEx{
	public static void main(String[] args){
		IntVector v = new IntVector();
		v.insert(new Integer(11));
		v.insert(new Integer(22));
		v.insert(new Integer(33));
		MyIterable t = v.getIterator();
		while (t.hasNext()){
			System.out.println(t.next());
		}
	}
}
