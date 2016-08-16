package tilegame.tiles;

import tilegame.gfx.Assets;

public class LimiteTile extends Tile{

	public LimiteTile(int id) {
		super(Assets.limite, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
