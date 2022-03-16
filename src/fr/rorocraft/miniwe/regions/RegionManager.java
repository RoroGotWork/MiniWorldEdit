package fr.rorocraft.miniwe.regions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RegionManager {

    public List<Region> regions;

    public RegionManager() {
        this.regions = new ArrayList<>();
    }

    private void createRegion(Player player, Location loc1, Location loc2){
        Region region = new Region(player);
        region.addPos1(loc1);
        region.addPos2(loc2);

        regions.add(region);
    }

    public void addPos1(Player player,Location loc){
        if(!hasRegion(player)){
            createRegion(player, loc, null);

        } else {
            Region region = findRegionByPlayer(player);
            region.addPos1(loc);
        }
        player.sendMessage("Position 1 is set");
    }

    public void addPos2(Player player, Location loc){
        if(!hasRegion(player)){
            createRegion(player, null, loc);

        } else {
            Region region = findRegionByPlayer(player);
            region.addPos2(loc);
        }

        player.sendMessage("Position 2 is set");

    }

    public boolean hasRegion(Player player){
        return findRegionByPlayer(player) != null;
    }

    public Region findRegionByPlayer(Player player){
        if(regions.size() == 0) return  null;

        for(Region region : regions){
            if (region.getPlayer() == player){
                return  region;
            }
        }
        return null;
    }

    public void  removeRegion(Region region){
            regions.remove(region);
    }

    public void setBlocks(Player player, String item){
        Material type = Material.matchMaterial(item);


        if( type == null){
            player.sendMessage("Item called '" + item + "' doesn't exists");
            return;
        }

        ItemStack itemStack = new ItemStack(type);

        Region region = findRegionByPlayer(player);

        if( region == null){
            player.sendMessage("You don't have any region");
            return;
        }



        if(!region.areLocationSet()){
            player.sendMessage("You didn't set the positions");
            return;
        }



        if(!itemStack.getType().isBlock()){
            player.sendMessage("This item is not a block");
            return;
        }

        Location pos1 = region.getPos1();
        Location pos2 = region.getPos2();

        int x1 = (int) region.getPos1().getX();
        int x2 = (int) region.getPos2().getX();

        int y1 = (int) region.getPos1().getY();
        int y2 = (int) region.getPos2().getY();

        int z1 = (int) region.getPos1().getZ();
        int z2 = (int) region.getPos2().getZ();


        if(pos2.getX() < pos1.getX()){
            x1 = (int) region.getPos2().getX();
            x2 = (int) region.getPos1().getX();
        }

        if(pos2.getY() < pos1.getY()){
            y1 = (int) region.getPos2().getY();
            y2 = (int) region.getPos1().getY();
        }

        if(pos2.getZ() < pos1.getZ()){
            z1 = (int) region.getPos2().getZ();
            z2 = (int) region.getPos1().getZ();
        }



        for(int y = y1; y <= y2 + 1; y++){

            for(int x = x1 - 1; x < x2; x++){

                for(int z = z1 - 1; z < z2 ; z++) {


                    Location loc = new Location(region.getWorld(), x, y, z);
                    loc.getBlock().setType(itemStack.getType());

                }
            }



        }

        player.sendMessage("Done !");



    }

    public void cutBlocks(Player player){


        Region region = findRegionByPlayer(player);

        if( region == null){
            player.sendMessage("You don't have any region");
            return;
        }

        if(!region.areLocationSet()){
            player.sendMessage("You didn't set the positions");
            return;
        }


        Location pos1 = region.getPos1();
        Location pos2 = region.getPos2();

        int x1 = (int) region.getPos1().getX();
        int x2 = (int) region.getPos2().getX();

        int y1 = (int) region.getPos1().getY();
        int y2 = (int) region.getPos2().getY();

        int z1 = (int) region.getPos1().getZ();
        int z2 = (int) region.getPos2().getZ();


        if(pos2.getX() < pos1.getX()){
            x1 = (int) region.getPos2().getX();
            x2 = (int) region.getPos1().getX();
        }

        if(pos2.getY() < pos1.getY()){
            y1 = (int) region.getPos2().getY();
            y2 = (int) region.getPos1().getY();
        }

        if(pos2.getZ() < pos1.getZ()){
            z1 = (int) region.getPos2().getZ();
            z2 = (int) region.getPos1().getZ();
        }



        for(int y = y1; y <= y2 + 1; y++){

            for(int x = x1 - 1; x < x2; x++){

                for(int z = z1 - 1; z < z2; z++) {


                    Location loc = new Location(region.getWorld(), x, y, z);
                    loc.getBlock().setType(Material.AIR);

                }
            }



        }

        player.sendMessage("Done !");


    }

    public void replaceBlock(Player player, String block1, String block2){
        Material type1 = Material.matchMaterial(block1);
        Material type2 = Material.matchMaterial(block2);


        if( type1 == null){
            player.sendMessage("Item called '" + block1 + "' doesn't exists");
            return;
        }

        if(type2 == null){
            player.sendMessage("Item called '" + block2 + "' doesn't exists");
            return;
        }

        ItemStack itemStack1 = new ItemStack(type1);
        ItemStack itemStack2 = new ItemStack(type2);

        Region region = findRegionByPlayer(player);

        if( region == null){
            player.sendMessage("You don't have any region");
            return;
        }



        if(!region.areLocationSet()){
            player.sendMessage("You didn't set the positions");
            return;
        }



        if(!itemStack1.getType().isBlock() ||!(itemStack2.getType().isBlock())){
            player.sendMessage("One of those items is not a block");
            return;
        }


        Location pos1 = region.getPos1();
        Location pos2 = region.getPos2();

        int x1 = (int) region.getPos1().getX();
        int x2 = (int) region.getPos2().getX();

        int y1 = (int) region.getPos1().getY();
        int y2 = (int) region.getPos2().getY();

        int z1 = (int) region.getPos1().getZ();
        int z2 = (int) region.getPos2().getZ();


        if(pos2.getX() < pos1.getX()){
            x1 = (int) region.getPos2().getX();
            x2 = (int) region.getPos1().getX();
        }

        if(pos2.getY() < pos1.getY()){
            y1 = (int) region.getPos2().getY();
            y2 = (int) region.getPos1().getY();
        }

        if(pos2.getZ() < pos1.getZ()){
            z1 = (int) region.getPos2().getZ();
            z2 = (int) region.getPos1().getZ();
        }



        for(int y = y1; y <= y2 + 1; y++){

            for(int x = x1 - 1; x < x2; x++){

                for(int z = z1 - 1; z < z2 ; z++) {


                    Location loc = new Location(region.getWorld(), x, y, z);

                    if(loc.getBlock().getType() == itemStack1.getType()) {
                        loc.getBlock().setType(itemStack2.getType());
                    }

                }
            }



        }

        player.sendMessage("Done !");

    }


}
