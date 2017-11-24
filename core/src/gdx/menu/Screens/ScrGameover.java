package gdx.menu.Screens;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import gdx.menu.GamMenu;



public class ScrGameover implements Screen, InputProcessor {
    OrthographicCamera oc;
    Texture txButtonM, txButtonP;
    GamMenu gamMenu;
    SpriteBatch batch;
    Sprite sprButtonMenu, sprButtonPlay;
    
    public ScrGameover(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        txButtonP = new Texture("Play.jpg");
        txButtonM = new Texture("Menu.jpg");
        sprButtonPlay = new Sprite(txButtonP);
        sprButtonPlay.setFlip(false, true);
        sprButtonPlay.setY(Gdx.graphics.getHeight()-sprButtonPlay.getHeight());
        sprButtonMenu = new Sprite(txButtonM);
        sprButtonMenu.setFlip(false, true);
        sprButtonMenu.setX(Gdx.graphics.getWidth()-sprButtonMenu.getWidth());
        sprButtonMenu.setY(Gdx.graphics.getHeight()-sprButtonMenu.getHeight());
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void render(float Delta) {
        Gdx.gl.glClearColor(0, 1, 1, 1); //Cyan background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        sprButtonPlay.draw(batch);
        sprButtonMenu.draw(batch);
        batch.end();
    }
    
    /*
     * UpdateState(0) for Menu
     * UpdateState(1) for Play
     */
    
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
        txButtonM.dispose();
        txButtonP.dispose();
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
			if (isHit(screenX, screenY, sprButtonPlay)) {
                            gamMenu.updateState(1);
                            System.out.println("Hit Play");
                        } else if(isHit(screenX, screenY, sprButtonMenu)){
                            gamMenu.updateState(0);
                            System.out.println("Hit Menu");
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
    public boolean isHit(int nX, int nY, Sprite sprBtn){
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}    
