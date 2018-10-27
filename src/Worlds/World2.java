

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

        entityManager.addEntity(new SkelyEnemy(handler, 300, 300));
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.getPlayer().setX(100);
        entityManager.getPlayer().setY(100);
        entityManager.addEntity(new SlimeKing(handler, 100, 350));
    }
}