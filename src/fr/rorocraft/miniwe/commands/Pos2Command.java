package fr.rorocraft.miniwe.commands;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pos2Command implements CommandExecutor {
    private MiniWorldEdit plugin;


    public Pos2Command(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        Location pos2 = player.getLocation();

        RegionManager regionManager = plugin.getRegionManager();

        regionManager.addPos2(player, pos2);

        return false;
    }
}
