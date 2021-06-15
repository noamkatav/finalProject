package finalProject;

public class QubeSimpelation {
	
	public LinesDemo up;
	public LinesDemo down;
	public LinesDemo left;
	public LinesDemo right;
	public boolean needToBeDrown;
	public String whoGot;
	
	
	public QubeSimpelation(LinesDemo up,LinesDemo down,LinesDemo left,LinesDemo right)//constructor
	{
		this.up = up;
		this.down= down;
		this.left = left;
		this.right = right;
		this.needToBeDrown = false;
		this.whoGot = null;
		
	}
	public QubeSimpelation() { //constructor
		this.up = new LinesDemo();
		this.down = new LinesDemo();
		this.left = new LinesDemo();
		this.right = new LinesDemo();
		this.needToBeDrown = false;
		this.whoGot = null;
	}

}
