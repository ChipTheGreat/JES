package main;

import javax.swing.JFrame;


public class Main{
	public static void main(String[] args){
		System.out.println("Hello world");
		JFrame window = new JFrame();
		
		GamePanel gamepanel = new GamePanel();

		window.add(gamepanel);
		window.pack();	

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);

		window.setTitle("Feel The Thunder");

		window.setLocationRelativeTo(null);
	}
}
