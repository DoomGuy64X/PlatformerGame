package entities;

import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.IDLE;
import static utils.Constants.PlayerConstants.WALKING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entitiy {
	private static final int ATTACK = 0;
	private int aniTick, aniIndex, aniSpeed = 25;
	private int PlayerAction = IDLE;
	private boolean moving=false, attacking = false;
	private boolean left, up, right, down;
	private float playerSpeed = 2.0f;

	private BufferedImage[][] animations;
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
	}

	public void update() {
		updatePos();
		updateAnimationTick();	
		setAnimation();
		
		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[PlayerAction][aniIndex], (int) x, (int) y,128, 128, null);

	}
		
	 
	


		
		private void updateAnimationTick() {
			aniTick++;
			if (aniTick >= aniSpeed) {
				aniTick= 0;
				aniIndex++;
				if(aniIndex >= GetSpriteAmount(PlayerAction)) {
					aniIndex = 0;
					attacking = false;
				}
					
				   
			}
			
		}
		
		private void setAnimation() {
			int startAni = PlayerAction;
			if(moving)
				PlayerAction=WALKING;
			else 
				PlayerAction=IDLE;
			
			if(attacking)
				PlayerAction=ATTACK;
			if(startAni != PlayerAction)
			resetAniTick();
		}
		private void resetAniTick() {
			aniTick=0;
			aniIndex=0;
			
		}

		private void updatePos() {
			
			moving = false;

			if(left&& !right) {
				x-=playerSpeed;
				moving = true;
			}else if(right&& !left) {
				x+= playerSpeed;
				moving = true;
			}
			
			if(up && !down) {
				y-=playerSpeed;
				moving = true;
			}else if (down && !up) {
				y+= playerSpeed;
				moving = true;
			}
			
	}
	
private void loadAnimations() {
	InputStream is = getClass().getResourceAsStream("/css_sprites (4).png");
	
	
	
	try {
		BufferedImage img = ImageIO.read(is);

animations = new BufferedImage[7][6];

for(int j =0; j< animations.length; j++)
for(int i=0; i < animations[j].length; i++)
    animations[j][i]= img.getSubimage(i*32, j*32, 32, 32);

		img = ImageIO.read(is);
	} catch (IOException e) {
		e.printStackTrace();
	}   finally {
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	}	
	
{


}

public void resetDirBooleans() {
	left = false;
	right = false;
	up = false;
	down = false;
}

public boolean isLeft() {
	return left;
}

public void setAttacking(boolean attacking) {
	this.attacking = attacking;
}

public void setLeft(boolean left) {
	this.left = left;
}

public boolean isUp() {
	return up;
}

public void setUp(boolean up) {
	this.up = up;
}

public boolean isRight() {
	return right;
}

public void setRight(boolean right) {
	this.right = right;
}

public boolean isDown() {
	return down;
}

public void setDown(boolean down) {
	this.down = down;
}
}