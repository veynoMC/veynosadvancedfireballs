package eu.veyno.veynosAdvancedFireballs;


import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.regions.EllipsoidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.*;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


import java.util.Random;

public class FireballManager implements Listener {

    public static int size = 3;

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e){
        if(!(e.getPlayer().getItemInHand().getType()== Material.FIRE_CHARGE)) return;
        e.setCancelled(true);
        Player p = e.getPlayer();
        if(p.getGameMode()!= GameMode.CREATIVE&&p.getGameMode()!= GameMode.SPECTATOR) {
            ItemStack itemInHand = p.getItemInHand();
            p.getItemInHand().setAmount(itemInHand.getAmount()-1);
        }
        FireballLauncher.shootFireball(p.getLocation().add(0,1,0),p.getLocation().getDirection());
    }

    public void asyncExplosion(Location loc, int radius) {
        Random random = new Random();
        Bukkit.getScheduler().runTaskAsynchronously(VeynosAdvancedFireballs.instance, () -> {
            World world = loc.getWorld();
            if (world == null) return;
            try (EditSession editSession = WorldEdit.getInstance().newEditSession(BukkitAdapter.adapt(world))) {
                BlockVector3 center = BukkitAdapter.asBlockVector(loc);
                Region sphere = new EllipsoidRegion(center, Vector3.at(radius, radius, radius));
                for (BlockVector3 block : sphere) {
                    double distance = center.distance(block);
                    BlockState air = BlockTypes.AIR.getDefaultState();
                    if(random.nextDouble() < 0.001) continue;
                    if (distance < radius * 0.25) {
                        editSession.setBlock(block, air);

                    }
                    else if (distance < radius * 0.35) {
                        if((random.nextDouble() < 0.80)){
                            editSession.setBlock(block, air);
                        }
                        else{
                            if(!(editSession.getBlock(block).getStates().isEmpty())){
                                if(random.nextDouble()< 0.3) {
                                    editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                                }
                            }
                        }
                        if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                            if(random.nextDouble()< 0.03) {
                                editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                            }
                        }

                    }
                    else if (distance < radius * 0.4) {
                        if((random.nextDouble() < 0.85)){
                            editSession.setBlock(block, air);
                        }
                        if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                            if(random.nextDouble()< 0.2) {
                                editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                            }
                        }
                    }
                    else if (distance < radius * 0.45) {
                        if((random.nextDouble() < 0.7)){
                            editSession.setBlock(block, air);
                        }
                        if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                            if(random.nextDouble()< 0.1) {
                                editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                            }
                        }
                    }
                    else if (distance < radius * 0.6) {
                        if((random.nextDouble() < 0.40)){
                            editSession.setBlock(block, air);
                        }

                        if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                            if(random.nextDouble()< 0.01) {
                                editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                            }
                        }
                    }
                    else if (distance < radius * 0.8) {
                        if((random.nextDouble() < 0.10)){
                            editSession.setBlock(block, air);
                        }
                        if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                            if(random.nextDouble()< 0.005) {
                                editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                            }
                        }
                    }
                    else {
                        if((random.nextDouble() < 0.03)){
                            editSession.setBlock(block, air);
                        }
                        else{
                            if(!(editSession.getBlock(block.add(0,-1,0)).getStates().isEmpty())){
                                if(random.nextDouble()< 0.001) {
                                    editSession.setBlock(block.add(0,1,0), BlockTypes.FIRE.getDefaultState());
                                }
                            }
                        }
                    }
                }

                editSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Fireball fireball) {
            if (fireball.hasMetadata("custom_explosion")) {
                Location loc = fireball.getLocation();
                asyncExplosion(loc, size);
            }
        }
    }

}
