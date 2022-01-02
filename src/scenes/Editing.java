package scenes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import helpz.LoadSave;
import main.Game;
import objects.PathPoint;
import objects.Tile;
import ui.Toolbar;

import static helpz.Constants.Tiles.ROAD_TILE;

public class Editing extends GameScene implements SceneMethods {

	private int[][] lvl;
	private Tile selectedTile;
	private int mouseX, mouseY;
	private int lastTileX, lastTileY, lastTileId;
	private boolean drawSelect;
	private Toolbar toolbar;
	private PathPoint start, end;

	public Editing(Game game) {
		super(game);
		loadDefaultLevel();
		toolbar = new Toolbar(0, 640, 640, 160, this);
	}

	private void loadDefaultLevel() {
		lvl = LoadSave.GetLevelData();
		ArrayList<PathPoint> points = LoadSave.GetLevelPathPoints();
		start = points.get(0);
		end = points.get(1);
	}

	public void update() {
		updateTick();
	}

	@Override
	public void render(Graphics g) {

		drawLevel(g);
		toolbar.draw(g);
		drawSelectedTile(g);
		drawPathPoints(g);

	}

	private void drawPathPoints(Graphics g) {
		if (start != null)
			g.drawImage(toolbar.getStartPathImg(), start.getxCord() * 32, start.getyCord() * 32, 32, 32, null);

		if (end != null)
			g.drawImage(toolbar.getEndPathImg(), end.getxCord() * 32, end.getyCord() * 32, 32, 32, null);

	}

	private void drawLevel(Graphics g) {
		for (int y = 0; y < lvl.length; y++) {
			for (int x = 0; x < lvl[y].length; x++) {
				int id = lvl[y][x];
				if (isAnimation(id)) {
					g.drawImage(getSprite(id, animationIndex), x * 32, y * 32, null);
				} else
					g.drawImage(getSprite(id), x * 32, y * 32, null);
			}
		}
	}

	private void drawSelectedTile(Graphics g) {
		if (selectedTile != null && drawSelect) {
			g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
		}
	}

	public void saveLevel() {

		LoadSave.SaveLevel(lvl, start, end);
		game.getPlaying().setLevel(lvl);

	}

	public void setSelectedTile(Tile tile) {
		this.selectedTile = tile;
		drawSelect = true;
	}

	private void changeTile(int x, int y) {
		if (selectedTile != null) {
			int tileX = x / 32;
			int tileY = y / 32;

			if (selectedTile.getId() >= 0) {
				if (lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId())
					return;

				lastTileX = tileX;
				lastTileY = tileY;
				lastTileId = selectedTile.getId();

				lvl[tileY][tileX] = selectedTile.getId();
			} else {
				int id = lvl[tileY][tileX];
				if (game.getTileManager().getTile(id).getTileType() == ROAD_TILE) {
					if (selectedTile.getId() == -1)
						start = new PathPoint(tileX, tileY);
					else
						end = new PathPoint(tileX, tileY);
				}
			}
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (y >= 640) {
			toolbar.mouseClicked(x, y);
		} else {
			changeTile(mouseX, mouseY);
		}

	}

	@Override
	public void mouseMoved(int x, int y) {

		if (y >= 640) {
			toolbar.mouseMoved(x, y);
			drawSelect = false;
		} else {
			drawSelect = true;
			mouseX = (x / 32) * 32;
			mouseY = (y / 32) * 32;
		}

	}

	@Override
	public void mousePressed(int x, int y) {
		if (y >= 640)
			toolbar.mousePressed(x, y);

	}

	@Override
	public void mouseReleased(int x, int y) {
		toolbar.mouseReleased(x, y);

	}

	@Override
	public void mouseDragged(int x, int y) {
		if (y >= 640) {

		} else {
			changeTile(x, y);
		}

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_R)
			toolbar.rotateSprite();
	}

}
