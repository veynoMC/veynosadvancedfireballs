package eu.veyno.veynosAdvancedFireballs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Fireball;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class FireballLauncher {
    public static void shootFireball(Location location, Vector direction) {
        World world = location.getWorld();
        if (world == null) return;
        Fireball fireball = world.spawn(location, Fireball.class);
        fireball.setDirection(direction);
        fireball.setYield(1);
        fireball.setIsIncendiary(false);
        fireball.setMetadata("custom_explosion", new FixedMetadataValue(    VeynosAdvancedFireballs.instance, true));
    }

}
