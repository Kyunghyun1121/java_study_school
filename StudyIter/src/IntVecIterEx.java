interface MyIterable{
	public boolean hasNext();
	public Integer next();
}

class IntVector{
	Integer[] ilist;
	int max;
	int line = 0;
	int cursor = 0;
	IntVector(int n){
		ilist = new Integer[n];
		max = 0;
		line = n;
	}
	void insert(Integer o){
		ilist[max++] = o;
	}
	void add(Integer o){
		ilist[max++] = o;
	}
	Integer get(int i){
		return ilist[i];
	}
	public Integer init() {
		return ilist[cursor];
	}
	public boolean hasNext() {
		if(ilist[cursor]==null) {
			return false;
		}else {
			return true;
		}
	}
	public Integer next() {
		return ilist[cursor++];
	}
}
public class IntVecIterEx{
	public static void main(String[] args){
		IntVector v = new IntVector(10);
		v.add(11);
		v.add(22);
		v.add(33);

		for (v.init() ; v.hasNext();  ){   // init 함수는 반복을 시작하도록 준비하는 함수.
			   System.out.println(v.next());
		}
	}
}
