package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class mainGameScreen extends JFrame {
	public static boolean isTutorial = false;
	public static boolean watingForEnd = false;
	public static int tfi = -1;
	public static int tfj =-1;
	public static  int tli = -1;
	public static   int tlj = -1;
	public static Integer serial = 1;
	public Color colorForPlayer;
	public Color colorForAi;
	public static Boolean isPlayerNowPlaying = true;
	public  static QubeSimpelation[][] arr ;
	public static Score theScore = new Score();
	public int count =0;
	public int theDepth = 5;
	public int theLastScore  = 0;
	public static boolean isPlayerStarts;
	public static Integer counter =0;
	public static Color colorHelper;
	public static boolean needToDrawBox = false;
	public static int helpcount =1;
	public  Graphics g ;
	public static int testcount =0;
	public static Boolean cheacker = false;
	public static int paintCounter = 0;
	public static JPanel contentPane;
	public static boolean firsttime = true;
	public static ArrayList places = new ArrayList();
	public static Random rnd = new Random();
	public  Color colorForSquers;
	public Color colorForBackGround;
	public JMenuBar menuBar = new JMenuBar();
	public JMenu gameMenu = new JMenu("game");
	public static JMenuItem restart = new JMenuItem("restart");
	public static JMenuItem newGame = new JMenuItem("new game");
	public static JMenuItem exit = new JMenuItem("exit");
	
@Override 
public  void paint(Graphics g) {  //rewrite the paint method to fit the requairments of painting the board
	
	super.paint(g);
	
	firsttime = false;
	for(int i =0;i<4;i++) {
		for(int j=0;j<4;j++) {
			if(arr[i][j]!=null) {
			if(arr[i][j].up.player!=null) {
				if(arr[i][j].up.player.equals("computer")) {
					g.setColor(colorForAi);
				}
				else
				{
					g.setColor(colorForPlayer);
				}
				g.drawLine(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25, buttonsarr[i][j+1].getX()+15+5+2, buttonsarr[i][j+1].getY()+240+3+25);
			}
			
			if(arr[i][j].down.player!=null) {
				if(arr[i][j].down.player.equals("computer")) {
					g.setColor(colorForAi);
				}
				else
				{
					g.setColor(colorForPlayer);
				}
				g.drawLine(buttonsarr[i+1][j].getX() +15+5+2, buttonsarr[i+1][j].getY()+240+3+25, buttonsarr[i+1][j+1].getX()+15+5+2, buttonsarr[i+1][j+1].getY()+240+3+25);
				
			}
			if(arr[i][j].left.player!=null) {
				if(arr[i][j].left.player.equals("computer")) {
					g.setColor(colorForAi);
				}
				else
				{
					g.setColor(colorForPlayer);
				}
				g.drawLine(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25, buttonsarr[i+1][j].getX()+15+5+2, buttonsarr[i+1][j].getY()+240+3+25);
				
			}
			if(arr[i][j].right.player!=null) {
				if(arr[i][j].right.player.equals("computer")) {
					g.setColor(colorForAi);
				}
				else
				{
					g.setColor(colorForPlayer);
				}
				g.drawLine(buttonsarr[i][j+1].getX() +15+5+2, buttonsarr[i][j+1].getY()+240+3+25, buttonsarr[i+1][j+1].getX()+15+5+2, buttonsarr[i+1][j+1].getY()+240+3+25);
				
			}
		
		}
		}
	}
	for(int i=0;i<4;i++)
	{
		for(int j =0;j<4;j++)
		{
			if(arr[i][j].needToBeDrown)
			{
				if(arr[i][j].whoGot != null)
				{
					if(arr[i][j].whoGot.equals("player"))
					{
						g.setColor(this.colorForPlayer);
						g.fillRect(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25,133, 133);
						//arr[i][j].needToBeDrown = false;
						//arr[i][j].whoGot = null;
					}
					else
					{
						g.setColor(this.colorForAi);
						g.fillRect(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25,133, 133);
						//arr[i][j].needToBeDrown = false;
						//arr[i][j].whoGot = null;
					}
				}
			}
		}
	}
	
	
	this.mainpanel.paintComponents(this.mainpanel.getGraphics());
	
}




public static boolean CheckFreeSpace(int tfi,int tfj,int tli,int tlj) {  //check if the wanted place is free
	if(tfi==tli)
	{
		if((tfi-1) >= 0 )
		{
			if((arr[tfi-1][Math.min(tlj, tfj)].down.player) != null){
				return false;
			}
			
			
		}
		if((tfi)<= 3)
		{
		if ((arr[tfi][Math.min(tlj, tfj)].up.player) != null){
			return false;
			
		
		}
		
		
		}
	}
	
	if(tfj == tlj)
	{
		if((tfj-1) >= 0 )
		{
			if ((arr[Math.min(tfi, tli)][tfj-1].right.player != null)){
				return false;
				
			}
		
			
		}
		if((tfj)<= 3)
		{
			if(arr[Math.min(tfi, tli)][tfj].left.player != null) {
				return false;
			
			}
		
		}
		
		
	}
	
	


	
	return true;	
}

public Score getScore() // return the current score
{
	
	Score score = new Score();
	int help = 0;
	int playerScore =0;
	int computerScore =0;
	String helper = null;
	
	for(int i =0;i< 4;i++)
	{
		for(int j =0;j< 4;j++)
		{
			if((arr[i][j].up.player!= null)&&(arr[i][j].down.player!= null)&&(arr[i][j].left.player!= null)&&(arr[i][j].right.player!= null))
			{
				help = arr[i][j].up.serialNumber;
				helper = arr[i][j].up.player;
				if(arr[i][j].down.serialNumber > help)
				{
					helper = arr[i][j].down.player;
					help =  arr[i][j].down.serialNumber;
				}
				if(arr[i][j].left.serialNumber > help)
				{
					helper = arr[i][j].left.player;
					help =  arr[i][j].left.serialNumber;
				}
				if(arr[i][j].right.serialNumber > help)
				{
					helper = arr[i][j].right.player;
					help =  arr[i][j].right.serialNumber;
				}
				if(helper.equals("player")) {
					playerScore ++;
					if(needToDrawBox) {
						arr[i][j].needToBeDrown = true;
						arr[i][j].whoGot = "player";
						
					}
					
				}
				if(helper.equals("computer")) {
					computerScore ++;
					if(needToDrawBox)
					{

						arr[i][j].needToBeDrown = true;
						arr[i][j].whoGot = "computer";
						
					}
					
				}
				
			}
			
		}
	}
	score = new Score(playerScore,computerScore);
	return score;
}

public String getResult() //return the corrent result
{
	Score score = getScore();
	if(score.playerScore > 8)
	{
		return ("playerwin");
	}
	if(score.computerScore>8)
	{
		return ("computerwin");
	}
	if((score.playerScore == 8)&&(score.computerScore == 8))
	{
		return("tie");
		
	}
	
	return("noone");
}
//public int minimax(boolean nowplayer,int depth)
//{
	//return 1;
//}




 public int minimax(boolean nowPlayer , int depth,int alpha,int beta) // the AI minimax searching algoritem
{
	 int theBestScore = 0;
	int score =0;
	int lastScore =0;
	if(this.theDepth==depth && getResult().equals("computerwin")) {
		return Integer.MAX_VALUE;
		
	}
	if(this.theDepth==depth && getResult().equals("playerwin")) {
		return -Integer.MAX_VALUE;
		
	}
	if(getResult().equals("playerwin")) {
		if(depth ==0) {
			return -10;
		}
			return (depth * -100);
	}
	if(getResult().equals("computerwin"))
	{
			if(depth ==0) {
				return 10;
			}
			return (depth * 100);
		
	} 
	if(getResult().equals("tie"))
	{
		return 0;
	}
	//if(depth ==0)
	//{
	//	return 0;
	//}
	
	if((depth ==0))
	{
		return  ((getScore().computerScore-getScore().playerScore));
	}
	

	serial ++;//will always be invoked
	
	
	if(nowPlayer)
	{
		theBestScore = Integer.MAX_VALUE;
		outerloop:
		for(int i =0;i<4;i++)
		{
			for(int j =0;j<4; j++)
			{
				if((i==0)&&(arr[i][j].up.player == null))
				{
					lastScore = getScore().playerScore;
					arr[i][j].up.player = "player";
					try {
						arr[i-1][j].down.player="player";
						arr[i-1][j].down.serialNumber = serial;
						
					}
					catch(Exception e)
					{
						
					};
					
					
					arr[i][j].up.serialNumber=serial;
					if(getScore().playerScore > lastScore)
						score = minimax(true,depth-1,alpha,beta);
					else	
						score = minimax(false,depth-1,alpha,beta);
					if(score<theBestScore)
					{
						theBestScore = score;
						//x = new lineRepresa(i,j,i,j+1);
					}
					beta = Math.min(beta, score);
					arr[i][j].up.player = null;
					try {
						arr[i-1][j].down.player=null;
						
					}
					catch(Exception e)
					{
						
					};
					if(alpha >= beta)
						break outerloop;
			
				}
		if(arr[i][j].down.player == null)
		{
			lastScore = getScore().playerScore;
			arr[i][j].down.player = "player";
			try {
				arr[i+1][j].up.player = "player";
				arr[i+1][j].up.serialNumber = serial;
				
			}
			catch(Exception e)
			{
				
			}
			arr[i][j].down.serialNumber = serial;
		
			if(getScore().playerScore > lastScore)
				score = minimax(true,depth-1,alpha,beta);
			else	
				score = minimax(false,depth-1,alpha,beta);
			if(score< theBestScore)
			{
				theBestScore = score;
				
			}
			beta = Math.min(beta, score);
			arr[i][j].down.player = null;
			try {
				arr[i+1][j].up.player = null;
				
			}
			catch(Exception e)
			{
				
			}
			if(alpha >= beta)
				break outerloop;
	
		}
		if((j==0)&&(arr[i][j].left.player == null))
		{
			lastScore = getScore().playerScore;
			arr[i][j].left.player = "player";
			try
			{
				arr[i][j-1].right.player = "player";
				arr[i][j-1].right.serialNumber = serial;
			}
			catch(Exception e)
			{
			
			}
			arr[i][j].left.serialNumber = serial;
			
			if(getScore().playerScore > lastScore)
				score = minimax(true,depth-1,alpha,beta);
			else	
				score = minimax(false,depth-1,alpha,beta);
			if(score<theBestScore)
			{
				 theBestScore=score ;
				
			}
			beta = Math.min(beta, score);
			arr[i][j].left.player = null;
			try
			{
				arr[i][j-1].right.player = null;
			}
			catch(Exception e)
			{
			
			}
			if(alpha >= beta)
				break outerloop;
	
		}
		if(arr[i][j].right.player == null)
		{
			lastScore = getScore().playerScore;
			arr[i][j].right.player = "player";
			try
			{
				arr[i][j+1].left.player = "player";

				arr[i][j+1].left.serialNumber = serial;
			}
			catch(Exception e)
			{
				
			}
			arr[i][j].right.serialNumber =serial;
			
			if(getScore().playerScore > lastScore)
				score = minimax(true,depth-1,alpha,beta);
			else	
				score = minimax(false,depth-1,alpha,beta);
			if(score<theBestScore)
			{
				theBestScore = score;;
				
			}
			beta = Math.min(beta, score);
			arr[i][j].right.player = null;
			try
			{
				arr[i][j+1].left.player =null;
			}
			catch(Exception e)
			{
				
			}
			if(alpha >= beta)
				break outerloop;
	
		}
				
				
			
			}
		}
			
		
	}
	else
	{
		
		theBestScore = Integer.MIN_VALUE;
		outerloop:
		for(int i =0;i<4;i++)
		{
			for(int j =0;j<4; j++)
			{
				if((i==0)&&(arr[i][j].up.player == null))
				{
					lastScore = getScore().computerScore;
					arr[i][j].up.player = "computer";
					try {
						arr[i-1][j].down.player="computer";
						arr[i-1][j].down.serialNumber = serial;
					}
					catch(Exception e)
					{
						
					};
					arr[i][j].up.serialNumber=serial;
					if(getScore().computerScore > lastScore)
						score = minimax(false,depth-1,alpha,beta);
					else
						score = minimax(true,depth-1,alpha,beta);
					if(score>theBestScore)
					{
						theBestScore = score;
						
					}
					alpha = Math.max(alpha, score);
					arr[i][j].up.player = null;
					try {
						arr[i-1][j].down.player=null;
					}
					catch(Exception e)
					{
						
					};
					if(alpha >= beta)
						break outerloop;
			
				}
		if(arr[i][j].down.player == null)
		{
			lastScore = getScore().computerScore;
			arr[i][j].down.player = "computer";
			try {
				arr[i+1][j].up.player = "computer";
				arr[i+1][j].up.serialNumber = serial;
				
			}
			catch(Exception e)
			{
				
			}
			arr[i][j].down.serialNumber = serial;
			
			if(getScore().computerScore > lastScore)
				score = minimax(false,depth-1,alpha,beta);
			else
				score = minimax(true,depth-1,alpha,beta);
			if(score> theBestScore)
			{
				theBestScore = score;
			
			}
			alpha = Math.max(alpha, score);
			arr[i][j].down.player = null;
			try {
				arr[i+1][j].up.player = null;
				
			}
			catch(Exception e)
			{
				
			}
			if(alpha >= beta)
				break outerloop;
	
		}
		if((j==0)&&(arr[i][j].left.player == null))
		{
			lastScore = getScore().computerScore;
			arr[i][j].left.player = "computer";
			try
			{
				arr[i][j-1].right.player = "computer";
				arr[i][j-1].right.serialNumber = serial;
			}
			catch(Exception e)
			{
			
			}
			arr[i][j].left.serialNumber = serial;
			
			if(getScore().computerScore > lastScore)
				score = minimax(false,depth-1,alpha,beta);
			else
				score = minimax(true,depth-1,alpha,beta);
			if(score>theBestScore)
			{
				 theBestScore=score ;
				
			}
			alpha = Math.max(alpha, score);
			arr[i][j].left.player = null;
			try
			{
				arr[i][j-1].right.player = null;

			}
			catch(Exception e)
			{
			
			}
			if(alpha >= beta)
				break outerloop;
	
		}
		if(arr[i][j].right.player == null)
		{
			lastScore = getScore().computerScore;
			arr[i][j].right.player = "computer";
			try
			{
				arr[i][j+1].left.player = "computer";
				arr[i][j+1].left.serialNumber = serial;
			}
			catch(Exception e)
			{
				
			}
			arr[i][j].right.serialNumber =serial;
			
			if(getScore().computerScore > lastScore)
				score = minimax(false,depth-1,alpha,beta);
			else
				score = minimax(true,depth-1,alpha,beta);
			if(score>theBestScore)
			{
				theBestScore = score;;
				
			}
			alpha = Math.max(alpha, score);
			arr[i][j].right.player = null;
			try
			{
				arr[i][j+1].left.player = null;
			}
			catch(Exception e)
			{
				
			}
			if(alpha >= beta)
				break outerloop;
	
		}
				
				
			
			}
		}
		
		
	}
	/*if ((theBestScore == Integer.MAX_VALUE)||(theBestScore == Integer.MIN_VALUE))
	{
		return 0;
	}
	
	*/
	return theBestScore;
}
 


public lineRepresa bestPlace() //returning the best place to put a line by using the minimax method
{
	count ++;
	serial ++;
	int theBestScore = Integer.MIN_VALUE;
	int score =0;
	int lastScore = 0;
	int helper =Integer.MIN_VALUE;
	places.clear();
	
	lineRepresa treturn = new lineRepresa();
	boolean help = isPlayerNowPlaying;
	
	
	for(int i =0;i<4;i++)
	{
		for(int j =0;j<4;j++)
		{
			if((i==0)&&(arr[i][j].up.player == (null)))
					{
				lastScore = getScore().computerScore;
					
						
						
						arr[i][j].up.player = "computer";
						arr[i][j].up.serialNumber = serial;
						
						try {
							arr[i-1][j].down.player="computer";
							arr[i-1][j].down.serialNumber =serial;
						}
						catch(Exception e)
						{
							
							
						};
						serial++;
						if(getScore().computerScore > lastScore)
						{
							score = minimax(false,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
						if(score==helper) {
							places.add(new lineRepresa(i,j,i,j+1));
						}
						if(score > helper) {
							helper=score;
							places.clear();
							places.add(new lineRepresa(i,j,i,j+1));
						}
						}
						else
						{
							score = minimax(true,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
							if(score==helper) {
								places.add(new lineRepresa(i,j,i,j+1));
							}
							if(score > helper) {
								helper=score;
								places.clear();
								places.add(new lineRepresa(i,j,i,j+1));
							}
						}
						
						if(score>theBestScore)
						{
							theBestScore = score;
							treturn = new lineRepresa(i,j,i,j+1);
							
						}
						arr[i][j].up.player = null;
						try {
							arr[i-1][j].down.player=null;
						}
						catch(Exception e)
						{
							
							
						};
				
					}
			if(arr[i][j].down.player == null)
			{
				lastScore = getScore().computerScore;
				arr[i][j].down.player = "computer";
				arr[i][j].down.serialNumber = serial;
				try {
					arr[i+1][j].up.player = "computer";
					arr[i+1][j].up.serialNumber = serial;
					
				}
				catch(Exception e)
				{
					
					
				}
				serial++;
				if(getScore().computerScore > lastScore)
				{
					score = minimax(false,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
				if(score==helper) {
					places.add(new lineRepresa(i+1,j,i+1,j+1));
				}
				if(score > helper) {
					helper=score;
					places.clear();
					places.add(new lineRepresa(i+1,j,i+1,j+1));
				}
				}
				else
				{
					score = minimax(true,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
					if(score==helper) {
						places.add(new lineRepresa(i+1,j,i+1,j+1));
					}
					if(score > helper) {
						helper=score;
						places.clear();
						places.add(new lineRepresa(i+1,j,i+1,j+1));
					}
				}
				if(score>theBestScore)
				{
					theBestScore = score;
					treturn = new lineRepresa(i+1,j,i+1,j+1);
				}
				arr[i][j].down.player = null;
				try {
					arr[i+1][j].up.player = null;
					
				}
				catch(Exception e)
				{
					
					
				}
		
			}
			
			if((j==0)&&(arr[i][j].left.player == null))
			{
				lastScore = getScore().computerScore;
				arr[i][j].left.player = "computer";
				arr[i][j].left.serialNumber= serial;
				try
				{
					arr[i][j-1].right.player = "computer";
					arr[i][j-1].right.serialNumber = serial;
				}
				catch(Exception e)
				{
					
				
				}
				serial ++;
				if(getScore().computerScore > lastScore)
				{
					score = minimax(false,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
				if(score==helper) {
					places.add(new lineRepresa(i,j,i+1,j));
				}
				if(score > helper) {
					helper=score;
					places.clear();
					places.add(new lineRepresa(i,j,i+1,j));
				}
				}
				else
				{
					score = minimax(true,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
				if(score==helper) {
					places.add(new lineRepresa(i,j,i+1,j));
				}
				if(score > helper) {
					helper=score;
					places.clear();
					places.add(new lineRepresa(i,j,i+1,j));
				}
				}
				if(score>theBestScore)
				{
					theBestScore = score;
					treturn = new lineRepresa(i,j,i+1,j);
				}
				arr[i][j].left.player = null;
				try
				{
					arr[i][j-1].right.player = null;
				}
				catch(Exception e)
				{
					
				
				}
		
			}
			if(arr[i][j].right.player == null)
			{
				lastScore = getScore().computerScore;
				arr[i][j].right.player = "computer";
				arr[i][j].right.serialNumber = serial;
				try
				{
					arr[i][j+1].left.player = "computer";
					arr[i][j+1].left.serialNumber = serial;
				}
				catch(Exception e)
				{
					
					
				}
				serial++;
				if(getScore().computerScore > lastScore) {
					score = minimax(false,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
				if(score==helper) {
					places.add(new lineRepresa(i,j+1,i+1,j+1));
				}
				if(score > helper) {
					helper=score;
					places.clear();
					places.add(new lineRepresa(i,j+1,i+1,j+1));
				}
				}
				else {
					score = minimax(true,theDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
				
					if(score==helper) {
						places.add(new lineRepresa(i,j+1,i+1,j+1));
					}
					if(score > helper) {
						helper=score;
						places.clear();
						places.add(new lineRepresa(i,j+1,i+1,j+1));
					}
				}
					
				if(score>theBestScore)
				{
					theBestScore = score;
					treturn = new lineRepresa(i,j+1,i+1,j+1);
				}
				arr[i][j].right.player = null;
				try
				{
					arr[i][j+1].left.player = null;
				}
				catch(Exception e)
				{
					
					
				}
		
			}
			
			
		}
	}
	if(places.size()==1)
	{
		return((lineRepresa)places.get(0)); 
	}
	return((lineRepresa)places.get(rnd.nextInt(places.size())));
	
}


void paintClone()  {//method which drawing a line when the player press 2 buttons or the computer found the best place to put a line
	this.setVisible(true);
	this.mainpanel.setVisible(true);
	this.upperpanel.setVisible(true);
	Graphics x= this.getGraphics();
	System.out.println(helpcount);
	helpcount ++ ;
	System.out.println("get to paintClone");
	
	
	int lastScore =0;
	
		
		
		
		if(((Math.sqrt((Math.abs(this.tfi-this.tli))^2 + (Math.abs(this.tfj-this.tlj))^2)) == 1)&&(CheckFreeSpace(tfi,tfj,tli,tlj)))
		{
			
			
			if(isPlayerNowPlaying)
			{
				System.out.println("get to isPlayerNowPlaying");
				lastScore = getScore().playerScore;
			
			theScore= getScore();
			this.scores.setForeground(colorForPlayer);
			this.scores.setText("your turn"+ " " +  getScore().playerScore + " : "+ getScore().computerScore );
			x.setColor(this.colorForPlayer);
			
			x.drawLine(buttonsarr[this.tfi][this.tfj].getX() +15+5+2, buttonsarr[this.tfi][this.tfj].getY()+240+3+25, buttonsarr[this.tli][this.tlj].getX()+15+5+2, buttonsarr[this.tli][this.tlj].getY()+240+3+25);
			isPlayerNowPlaying = false;
			//this.scores.setForeground(colorForAi);
			//this.scores.setText(" The computer is now playing" +  " " + getScore().playerScore + " : "+ getScore().computerScore+ " " + theDepth);
			
			
				if(this.tfi==this.tli)
				{
					if((tfi-1) >= 0 )
					{
						arr[tfi-1][Math.min(tlj, tfj)].down.player = "player";
						arr[tfi-1][Math.min(tlj, tfj)].down.serialNumber = serial;
						
					}
					if((tfi)<= 3)
					{
					arr[tfi][Math.min(tlj, tfj)].up.player = "player";
					arr[tfi][Math.min(tlj, tfj)].up.serialNumber = serial;
					}
					
					
				}
				
				if(this.tfj == this.tlj)
				{
					if((tfj-1) >= 0 )
					{
						arr[Math.min(tfi, tli)][tfj-1].right.player = "player";
						arr[Math.min(tfi, tli)][tfj-1].right.serialNumber = serial;
						
					}
					if((tfj)<= 3)
					{
					arr[Math.min(tfi, tli)][tfj].left.player = "player";
					arr[Math.min(tfi, tli)][tfj].left.serialNumber = serial;
					}
					
					
				}
				theScore = getScore();
				//this.scores.setText(" The computer is now playing" +  " " + getScore().playerScore + " : "+ getScore().computerScore+ " " + theDepth);
				tfi=-1;
				tfj=-1;
				
				serial ++;
				lineRepresa kilo = new lineRepresa();
				count ++;
				
				if(getScore().playerScore>lastScore)
				{

					 if(this.isTutorial)
					 {
						 JOptionPane.showMessageDialog(null, "now a squere has been completed, so you have another turn.");
						 this.isTutorial =false;
						 this.watingForEnd = true;
					 }
					isPlayerNowPlaying = true;
					
				}
				else
				{
				if((this.isTutorial)||(this.watingForEnd)||(!colorPickerScreen.pvp.isSelected()))
				{
				kilo = bestPlace();
				this.tfi = kilo.fi;
				this.tfj = kilo.fj;
				this.tli = kilo.li;
				this.tlj = kilo.lj;
				
				
				drawagain();
				}
				this.cheacker = true;
				
				}
				this.scores.setText("your turn"+" " + getScore().playerScore + " : "+ getScore().computerScore);
				
			}
			else
			{
				System.out.println("get to !isPlayerNowPlaying");
				theScore = getScore();
				
				System.out.println(this.tfi + " " + this.tfj + " " + this.tli + " " + this.tlj);
				lastScore = getScore().computerScore;
				//this.scores.setForeground(colorForAi);
				//this.scores.setText(" The computer is now playing" + " " +  getScore().playerScore + " : "+ getScore().computerScore+ " " + theDepth);
				x.setColor(this.colorForAi);
				
				x.drawLine(buttonsarr[this.tfi][this.tfj].getX() +15+5+2, buttonsarr[this.tfi][this.tfj].getY()+240+3+25, buttonsarr[this.tli][this.tlj].getX()+15+5+2, buttonsarr[this.tli][this.tlj].getY()+240+3+25);
				
				isPlayerNowPlaying = true;
				this.scores.setForeground(colorForPlayer);
				this.scores.setText("your turn"+" " + getScore().playerScore + " : "+ getScore().computerScore);
				theLastScore = getScore().computerScore;
				
					if(this.tfi==this.tli)
					{
						if((tfi-1) >= 0 )
						{
							arr[tfi-1][Math.min(tlj, tfj)].down.player = "computer";
							arr[tfi-1][Math.min(tlj, tfj)].down.serialNumber = serial;
							
						}
						if((tfi)<= 3)
						{
						arr[tfi][Math.min(tlj, tfj)].up.player = "computer";
						arr[tfi][Math.min(tlj, tfj)].up.serialNumber = serial;
						}
						
						
					}
					if(this.tfj == this.tlj)
					{
						if((tfj-1) >= 0 )
						{
							arr[Math.min(tfi, tli)][tfj-1].right.player ="computer";
							arr[Math.min(tfi, tli)][tfj-1].right.serialNumber = serial;
							
						}
						if((tfj)<= 3)
						{
						arr[Math.min(tfi, tli)][tfj].left.player = "computer";
						arr[Math.min(tfi, tli)][tfj].left.serialNumber = serial;
						}
						
						
					}
					theScore = getScore();
					this.scores.setText("your turn"+ " " + getScore().playerScore + " : "+ getScore().computerScore);
					tfi=-1;
					tfj=-1;
					tli=-1;
					tlj=-1;
					
				if(getScore().computerScore> lastScore) {
					if(getScore().computerScore> 8) {
						JOptionPane.showMessageDialog(null,"computer won");
						if(this.watingForEnd) {
							this.watingForEnd=false;
							JOptionPane.showMessageDialog(null,"as the computer completed the most of the squers, he won this game");
						
							
						}
						
						
					}
					isPlayerNowPlaying = false;
					if(this.isTutorial)
					 {
						 JOptionPane.showMessageDialog(null, "now a squere has been completed, so the computer has another turn.");
						 this.isTutorial = false;
						 this.watingForEnd = true;
					 }
					if((this.isTutorial)||(this.watingForEnd)||(!colorPickerScreen.pvp.isSelected()))
					{
					lineRepresa kilo = bestPlace();
					this.tfi = kilo.fi;
					this.tfj = kilo.fj;
					this.tli = kilo.li;
					this.tlj = kilo.lj;
					paintClone();
					}
					
					
					
					
					
				}
				this.setVisible(true);
				this.scores.setText("your turn"+" " + getScore().playerScore + " : "+ getScore().computerScore);
				
			}
			System.out.println("getOutOf!");
			theScore = getScore();
			
		}
		
		else
		{
			//System.out.println("You need to choose 2 neighboors locations which are not drown");
			JOptionPane.showMessageDialog(null, this.tfi + " " + this.tfj + " " + this.tli + " " + this.tlj);
			JOptionPane.showMessageDialog(null, "You need to choose 2 neighboors locations which are not drown" + (Math.sqrt((Math.abs(this.tfi-this.tli))^2 + (Math.abs(this.tfj-this.tlj))^2)));
			tfi=-1;
			tfj=-1;
			theScore = getScore();
			
		}
		this.needToDrawBox = true;
		theScore = getScore();
		for(int i=0;i<4;i++)
		{
			for(int j =0;j<4;j++)
			{
				if(arr[i][j].needToBeDrown)
				{
					if(arr[i][j].whoGot != null)
					{
						if(arr[i][j].whoGot.equals("player"))
						{
							x.setColor(this.colorForPlayer);
							x.fillRect(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25,133, 133);
							//arr[i][j].needToBeDrown = false;
							//arr[i][j].whoGot = null;
						}
						else
						{
							x.setColor(this.colorForAi);
							x.fillRect(buttonsarr[i][j].getX() +15+5+2, buttonsarr[i][j].getY()+240+3+25,133, 133);
							//arr[i][j].needToBeDrown = false;
							//arr[i][j].whoGot = null;
						}
					}
				}
			}
		}
		this.needToDrawBox= false;
	
	
	serial ++;
	if(getResult().equals("playerwin")) {
		JOptionPane.showMessageDialog(null,"player won");
		if(this.watingForEnd) {
			this.watingForEnd=false;
			JOptionPane.showMessageDialog(null,"as you completed the most of the squers, you won this game!");
		}
		
		
	}
	if(getResult().equals("computerwin")) {
		JOptionPane.showMessageDialog(null,"computer won");
		if(this.watingForEnd) {
			this.watingForEnd=false;
			JOptionPane.showMessageDialog(null,"as the computer completed the most of the squers, he won this game");
		}
		
		
		
	}
	if(getResult().equals("tie")) {
		JOptionPane.showMessageDialog(null,"tie");
		if(this.watingForEnd) {
			this.watingForEnd=false;
			JOptionPane.showMessageDialog(null,"as each one of you has completed 8 squers , the game ends as tie ");
		}
		
		
	}
	
	

			
	this.mainpanel.paintComponents(this.mainpanel.getGraphics());

		
	System.out.println("end of paintCLone");
	
	
}



ActionListener actionListener = new ActionListener() {
	
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(tfi == -1)
			{
			// TODO Auto-generated method stub
				for(int i =0;i<buttonsarr.length;i++)
				{
					for(int j =0; j < buttonsarr.length;j++)
					{
						if(buttonsarr[i][j].equals((JButton) e.getSource()))
								{
									tfi = i;
									tfj = j;
							
							
								}
					}
				}
			
				
			
			}
			else
			{
				for(int i =0;i<buttonsarr.length;i++)
				{
					for(int j =0; j < buttonsarr.length;j++)
					{
						if(buttonsarr[i][j].equals((JButton) e.getSource()))
								{
									tli = i;
									tlj = j;
									cheacker = true;
									
									drawagain();
									
									
									
							
							
								}
					}
				}
				
				
				
			
				
			}
			theScore = getScore();
		}
			
		};
		
		public void drawagain()  {
			paintClone();
		}
	

		
	
	
	
	
	
	
	public static JPanel mainpanel = new JPanel();{
		mainpanel.setPreferredSize(new Dimension (652+15,800));
	}
	public static  JPanel upperpanel = new JPanel();{
		upperpanel.setPreferredSize(new Dimension(652+15,200));
		upperpanel.setOpaque(true);
	}
	public JButton[][] buttonsarr = new JButton[5][5];{
	for(int i =0;i<buttonsarr.length;i++)
	{
		for(int j =0;j<this.buttonsarr.length;j++)
		{
			buttonsarr[i][j] = new JButton();
			
			buttonsarr[i][j].setBounds(j * 133 +45, i * 133 + 45, 30, 30);
			this.mainpanel.add(buttonsarr[i][j]);
			
			buttonsarr[i][j].setBackground(colorForSquers);
			
			buttonsarr[i][j].addActionListener(actionListener);
			
			
		}
	}
	}
	
	
	public Graphics slk;
	public static JLabel scores =  new JLabel();;
	

	
	
	
	
	
	
	
	
	
	 public mainGameScreen(Color colorForPlayer, Color colorForAi,Color colorForSquers,Color colorForBackground,boolean thisisTutorial)//constructor
	{
		 this.isTutorial = thisisTutorial;
		 if(thisisTutorial)
		 {
			 isTutorial = true;
			 startingScreen.isTutorial = false;
		 }
		 mainpanel.setBackground(colorForBackground);
		 upperpanel.setBackground(colorForBackground);
		 
		 this.paintComponents(getGraphics());
		
		 this.setVisible(true);
		
		this.menuBar.add(gameMenu);
		gameMenu.add(this.restart);
		gameMenu.add(this.newGame);
		gameMenu.add(this.exit);
		
		this.setJMenuBar(menuBar);
		
		 this.setResizable(false);
		 this.isTutorial = startingScreen.isTutorial;
		 this.colorForSquers=colorForSquers;
		 this.colorForBackGround=colorForBackground;
		 
			 
		this.exit.addActionListener(colorPickerScreen.actionListenerForMenu);
		this.restart.addActionListener(colorPickerScreen.actionListenerForMenu);
		this.newGame.addActionListener(colorPickerScreen.actionListenerForMenu);
		 //mainpanel.setBackground(this.colorForSquers);
		 for(int i =0;i<buttonsarr.length;i++)
			{
				for(int j =0;j<this.buttonsarr.length;j++)
				{
					
					
					this.buttonsarr[i][j].setBackground(colorForSquers);
					
					
					
					
				}
			}
		arr = new QubeSimpelation[4][4];
		for(int i = 0; i< 4 ; i++)
		{
			for(int j = 0; j < 4; j ++)
			{
				arr[i][j] = new QubeSimpelation();
			}
		}
	
		this.setSize(652+15, 1000);
		this.setResizable(false);
		
		this.colorForPlayer = colorForPlayer;
		this.colorForAi = colorForAi;
		this.mainpanel.setLayout(null);
		
		
		this.getContentPane().setVisible(true);
		
		this.mainpanel.setLayout(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.add(upperpanel);
		
	
		upperpanel.setBounds(0, 0, 652+15, 200);
		this.add(mainpanel);
		mainpanel.setBounds(0,200,652+15,800);
		
		
		upperpanel.add(scores);
		scores.setBounds(0, 0, 800, 200);
		
		scores.setFont(new Font( "Tahoma",1,40));
		scores.setForeground(colorForPlayer);
		this.scores.setText("your turn 0 : 0");
		this.setVisible(true);
		
		
		
		/*if(this.cheacker)
		{
			this.update(slk);
			this.cheacker = false;
		}
		*/
		
		
		if(!thisisTutorial)
		{
			this.isPlayerNowPlaying =(colorPickerScreen.playerStarts.isSelected());
		}
		else
		{
			this.isPlayerNowPlaying=true;
		}
		if(!this.isPlayerNowPlaying&&(!colorPickerScreen.pvp.isSelected()))
		{
			
				System.out.println("get to ! inside constructor");
				this.tfi = 1;
				this.tfj = 2;
				this.tli =2;
				this.tlj=2;
				
				//g.setColor(this.colorForAi);
				//g.drawLine(buttonsarr[this.tfi][this.tfj].getX() +15, buttonsarr[this.tfi][this.tfj].getY()+240, buttonsarr[this.tli][this.tlj].getX()+15, buttonsarr[this.tli][this.tlj].getY()+240);
				paintClone();
				//this.isPlayerNowPlaying=true;
				
				System.out.println("end of  ! inside constructor");
			
		}
		
		mainpanel.setBackground(colorForBackground);
		upperpanel.setBackground(colorForBackground);
		
		 setLocationRelativeTo(null);
		 if(this.isTutorial)
		 {
			 JOptionPane.showMessageDialog(null, "To start, choose 2 close squers,verticly or horizontaly, and wait for the computer to perform his turn.");
		 }
		
		
		 this.setLocationRelativeTo(null);
		 
	
	}
	
	
	

}



