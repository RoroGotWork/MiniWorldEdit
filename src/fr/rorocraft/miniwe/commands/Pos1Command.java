package fr.rorocraft.miniwe.commands;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Pos1Command implements CommandExecutor {
    private MiniWorldEdit plugin;


    public Pos1Command(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        Location pos1 = player.getLocation();

        RegionManager regionManager = plugin.getRegionManager();


        regionManager.addPos1(player, pos1);
        return false;
    }


}
