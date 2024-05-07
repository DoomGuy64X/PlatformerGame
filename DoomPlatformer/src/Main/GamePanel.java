package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private Game game;
	
	
	public GamePanel(Game game) {
	
		mouseInputs = new MouseInputs(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyBoardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	

	

	private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
		
	}



	public void updateGame() {
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);		
	}

public Game getGame() {
	return game;
}
	


	

}
