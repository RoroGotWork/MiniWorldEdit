package fr.rorocraft.miniwe.regions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Region {
    private Player player;

    private Location loc1;
    private Location loc2;



    public Region(Player player) {
        this.player = player;

        loc1 = null;
        loc2 = null;

    }


    public void addPos1(Location location){
        loc1 = location;
    }

    public void addPos2(Location location){
        loc2 = location;
    }

    public World getWorld(){
        return loc1.getWorld();
    }

    public Location getPos1(){
        return loc1;
    }

    public Location getPos2(){
        return loc2;
    }

    public boolean areLocationSet(){
        return loc1 != null & loc2 != null;
    }



    public Player getPlayer(){
        return player;
    }


}
