package Game.Entities.Creatures;

import Game.Entities.EntityBase;
import Game.Inventories.Inventory;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.util.Random;

/**
 * Created by Elemental on 2/7/2017.
 */
public class Humanoid extends CreatureBase  {


    private Animation animDown, animUp, animLeft, animRight;

    private Boolean attacking=false;

    private int animWalkingSpeed = 150;
    private Inventory Skelyinventory;
    private Rectangle SkelyCam;

    private int healthcounter =0;

    private Random randint;
    private int moveCount=0;
    private int direction;

    public Humanoid(Handler handler, float x, float y) {
        super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
        speed=1.5f;
        health=50;

        SkelyCam= new Rectangle();



        randint = new Random();
        direction = randint.nextInt(4) + 1;

        animDown = new Animation(animWalkingSpeed, Images.player_front);
        animLeft = new Animation(animWalkingSpeed,Images.player_left);
        animRight = new Animation(animWalkingSpeed,Images.player_right);
        animUp = new Animation(animWalkingSpeed,Images.player_back);

        Skelyinventory= new Inventory(handler);
    }

    @Override
    public void tick() {
    	
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(animDown,animUp,animLeft,animRight,Images.player_front,Images.player_back,Images.player_left,Images.player_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        if(isBeinghurt() && healthcounter<=120){
            g.setColor(Color.white);
            g.drawString("SkelyHealth: " + getHealth(),(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()-20));
        }
    }

    @Override
    public void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(lu){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(ld){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(ll){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(lr){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else{
            return;
        }

        attackTimer = 0;

        for(EntityBase e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)){
//                System.out.println("You've got mail.");
                return;
            }
        }

    }
    @Override
    public void die() {

    }
}
