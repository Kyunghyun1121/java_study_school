
public interface Comparer {
	public boolean find(Player one,Player two);
}
class NameComparer implements Comparer{
	//이름이 가장 빠른 사람
	public boolean find(Player one,Player two) {
		String temp = one.getname();
		if(temp.compareTo(two.getname())<0) {
			return false;
		}else {
			return true;
		}
	}

}
class AgeComparer implements Comparer{
	//나이가 가장 많은 사람
	public boolean find(Player one,Player two) {
		return one.getage() < two.getage();
	}
}
class AverageComparer implements Comparer{
	//타율이 가장 높은 사람
	public boolean find(Player one,Player two) {
		return one.getavr() < two.getavr();
	}
}
class ReverseAverageComparer implements Comparer{
	//타율이 가장 낮은 사람
	public boolean find(Player one,Player two) {
		return one.getavr() > two.getavr();
	}
}
