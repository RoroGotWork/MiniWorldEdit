package fr.rorocraft.miniwe;

import fr.rorocraft.miniwe.commands.*;
import fr.rorocraft.miniwe.events.PlayerQuitListener;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniWorldEdit extends JavaPlugin {
    private RegionManager regionManager;


    @Override
    public void onEnable() {

        this.regionManager = new RegionManager();
        registerCommands();
        registerEvents();

        System.out.println("[MiniWorldEdit] Plugin enabled");

    }


    @Override
    public void onDisable() {
        System.out.println("[MiniWorldEdit] Plugin disabled");

    }

    private void registerCommands(){
        this.getCommand("set").setExecutor(new SetCommand(this));
        this.getCommand("cut").setExecutor(new CutCommand(this));
        this.getCommand("replace").setExecutor(new ReplaceCommand(this));
        this.getCommand("pos1").setExecutor(new Pos1Command(this));
        this.getCommand("pos2").setExecutor(new Pos2Command(this));
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
    }

    public RegionManager getRegionManager(){
        return regionManager;
    }
}
