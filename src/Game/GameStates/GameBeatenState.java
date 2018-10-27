package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Elemental on 2/3/2017.
 */
public class GameBeatenState extends GameOverState {

    private UIManager uiManager;

    public GameBeatenState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(56, (223+(64+16))+(64+16), 128, 64, Images.BTitle, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.GameBeaten,0,0,800,600,null);
        uiManager.Render(g);

    }
}
