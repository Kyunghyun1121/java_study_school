
public class PositiveStack extends Stack{
	public void push(int n) {
		if(n>0) {
			super.push(n);
		}
	}
}
