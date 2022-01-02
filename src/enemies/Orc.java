package enemies;

import static helpz.Constants.Enemies.ORC;

import managers.EnemyManager;

public class Orc extends Enemy {

	public Orc(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, ORC,em);
	}

}
