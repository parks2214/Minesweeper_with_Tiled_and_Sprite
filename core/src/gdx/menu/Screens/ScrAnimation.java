package gdx.menu.Screens;

import com.minesweeper.Screens.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import gdx.menu.GamMenu;

public class ScrAnimation implements Screen, InputProcessor {
    Button btnMenu, btnQuit;
    GamMenu gamMenu;
    OrthographicCamera oc;
    Texture txButtonM, txButtonQ, txNamT;
    TextureRegion trTemp;
    Sprite sprButtonMenu, sprButtonQuit, sprNamT, sprDude;
    SpriteBatch batch;
    Animation araniDude[];
    int nFrame;
    
    public ScrAnimation(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        btnMenu = new Button(100, 50, 0, Gdx.graphics.getHeight() - 50, "Menu.jpg");
        btnQuit = new Button(100, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 50, "Quit.jpg");
        txNamT = new Texture("T.jpg");
        sprNamT = new Sprite(txNamT);
        sprNamT.setFlip(false, true);
        sprNamT.setSize(60, 80);
        sprNamT.setPosition(Gdx.graphics.getWidth()/2 - 30, Gdx.graphics.getHeight()/2 - 40);
        //Animation Stuff
        float fW, fH;
        Texture txSheet = new Texture("AniTest.png");
        fW = txSheet.getWidth() / 3;
        fH = txSheet.getHeight() / 4;
        for (int i = 0; i < 4; i++) {
            Sprite[] arsprAni = new Sprite[4];
            for (int j = 0; j < 3; j++) {
                float fSx = j * fW;
                float fSy = j * fH;
                sprDude = new Sprite(txSheet);
                sprDude.setPosition(fSx, fSy);
                sprDude.setScale(fSx, fSy);
                arsprAni[j] = new Sprite(sprDude);
                if(i == 0 && j == 0){
                    Sprite sprFront = new Sprite(sprDude);
                } else if(i == 1 && j == 0){
                    Sprite sprBack = new Sprite(sprDude);
                } else if(i == 2 && j == 0){
                    Sprite sprLeft = new Sprite(sprDude);
                } else if(i == 3 && j == 0){
                    Sprite sprRight = new Sprite(sprDude);
                }
            }
            araniDude[i] = new Animation(7f, arsprAni);
        }
        
        
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1); //Cyan background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        nFrame++;
        if(nFrame > 28){
            nFrame = 0;
        }
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        btnMenu.draw(batch);
        btnQuit.draw(batch);
        sprNamT.draw(batch);
        trTemp = araniDude[0].getKeyFrame(nFrame, true);
        batch.end();
    }
    
    public void Movement(){
        
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        txNamT.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            //System.out.println(screenX +" " + screenY);
            if (isHit(screenX, screenY, btnMenu)) {
                gamMenu.updateState(0);
                System.out.println("Hit Menu");
            } else if (isHit(screenX, screenY, btnQuit)) {
                gamMenu.updateState(2);
                System.out.println("Hit Quit");
            } else {
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    public boolean isHit(int nX, int nY, Sprite sprBtn) {
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}
