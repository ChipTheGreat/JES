package main;

import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREENSETTINGS
	final int tilesize = 16;
	final int scaler = 4;

	final int finalTileSize = tilesize * scaler;

	final int amountOfVerticalTiles = 10;
	final int amountOfHorizontalTiles = 16;

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
	@Override	
	public void run(){
		while(gameThread != null ){
			//TODO 
			// UPDATE THE GAMES INFORMATIONS ETC
			update();
			// DRAW THE SCREEN WITH NEW DATA OR UPDATE THE OLD ONES
			repaint();
			}			
	} 
	public void update(){
		//Update infos in this methode	
	}
	public void paintComponent(Graphics g){
		//Draw objects and sprites here
		super.paintComponent(g);
		Graphics gx2d = (Graphics2D)g;

		gx2d.setColor(Color.white);
		gx2d.fillRect(100, 100, finalTileSize, finalTileSize);

		gx2d.dispose();
	}
	

}
