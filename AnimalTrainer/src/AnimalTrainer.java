interface TrainedAnimal{
	public void move();
}

class Kangaroo implements TrainedAnimal{
	@Override public void move() {
		jump();
	}
	public void jump() {
		System.out.println("Jump");
	}
}

class Fish implements TrainedAnimal{
	@Override public void move() {
		swim();
	}
	public void swim() {
		System.out.println("Swim");
	}
}

public class AnimalTrainer {
	void makeMove(TrainedAnimal k) {
		k.move();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalTrainer at = new AnimalTrainer();
		at.makeMove(new Kangaroo());
		at.makeMove(new Fish());
	}

}
