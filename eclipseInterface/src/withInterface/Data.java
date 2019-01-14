package withInterface;

public class Data {

	public static String playerOneName;
	public static String playerTwoName;

	public Data(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}

	public static String getPlayerOneName(){
		return(playerOneName);
	}
	
	public String getPlayerTwoName(){
		return(playerTwoName);
	}
	
}