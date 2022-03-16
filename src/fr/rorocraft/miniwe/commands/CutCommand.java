package fr.rorocraft.miniwe.commands;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CutCommand implements CommandExecutor {

    private final MiniWorldEdit plugin;

    public CutCommand(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player) ) return true;

        Player player = (Player) commandSender;

        RegionManager regionManager = plugin.getRegionManager();
        regionManager.cutBlocks(player);
        return false;
    }
}
