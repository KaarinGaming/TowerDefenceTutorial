package helpz;

public class Constants {

	public static class Projectiles {
		public static final int ARROW = 0;
		public static final int CHAINS = 1;
		public static final int BOMB = 2;

		public static float GetSpeed(int type) {
			switch (type) {
			case ARROW:
				return 8f;
			case BOMB:
				return 4f;
			case CHAINS:
				return 6f;
			}
			return 0f;
		}
	}

	public static class Towers {
		public static final int CANNON = 0;
		public static final int ARCHER = 1;
		public static final int WIZARD = 2;

		public static int GetTowerCost(int towerType) {
			switch (towerType) {
			case CANNON:
				return 65;
			case ARCHER:
				return 35;
			case WIZARD:
				return 50;
			}
			return 0;
		}

		public static String GetName(int towerType) {
			switch (towerType) {
			case CANNON:
				return "Cannon";
			case ARCHER:
				return "Archer";
			case WIZARD:
				return "Wizard";
			}
			return "";
		}

		public static int GetStartDmg(int towerType) {
			switch (towerType) {
			case CANNON:
				return 15;
			case ARCHER:
				return 5;
			case WIZARD:
				return 0;
			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
			case CANNON:
				return 75;
			case ARCHER:
				return 120;
			case WIZARD:
				return 100;
			}

			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {
			case CANNON:
				return 120;
			case ARCHER:
				return 35;
			case WIZARD:
				return 50;
			}

			return 0;
		}
	}

	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class Enemies {

		public static final int ORC = 0;
		public static final int BAT = 1;
		public static final int KNIGHT = 2;
		public static final int WOLF = 3;

		public static int GetReward(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 5;
			case BAT:
				return 5;
			case KNIGHT:
				return 25;
			case WOLF:
				return 10;
			}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 0.5f;
			case BAT:
				return 0.7f;
			case KNIGHT:
				return 0.45f;
			case WOLF:
				return 0.85f;
			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 85;
			case BAT:
				return 100;
			case KNIGHT:
				return 400;
			case WOLF:
				return 125;
			}
			return 0;
		}
	}

	public static class Tiles {
		public static final int WATER_TILE = 0;
		public static final int GRASS_TILE = 1;
		public static final int ROAD_TILE = 2;
	}

}
