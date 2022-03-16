package fr.rorocraft.miniwe.commands;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {
    private MiniWorldEdit plugin;


    public SetCommand(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;

        if(args.length < 1) {
            player.sendMessage("/set {block}");
            return true;
        }

        RegionManager regionManager = plugin.getRegionManager();

        String blockName = args[0];
        regionManager.setBlocks(player, blockName);


        return false;
    }
}
