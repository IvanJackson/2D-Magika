package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

import java.awt.*;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Door extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    private BaseWorld world;

    public Door(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 64, 100);
        this.world=world;
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {

        if(isBeinghurt()){
            setHealth(10000000);
        }

        if(handler.getKeyManager().attbut){
            EP=true;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }

    }

    @Override
    
    public void render(Graphics g) {
    	if(visible) {
    		g.drawImage(Images.door,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    		g.setColor(Color.black);
    		checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    	} 
    }

	private void checkForPlayer(Graphics g, Player p) {
    	if(visible) {
	        Rectangle pr = p.getCollisionBounds(0,0);
	
	        if(ir.contains(pr) && !EP){
	            g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
	        }else if(ir.contains(pr) && EP){
	            g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
	            g.drawImage(Images.loading,0,0,800,600,null);
	            try {
					Thread.sleep(120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            handler.setWorld(world);
	        }
	        visible = false;
    	}
    }

    @Override
    public void die() {

    }
}
