

public class MyMap <K,Y>{
	private K key[];
	private Y value[];
	int num = 0;

	public MyMap() {
		key = (K[])new Object[10000];
		value = (Y[])new Object[10000];
	}
	
	public void put(K i, Y string) {
		K tempi;
		int coun = 0;
		while (key[coun++] != null && coun < num) {
			tempi = key[num];
		}
		
		key[num] =  i;
		value[(Integer)key[num]] = string;
		num++;
	}

	public Y get(int k) {
		Y temp = null;
		for (int a = 0; a <= k; a++) {
			temp = value[a];
		}
		return temp;
	}

	public int size() {
		int coun = 0;
		while (value[(Integer)key[coun++]] != null && coun < num);
		return coun;
	}

}
