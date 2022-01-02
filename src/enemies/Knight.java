package enemies;

import static helpz.Constants.Enemies.KNIGHT;

import managers.EnemyManager;

public class Knight extends Enemy {

	public Knight(float x, float y, int ID,EnemyManager em) {
		super(x, y, ID, KNIGHT,em);
		
	}

}
