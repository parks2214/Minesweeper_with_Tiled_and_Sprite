package gdx.menu.Screens;

import gdx.menu.GamMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;

public class Button extends Sprite {

    public String _sFileName;
    GamMenu gamMenu;

    public Button(int nW, int nH, int nX, int nY, String sFileName) {
        super(new Texture(Gdx.files.internal(sFileName)));
        _sFileName = sFileName;
        setPosition(nX, nY);
        setFlip(false, true);
        setSize(nW, nH);
    }

    public Button(Button Button) {
        super();
    }

    public boolean isHit(int screenX, int screenY) {
        if (screenX >= getX() && screenX <= getX() + getWidth()) {
            if (screenY >= getY() && screenY <= getY() + getHeight()) {
                if (_sFileName.equals("Menu.jpg")) {
                    gamMenu.updateState(0);
                    System.out.println("Hit Menu");
                } else if (_sFileName.equals("Play.jpg")) {
                    gamMenu.updateState(1);
                    System.out.println("Hit Play");
                } else if (_sFileName.equals("Quit.jpg")) {
                    gamMenu.updateState(2);
                    System.out.println("Hit Quit");
                } else if (_sFileName.equals("Tools.jpg")) {
                    gamMenu.updateState(3);
                    System.out.println("Hit Tools");
                }
            }
        }
        return false;
    }
}
