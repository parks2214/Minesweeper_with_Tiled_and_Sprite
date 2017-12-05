package gdx.menu.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;

public class Dude extends Sprite{
    public Dude(int nW, int nH, int nX, int nY){
        super(new Texture(Gdx.files.internal("boye.jpg")));
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, true);
    }
}
