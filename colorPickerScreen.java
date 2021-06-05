package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class colorPickerScreen extends JFrame {
	
	public static JButton back ;
	public static JButton pickAiColor;
	public static JButton pickPlayerColor;
	public static JButton launchGame;
	public static Color colorForPlayer = Color.BLACK ;
	public static Color colorForAi = Color.BLACK ;
	public static  Color colorForSquers = Color.BLACK;
	public static JDialog dialogColorChooser;
	public static  JCheckBox playerStarts ;
	public static JCheckBox computerStarts ;
	public static JCheckBox pvp ;
	
	public static JButton pickSquersColors;
	public static Color colorForBackGround;
	public static JButton pickBackgroundColor;

	
	public static JColorChooser colorChooser = new JColorChooser(Color.WHITE);
	public void closeTheWindow() {//method which closing the window
		this.dispose();
	}
	ActionListener okListenerForAi = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			pickAiColor.setBackground(colorChooser.getColor());
			colorForAi = colorChooser.getColor();
			dialogColorChooser.dispose();
			
			
			
			
		}
		
	};
	ActionListener okListenerForBackground = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			pickBackgroundColor.setBackground(colorChooser.getColor());
			colorForBackGround = colorChooser.getColor();
			dialogColorChooser.dispose();
			
			
			
			
		}
		
	};
	ActionListener okListenerForSquers = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			colorForSquers=colorChooser.getColor();
			pickSquersColors.setBackground(colorForSquers);
			dialogColorChooser.dispose();
			
		}
	
	};
	
	public void itemStateChanged(ItemEvent e) {
		
		}
		
	

	ActionListener okListenerForPlayer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			pickPlayerColor.setBackground(colorChooser.getColor());
			colorForPlayer = colorChooser.getColor();
			dialogColorChooser.dispose();
			
		}
		
	};
	ActionListener cancelListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dialogColorChooser.dispose();
			
		}
		
	};
	
	
	ActionListener actionListener = new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(playerStarts)) {
				if(((JCheckBox)e.getSource()).isSelected() ) {
					
						computerStarts.setSelected(false);
						pvp.setSelected(false);
					}
				else
					{
					playerStarts.setSelected(true);
						
					}
				
					
				}
			if(e.getSource().equals(computerStarts)) {
				if(((JCheckBox)e.getSource()).isSelected()) {
					
						playerStarts.setSelected(false);
						pvp.setSelected(false);
						
					}
				else
					{
					computerStarts.setSelected(true);
						
					}
				
					
				}
			if(e.getSource().equals(pvp))
			{
				computerStarts.setSelected(false);
				playerStarts.setSelected(false);
			}
			if(e.getSource().equals(back)) {
				new startingScreen();
				closeTheWindow();
				
				
				
			}
			if(e.getSource().equals(pickAiColor))
			{
				
				colorChooser = new JColorChooser(Color.WHITE);
				colorChooser.setPreviewPanel(new JPanel());
				for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
				{
					if ((!panel.getDisplayName().equals("HSV"))&&(!panel.getDisplayName().equals("Swatches")))
					{
						colorChooser.removeChooserPanel(panel);
					}
							
							
				}
				dialogColorChooser = colorChooser.createDialog(colorPickerScreen.this, "choose color", false, colorChooser,okListenerForAi, null);
				dialogColorChooser.show();
				
				
				
				
				
			}
			if(e.getSource().equals(pickSquersColors))
			{
				
				colorChooser = new JColorChooser(Color.WHITE);
				colorChooser.setPreviewPanel(new JPanel());
				for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
				{
					if ((!panel.getDisplayName().equals("HSV"))&&(!panel.getDisplayName().equals("Swatches")))
					{
						colorChooser.removeChooserPanel(panel);
					}
							
							
				}
				dialogColorChooser = colorChooser.createDialog(colorPickerScreen.this, "choose color", false, colorChooser,okListenerForSquers, null);
				dialogColorChooser.show();
				
				
				
				
				
			}
			if(e.getSource().equals(pickBackgroundColor))
			{
				
				colorChooser = new JColorChooser(Color.BLACK);
				colorChooser.setPreviewPanel(new JPanel());
				for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
				{
					if ((!panel.getDisplayName().equals("HSV"))&&(!panel.getDisplayName().equals("Swatches")))
					{
						colorChooser.removeChooserPanel(panel);
					}
							
							
				}
				dialogColorChooser = colorChooser.createDialog(colorPickerScreen.this, "choose color", false, colorChooser,okListenerForBackground, null);
				dialogColorChooser.show();
				
				
				
				
				
			}
			if(e.getSource().equals(pickPlayerColor))
			{
				colorChooser = new JColorChooser(Color.WHITE);
				colorChooser.setPreviewPanel(new JPanel());
				for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
				{
					if ((!panel.getDisplayName().equals("HSV"))&&(!panel.getDisplayName().equals("Swatches")))
					{
						colorChooser.removeChooserPanel(panel);
					}
							
							
				}
				dialogColorChooser = colorChooser.createDialog(colorPickerScreen.this, "choose color", false, colorChooser,okListenerForPlayer, null);
				dialogColorChooser.show();
				
				
				
				
				
			}
			if(e.getSource().equals(launchGame))
			{
				setVisible(false);
				mainGameScreen z = new mainGameScreen(colorForPlayer,colorForAi,colorForSquers,colorForBackGround);
				//if(!z.isPlayerNowPlaying)
				//{
				//z.tfi = 1;
				//	z.tfj = 2;
				//	z.tli = 2;
				//	z.tlj =2;
				//	z.paintClone();
				//}
			}
		}
			
		};
	
	
	
	
	public colorPickerScreen()//constructor
	{
		this.back=new JButton("back");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.pickSquersColors = new JButton("squers color");
		this.playerStarts = new JCheckBox("you start",true);
		this.computerStarts = new JCheckBox("the computer starts",false);
		 this.pvp = new JCheckBox("player vs player");
		this.pickBackgroundColor = new JButton("background color");
		
		this.pickAiColor = new JButton("choose");
		this.pickPlayerColor = new JButton("choose");
		this.launchGame = new JButton("launch");
		JPanel mainpanel = new JPanel();
		JPanel upperpanel = new JPanel();
		upperpanel.setPreferredSize(new Dimension(600,100));
		mainpanel.setPreferredSize(new Dimension(600,500));
		this.setSize(600, 600);
		this.setLayout(null);
		this.add(upperpanel);
		upperpanel.setBounds(0, 0,600,100);
		this.add(mainpanel);
		mainpanel.setBounds(0, 100,600,500);
		
		for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
		{
			if ((!panel.getDisplayName().equals("HSV")))
			{
				colorChooser.removeChooserPanel(panel);
			}
					
					
		}
		colorChooser.setPreviewPanel(new JPanel());
		JLabel upperpanellabel = new JLabel("pre-launch settings :");
		upperpanel.setLayout(null);
		upperpanel.add(upperpanellabel);
		upperpanellabel.setBounds(0, 0, 600, 100);
		upperpanellabel.setAlignmentY(CENTER_ALIGNMENT);
		upperpanellabel.setHorizontalAlignment(JLabel.CENTER);
		upperpanellabel.setFont(new Font( "Tahoma",1,25));
		upperpanellabel.setOpaque(true);
		JLabel pickurcolor = new JLabel("pick your color :");
		mainpanel.add(pickurcolor);
		mainpanel.add(pickPlayerColor);
		JLabel pickcomcolor =new JLabel("pick the computer color :");
		mainpanel.add(pickcomcolor);
		mainpanel.add(pickAiColor);
		mainpanel.add(launchGame);
		mainpanel.add(playerStarts);
		mainpanel.add(computerStarts);
		mainpanel.add(pvp);
		mainpanel.add(pickSquersColors);
		mainpanel.add(pickBackgroundColor);
		mainpanel.add(back);
		mainpanel.setLayout(null);
		
		pickurcolor.setBounds(20,10,170,20);
		pickPlayerColor.setBounds(190, 10, 200, 20);
		pickcomcolor.setBounds(20,45,170,20);
		pickAiColor.setBounds(190, 45, 200, 20);
		playerStarts.setBounds(20, 80, 170, 20);
		computerStarts.setBounds(190, 80, 170, 20);
		pvp.setBounds(20, 115, 170, 20);
		pickSquersColors.setBounds(20, 150, 170, 20);
		pickBackgroundColor.setBounds(215, 150, 200, 20);
		launchGame.setBounds(20, 400, 90, 40);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pickAiColor.addActionListener(actionListener);
		pickPlayerColor.addActionListener(actionListener);
		launchGame.addActionListener(actionListener);
		playerStarts.addActionListener(actionListener);
		computerStarts.addActionListener(actionListener);
		pickSquersColors.addActionListener(actionListener);
		pickBackgroundColor.addActionListener(actionListener);
		back.setBounds(480, 400, 90, 40);
		back.addActionListener(actionListener);
		this.setVisible(true);
		mainpanel.setVisible(true);
		this.pvp.addActionListener(actionListener);
		
	}

}
