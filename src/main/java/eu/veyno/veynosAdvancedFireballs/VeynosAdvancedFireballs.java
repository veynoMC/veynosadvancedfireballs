package eu.veyno.veynosAdvancedFireballs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class VeynosAdvancedFireballs extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new FireballManager(), this);
        getCommand("fireballexplosionsize").setExecutor(new FireballExplosionSizeCommand());
        getCommand("fireballexplosionsize").setTabCompleter(new FireballExplosionSizeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
