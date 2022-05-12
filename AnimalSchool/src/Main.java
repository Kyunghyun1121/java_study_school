import java.util.ArrayList;

class Dog extends Pet{

	public Dog(String name) {
		super(name);
	}

	public String toString() {
		return "멍멍이 " + super.toString();
	}
}

class Cat extends Pet{

	public Cat(String name) {
		super(name);
	}

	public String toString() {
		return "야옹이 " + super.toString();
	}
}

class Pet {
	String name;

	public Pet(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}

class School <T extends Pet>{
	ArrayList<T> PetList = new ArrayList<>();

	public void add(T d) {
		PetList.add(d);
	}

	public void show() {
		for (T d : PetList) {
			System.out.println(d);
		}
	}
}

//T를 안하고 Pet으로 하면 dogschool에 dog도 들어가고 cat도 들어가기 때문에
//두가지를 구분해서 따로 따로 하기위해 T를 사용한다.
//T로만 하면 String같은 것도 들어가기 떄문에 T extends Pet을 한다.
//이게 lowerbound 인가봐영

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//School<String> stringschool = new School<>();
		School<Dog> dogschool = new School<>();
		School<Cat> catschool = new School<>();
		
		dogschool.add(new Dog("aaa"));
		dogschool.add(new Dog("bbb"));
		//dogschool.add(new Cat("bbb"));
		catschool.add(new Cat("ccc"));
		catschool.add(new Cat("ddd"));

		dogschool.show();
		catschool.show();
	}

}
