package Worlds;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

public class World2 extends BaseWorld{
    private Handler handler;
    private Player player;

    public World2(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;

        entityManager.addEntity(new SkelyEnemy(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.getPlayer().setX(800);
        entityManager.getPlayer().setY(800);
    }
}