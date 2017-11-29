package gdx.menu.Screens;

import gdx.menu.GamMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;

public class Button extends Sprite {
    GamMenu gamMenu;

    public Button(int nW, int nH, int nX, int nY, String sFileName) {
        super(new Texture(Gdx.files.internal(sFileName)));
        setPosition(nX, nY);
        setFlip(false, true);
        setSize(nW, nH);
    }

    public Button(Button Button) {
        super();
    }
}
