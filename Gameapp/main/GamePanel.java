package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREENSETTINGS
	final int tilesize = 16;
	final int scaler = 4;

	final int finalTileSize = tilesize * scaler;

	final int amountOfVerticalTiles = 10;
	final int amountOfHorizontalTiles = 14;

	final int ScreenWidth = finalTileSize * amountOfHorizontalTiles;
	final int ScreenHeight = finalTileSize * amountOfVerticalTiles;
	
	Thread gameThread;



	public GamePanel() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);	
	
	}
	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();	
	}
	@override	
	public void run(){
			
	}
}
