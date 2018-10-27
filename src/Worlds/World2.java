

package Worlds;

import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Main.Handler;

public class World2 extends BaseWorld{
    private Handler handler;
    private Player player;

    public World2(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;

        entityManager.getPlayer().setX(100);
        entityManager.getPlayer().setY(100);
        entityManager.addEntity(new Companion(handler,50,50));
        entityManager.addEntity(new SlimeKing(handler, 100, 350));
        entityManager.addEntity(new Potion(handler, 150, 150));
        entityManager.addEntity(new Potion(handler, 60, 320));
        entityManager.addEntity(new Potion(handler, 400, 700));
        entityManager.addEntity(new Potion(handler, 200, 40));
        entityManager.addEntity(new Potion(handler, 300, 200));
        entityManager.addEntity(new Potion(handler, 400, 500));
        entityManager.addEntity(new Potion(handler, 500, 200));
        entityManager.addEntity(new Potion(handler, 600, 300));
    }
}