import java.util.Arrays;

public class Figures{
	private Figure myf[];
	private int num = 0;
	public Figures(int n) {
		myf = new Figure[n];
	}
	public void add(Figure f) {
		myf[num++]=f;
	}
	public void listAll() {
		System.out.println("-----------------------");
		for(int a=0; a<num; a++) {
			myf[a].print();
		}
		System.out.println("-----------------------");
	}
	public void sort(Comparer c) {
		for(int a=0;a<num;a++) {
			for(int b =a+1;b<num;b++) {
				if(c.comp(myf[a], myf[b])) {
					Figure temp = myf[a];
					myf[a] = myf[b];
					myf[b] = temp;
				}
			}
		}
	}
	
}
