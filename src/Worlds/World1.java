package Worlds;
import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld{

    private BaseWorld caveWorld;
	public World1(Handler handler, String path, Player player){
        super(handler,path,player);
        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);

        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Tree(handler, 77, 700));
        entityManager.addEntity(new Rock(handler, 700, 83));
        entityManager.addEntity(new Door(handler, 100, 0,caveWorld));
        entityManager.addEntity(new SkelyEnemy(handler, 1250, 500));
        entityManager.addEntity(new SkelyEnemy(handler, 500, 500));
        entityManager.addEntity(new SkelyEnemy(handler, 200, 1200));
        entityManager.addEntity(new SkelyEnemy(handler, 1300, 1300));
        entityManager.addEntity(new MoneyBag(handler, 300, 300));
        entityManager.addEntity(new MoneyBag(handler, 320, 800));
        entityManager.addEntity(new MoneyBag(handler, 1200, 200));
        entityManager.addEntity(new Humanoid(handler, 600,50));
        entityManager.addEntity(new Potion(handler, 500, 200));
        entityManager.addEntity(new Potion(handler, 1000, 200));
        entityManager.addEntity(new Potion(handler, 750, 850));
        entityManager.addEntity(new Potion(handler, 500, 800));
        entityManager.addEntity(new Potion(handler, 100, 400));
        entityManager.addEntity(new Potion(handler, 1500, 1500));
        entityManager.addEntity(new Potion(handler, 60, 1000));
        entityManager.getPlayer().setX(100);
        entityManager.getPlayer().setY(100);
    }
}