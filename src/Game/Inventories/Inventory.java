package Game.Inventories;

import Game.Items.Item;
import Game.SpellCast.FireBallSpell;
import Resources.Images;
import UI.UIInventory;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Elemental on 1/3/2017.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
    private UIManager uiManager;
    private ArrayList<Item> inventoryItems;
    public static boolean companionable;
	int quantity=0;

    public Inventory(Handler handler){

        this.handler=handler;
        inventoryItems = new ArrayList<>();

        uiManager = new UIManager(handler);

        uiManager.addObjects(new UIInventory(0,0, 329, 265, Images.inventory,() -> {
        }));
    }

    public void tick() {

        for(Item i : inventoryItems){
            if(i.getCount()==0){
                inventoryItems.remove(inventoryItems.indexOf(i));
                return;
            }
        }

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)){
            active=!active;
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().setActive(false);

        }

        if(!active){
            return;
        }

        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();



    }

	public void render(Graphics g) {

        if(!active){
            uiManager.isActive(uiManager.getObjects(),false);
            return;
        }



        uiManager.isActive(uiManager.getObjects(),true);
        uiManager.Render(g);
        g.setColor(Color.white);
        renderItems(g);

    }

    //Inventory Methods
    private void renderItems(Graphics g) {

    	for (int i =0;i<inventoryItems.size();i++) {
    		if(i<5) {
	    		 g.drawImage(inventoryItems.get(i).getTexture(), 22+(i*61), 24, inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
	             g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 22+(i*61)+33,25+35);
    		}
    		else {
    			g.drawImage(inventoryItems.get(i).getTexture(), 22+((i-5)*61), 85, inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
	             g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 22+((i-5)*61)+33,120);
    		}
    	}

    }

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        if(item.getId()==2){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new FireBallSpell(handler));
        }
        if (item.getId() == 6) {
        	companionable=true;
        }
        inventoryItems.add(item);
    }
    
    public int removeItems(int item) {
    	for(Item i:inventoryItems) {
    		if(i.getId()==item) {
    			if(i.getCount()>3) {
    				quantity = 3;
    			}
    			else {
    				quantity=i.getCount();
    			}
    			 i.setCount(i.getCount() - quantity);
    			if(i.getCount()<=0){
                    inventoryItems.remove(inventoryItems.indexOf(i));
                }
    			return quantity;
    		}
    	}
    	return 0;
    }

    //GET SET
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItems(){
        return inventoryItems;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public static boolean isCompanionable() {
		return companionable;
	}
}
