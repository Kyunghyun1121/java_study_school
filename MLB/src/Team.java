
public class Team{
	private Player mlb[];
	private int num = 0;
	
	public Team(int n) {
		mlb = new Player[n];
	}
	public void add(Player p) {
		mlb[num++] = p;
	}

	public String getBest(Comparer c) {
		Player p = mlb[0];
		for (int a = 1; a < num; a++) {
			if (c.find(p, mlb[a])) {
				p = mlb[a];
			}
		}
		return p.getname();
	}

}
