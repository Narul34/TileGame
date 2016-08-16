package tilegame.tiles;

import tilegame.gfx.Assets;

// "Tile" de type Mur

public class MurTile extends Tile {

	public MurTile(int id) {
		super(Assets.mur, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
