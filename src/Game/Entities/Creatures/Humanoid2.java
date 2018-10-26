package Game.Entities.Creatures;

import Main.Handler;
import Resources.Animation;
import Resources.Images;
import Worlds.*;
import Game.*;
import Game.Entities.Statics.Door;

import java.awt.*;

/**
 * Created by Elemental on 2/7/2017.
 */
public class Humanoid2 extends CreatureBase  {


    private Animation animDown, animUp, animLeft, animRight;

    boolean done = false;
	int neededKeys = 2;
    int neededCoins = 10;
    int woodNeeded = 15;
    int rocksNeeded = 10;
    private int animWalkingSpeed = 150;

    public Humanoid2(Handler handler, float x, float y) {
        super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
        speed=1.5f;
        health=99999999;
        animDown = new Animation(animWalkingSpeed, Images.player_front);
        animLeft = new Animation(animWalkingSpeed,Images.player_left);
        animRight = new Animation(animWalkingSpeed,Images.player_right);
        animUp = new Animation(animWalkingSpeed,Images.player_back);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(animDown,animUp,animLeft,animRight,Images.player_front,Images.player_back,Images.player_left,Images.player_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setFont(new Font("Times", Font.PLAIN,15));
        g.setColor(Color.white);
        if(isBeinghurt()){
        	if(this.neededKeys == 0 && this.neededCoins == 0 && this.rocksNeeded == 0 && this.woodNeeded == 0) {
    			done = true;
    		}
        	if (!this.done) {
                g.drawString("To move on to the final world, you must bring me the following items:",(int) (x-handler.getGameCamera().getxOffset()-200),(int) (y-handler.getGameCamera().getyOffset()-20));
                g.drawString("Keys: "+neededKeys,(int) (x-handler.getGameCamera().getxOffset()-200),(int) (y-handler.getGameCamera().getyOffset()));
                g.drawString("Coins: "+neededCoins,(int) (x-handler.getGameCamera().getxOffset()-125),(int) (y-handler.getGameCamera().getyOffset()));
                g.drawString("Wood: "+woodNeeded,(int) (x-handler.getGameCamera().getxOffset()-50),(int) (y-handler.getGameCamera().getyOffset()));
                g.drawString("Rocks: "+rocksNeeded,(int) (x-handler.getGameCamera().getxOffset()+25),(int) (y-handler.getGameCamera().getyOffset()));
                if(this.neededKeys > 0) {
                	this.neededKeys-=handler.getWorld().getEntityManager().getPlayer().getInventory().removeItems(4);
	                if(this.neededKeys < 0) {
	                  this.neededKeys = 0;
	                }
                }
                if(this.neededCoins > 0) {
                	this.neededCoins-=handler.getWorld().getEntityManager().getPlayer().getInventory().removeItems(3);
	                if(this.neededCoins < 0) {
	                  this.neededCoins = 0;
	                }
                }
                if(this.woodNeeded > 0) {
                	this.woodNeeded-=handler.getWorld().getEntityManager().getPlayer().getInventory().removeItems(0);
	                if(this.woodNeeded < 0) {
	                  this.woodNeeded = 0;
	                }
                }
                if(this.rocksNeeded > 0) {
                	this.rocksNeeded-=handler.getWorld().getEntityManager().getPlayer().getInventory().removeItems(1);
	                if(this.rocksNeeded < 0) {
	                  this.rocksNeeded = 0;
	                }
                }
        	}
        	else {
                g.drawString("You may now procede to the next world.",(int) (x-handler.getGameCamera().getxOffset()-200),(int) (y-handler.getGameCamera().getyOffset()-20));
               Door.visible=true;
        	}
        }
    }

	@Override
	public void die() {
		
	}
}
