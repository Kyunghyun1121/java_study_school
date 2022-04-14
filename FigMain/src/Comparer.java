public interface Comparer {
	public boolean comp(Figure one,Figure two);
}
class WidthComparer implements Comparer{
	
	public boolean comp(Figure one,Figure two) {
		return one.getwidth() > two.getwidth();
	}

}
class AreaComparer implements Comparer{
	public boolean comp(Figure one,Figure two) {
		return one.getarea() > two.getarea();
	}
}