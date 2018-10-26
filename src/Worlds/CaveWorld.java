package Worlds;
import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private BaseWorld world2;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
    
        world2 = new World2(handler,"res/Maps/map2.map",player);
        
        entityManager.addEntity(new Door(handler, 100, 0,world2));
        entityManager.addEntity(new SlimeEnemy(handler, 500, 200));
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        entityManager.addEntity(new Humanoid(handler, 600,50));

    }


}