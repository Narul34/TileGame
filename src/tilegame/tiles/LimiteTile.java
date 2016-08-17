package tilegame.tiles;

import tilegame.gfx.Assets;


//Classe Tile qui correpsond � la limite ext�rieur de la carte

public class LimiteTile extends Tile{

	public LimiteTile(int id) {
		super(Assets.limite, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
