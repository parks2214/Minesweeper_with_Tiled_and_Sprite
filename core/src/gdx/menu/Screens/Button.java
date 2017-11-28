package gdx.menu.Screens;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;

public class Button extends Sprite{
    
    public Button(int nW, int nH, int nX, int nY, Texture txBtn){
        Sprite sprBtn = new Sprite(txBtn);
        sprBtn.setX(nX);
        sprBtn.setY(nY);
        sprBtn.setSize(nW, nH);
        sprBtn.setFlip(false, true);
        
    }
    
    
    
}
