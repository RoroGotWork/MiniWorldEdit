package fr.rorocraft.miniwe.events;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.Region;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private MiniWorldEdit plugin;


    public PlayerQuitListener(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        RegionManager regionManager = plugin.getRegionManager();

        if(regionManager.hasRegion(player)){
            Region region = regionManager.findRegionByPlayer(player);
            regionManager.removeRegion(region);
        }

    }
}
