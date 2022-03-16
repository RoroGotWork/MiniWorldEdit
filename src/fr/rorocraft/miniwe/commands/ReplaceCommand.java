package fr.rorocraft.miniwe.commands;

import fr.rorocraft.miniwe.MiniWorldEdit;
import fr.rorocraft.miniwe.regions.RegionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplaceCommand implements CommandExecutor {

    private MiniWorldEdit plugin;

    public ReplaceCommand(MiniWorldEdit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;

        if(args.length < 2){
            player.sendMessage("/set {block to remove} {block to add}");
            return true;
        }

        String block1 = args[0];
        String block2 = args[1];

        RegionManager regionManager = plugin.getRegionManager();
        regionManager.replaceBlock(player, block1, block2);

        return false;
    }
}
