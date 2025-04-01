package eu.veyno.veynosAdvancedFireballs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class FireballExplosionSizeCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command,  String s,  String [] strings) {
        int newRad = Integer.parseInt(strings[0]);
        commandSender.sendMessage("New fireball explosion radius set to: " + newRad);
        FireballManager.size = newRad;
        return true;
    }

    @Override
    public  List<String> onTabComplete( CommandSender commandSender,  Command command,  String s,  String  [] strings) {
        List<String> completions = new ArrayList<>();
        if(strings.length==1){
            completions.add("[radius]");
            return completions;
        }
        return List.of();
    }
}
