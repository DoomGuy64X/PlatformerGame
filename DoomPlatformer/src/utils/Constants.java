package utils;

public class Constants {
	
	public static class Directions{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int DOWN = 2;
		public static final int RIGHT = 3;
	}
	
	public static class PlayerConstants{
		public static final int IDLE = 0;
		public static final int WALKING = 1;
		public static final int JUMPING = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK = 6;
		
		public static int GetSpriteAmount(int player_action) {
			
			switch(player_action) {
			
			case WALKING:
			case JUMPING:
			case ATTACK:
				return 6;
			case IDLE:
			case HIT:
				return 5;
			case GROUND:
				return 1;
			case FALLING:
			default:
				return 0;
				
			
			}
		}
		
	}

}
