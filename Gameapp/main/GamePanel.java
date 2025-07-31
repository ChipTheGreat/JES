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
	keyHandler keyH = new keyHandler();
	
	int playerx = 100;
	int playery = 100;
	double playerSpeed = 4;

	//FPS
	int FPS = 60;

	public GamePanel() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);	
	
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();	
	}
	@Override	
	public void run(){
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null ){
			//TODO 
			// UPDATE THE GAMES INFORMATIONS ETC

			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			//just timer so the game isnt super fast
			if(delta >= 1){

				update();
				// DRAW THE SCREEN WITH NEW DATA OR UPDATE THE OLD ONES
				repaint();

				delta--;

			}
		}			
	} 
	public void update(){
		//Update infos in this methode	
		if(keyH.upPressed){
			playery -= playerSpeed; 
		} else if(keyH.downPressed){
			playery += playerSpeed;
		} else if(keyH.rightPressed){
			playerx += playerSpeed;
		} else if(keyH.leftPressed){
			playerx -= playerSpeed;
		}
	}
	public void paintComponent(Graphics g){
		//Draw objects and sprites here
		super.paintComponent(g);
		Graphics gx2d = (Graphics2D)g;

		gx2d.setColor(Color.white);
		gx2d.fillRect(playerx, playery, finalTileSize, finalTileSize);

		gx2d.dispose();
	}
	

}
