package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

public class startingScreen extends JFrame{
	public static colorPickerScreen m = null;
	public static boolean isTutorial = false; 
	public static mainGameScreen z = null ;
	public static startingScreen x;
	
	public startingScreen()//constructor
	{
		this.setSize(720, 598);
		JPanel mainpanel = new JPanel();
		mainpanel.setSize(600,600);
		this.setContentPane(mainpanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel upperpanel = new JPanel();
		upperpanel.setPreferredSize(new Dimension(720,598));
		
		JMenuItem save = new JMenuItem("save");
		JFrame mainframe = this;
		
		upperpanel.setOpaque(true);
		mainpanel.setOpaque(true);
		JLabel imagelabel = new JLabel(new ImageIcon("C:\\\\Users\\\\nkkin\\\\Desktop/imagefortheproject(2).png"));
		
		
		

		
		JPanel lowerpanel = new JPanel();
		JButton play = new JButton ("Play");
		JButton tutorial = new JButton("Tutorial");
		JButton exit = new JButton("Exit game");
		
		JMenuBar menubarformain = new JMenuBar();
		JMenu filemenu = new JMenu("file");
	
		
		
		
		JMenu helpmenu = new JMenu("Help");
		menubarformain.add(filemenu);
		menubarformain.add(helpmenu);
		
		mainframe.setJMenuBar(menubarformain);
		
		JFrame tutorialframe = new JFrame("Tutorial");
		JPanel tutorialpanel = new JPanel();
		
		JFrame maingame = new JFrame("Dots & Boxes");
		JPanel maingamepanel = new JPanel();
		maingame.setContentPane(maingamepanel);
		
		
		
		tutorialframe.setContentPane(tutorialpanel);
		tutorialframe.setSize(400, 400);
		
		maingame.setSize(500, 500);
		tutorialframe.setVisible(false);
	
		
		
		play.setBackground(new Color(200,200,252));		
		tutorial.setBackground(new Color(178,178,232));
		exit.setBackground(new Color(148,148,202));
		
		play.setFont(new Font("Tahoma",1,15));
		tutorial.setFont(new Font("Tahoma",1,15));
		exit.setFont(new Font("Tahoma",1,15));
		
		play.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.WHITE));
		tutorial.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.WHITE));
		exit.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.WHITE));
		
		lowerpanel.setPreferredSize(new Dimension(600,435));
		lowerpanel.setBackground(null);
		lowerpanel.setLayout(null);
		
		
		
		
		
		JButton back1 = new JButton("back");
		JButton back2 = new JButton("back");
		
		JMenuItem exitfrommenubar = new JMenuItem("exit");
		filemenu.add(exitfrommenubar);
		
		
		tutorialframe.add(back1);
		maingame.add(back2);
		
	
		JMenuItem gototutorial = new JMenuItem("How to play?");
		
		helpmenu.add(gototutorial);
		
		
		
		
				
		imagelabel.setOpaque(true);
		upperpanel.add(imagelabel);
		
		
		JPanel buttonspanel = new JPanel();
		buttonspanel.setPreferredSize(new Dimension(300,150));
		buttonspanel.setBackground(Color.WHITE);
		buttonspanel.setLayout(new GridLayout(3,1));
		buttonspanel.add(play);
		//lowerpanel.add(buttonspanel);
		
	
;		
		mainpanel.add(upperpanel);
		//mainpanel.add(lowerpanel);
		
		buttonspanel.add(play);
		buttonspanel.add(tutorial);
		buttonspanel.add(exit);
		
		imagelabel.add(buttonspanel);
		buttonspanel.setBounds(260, 255, 200, 100);
		buttonspanel.setVisible(true);
		
		imagelabel.setBounds(0, 0, 600, 600);
		//lowerpanel.add(buttonspanel);
		
		
		
		
		
		mainpanel.setVisible(true);
		upperpanel.setVisible(true);
		
		
	
		
		
		
		
		this.setTitle("Dots and Boxes");
		this.setVisible(true);
		
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((e.getSource().equals(tutorial))||(e.getSource().equals(gototutorial)))
				{
					isTutorial =true;
					setVisible(false);
					if((z==null)&&(colorPickerScreen.z == null))
					{
						
						z = new mainGameScreen(Color.RED,Color.BLUE,Color.BLACK,Color.WHITE,true);
						
					}
					else
					{
						z=colorPickerScreen.z;
						z.arr = new QubeSimpelation[4][4];
						for(int i =0;i<4;i++) {
							for(int j = 0;j<4;j++) {
								z.arr[i][j] = new QubeSimpelation();
							}
						}
						
						z.repaint();
						if(!colorPickerScreen.pvp.isSelected())
						z.isPlayerNowPlaying=true;
						z.colorForPlayer=Color.RED;
						
						z.colorForAi=Color.BLUE;
						
						z.colorForSquers=Color.BLACK;
						
						z.colorForBackGround=Color.WHITE;
						z.setVisible(true);
						z.mainpanel.setBackground(Color.WHITE);
						z.upperpanel.setBackground(z.colorForBackGround);
						 for(int i =0;i<z.buttonsarr.length;i++)
							{
								for(int j =0;j<z.buttonsarr.length;j++)
								{
									
									
									z.buttonsarr[i][j].setBackground(z.colorForSquers);
									
									
									
									
								}
							}
					}
					//if(!z.isPlayerNowPlaying)
					//{
					//z.tfi = 1;
					//	z.tfj = 2;
					//	z.tli = 2;
					//	z.tlj =2;
					//	z.paintClone();
					//}
					z.scores.setForeground(Color.RED);
					z.scores.setText("your turn 0 : 0");
					z.isTutorial = true;
					JOptionPane.showMessageDialog(null, "To start, choose 2 close squers,verticly or horizontaly, and wait for the computer to perform his turn.");
					
				}
				if(e.getSource().equals(play))
				{
					mainframe.dispose();
					
					  m = new colorPickerScreen();
				}
				
				if((e.getSource().equals(exit))||(e.getSource().equals(exitfrommenubar))) {
					System.exit(0);
				}
				if(e.getSource().equals(back1)) {
					tutorialframe.setVisible(false);
					mainframe.setVisible(true);
				}
				if(e.getSource().equals(back2)) {
					maingame.setVisible(false);
					mainframe.setVisible(true);
				}
				
				
				
				
			}
			
			
		};
		
		
		
		tutorial.addActionListener(actionListener);
		play.addActionListener(actionListener);
		exit.addActionListener(actionListener);
		back1.addActionListener(actionListener);
		back2.addActionListener(actionListener);
		exitfrommenubar.addActionListener(actionListener);
		gototutorial.addActionListener(actionListener);
		
		maingame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tutorialframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		maingame.setLocationRelativeTo(null);
		tutorialframe.setLocationRelativeTo(null);
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 x = new startingScreen();
		

	}

}
