package finalProject;

public class LinesDemo {
	
	public String player;// if the player choosed this line  -- true
						// if the comp choosed this line  -- false
	
	public int serialNumber;
	
	public LinesDemo(String player, int serialNumber) {
		this.player= player;
		this.serialNumber= serialNumber;
		
	}
	public LinesDemo() {
		this.player= null;
		this.serialNumber= 0;
		
	}
	

}
