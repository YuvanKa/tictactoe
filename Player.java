package tick_tac_toe;

public class Player {
	String Name;
	char Symbol;
	Player(){}
	Player(String name, char symbol){
		this.Name=name;
		this.Symbol=symbol;
	}
	
	public void getdetails() {
		System.out.println("name "+Name);
		System.out.println("symbol "+Symbol);
	}
	public String getName() {
		return Name;
	}
	public char getSymbol() {
		return Symbol;
	}
}
