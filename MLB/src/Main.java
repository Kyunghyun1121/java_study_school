
public class Main{
	public static void main(String[] args){
		Team myTeam = new Team(20);  // 최대 20명
		myTeam.add(new Player("홍길동", 25, 0.25));
		myTeam.add(new Player("조길동", 35, 0.2));
		myTeam.add(new Player("정길동", 22, 0.33));
		myTeam.add(new Player("박길동", 27, 0.30));
		myTeam.add(new Player("김길동", 24, 0.35));
		
		System.out.println("이름이 가장 빠른 사람:" 
		    + myTeam.getBest(new NameComparer()));
        System.out.println("나이가 가장 많은 사람:" 
		    + myTeam.getBest(new AgeComparer()));
		System.out.println("타율이 가장 높은 사람:" 
		    + myTeam.getBest(new AverageComparer()));
		System.out.println("타율이 가장 낮은 사람:" 
		    + myTeam.getBest(new ReverseAverageComparer()));
	}
}
