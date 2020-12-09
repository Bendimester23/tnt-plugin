package hu.bendi.randomstuff.mashines;

import hu.bendi.randomstuff.util.Ingredients;
import hu.bendi.randomstuff.util.Items;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Material.*;

public class Grinder {
    public static void process(PlayerInteractEvent e) {
        switch (e.getItem().getType()) {
            case BRICK:
                if (e.getItem().getItemMeta().getCustomModelData() == 61) return;
                e.getPlayer().getInventory().removeItem(Ingredients.RUSTY_IRON);
                e.getPlayer().getInventory().addItem(Ingredients.RUST);
                e.getPlayer().getInventory().addItem(new ItemStack(IRON_NUGGET,8));
                e.getPlayer().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_GRINDSTONE_USE,100,100);
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(COCOA);
                e.getClickedBlock().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getClickedBlock().getLocation(), 10, e.getClickedBlock().getWorld().getBlockAt(0,0,0).getBlockData());
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(BEDROCK);
                break;
            case IRON_INGOT:
                e.getPlayer().getInventory().removeItem(Items.IRON_INGOT);
                e.getPlayer().getInventory().addItem(Ingredients.IRON_DUST);
                e.getPlayer().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_GRINDSTONE_USE,100,100);
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(IRON_BLOCK);
                e.getClickedBlock().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getClickedBlock().getLocation(), 10, e.getClickedBlock().getWorld().getBlockAt(0,0,0).getBlockData());
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(BEDROCK);
                break;
            case GUNPOWDER:
                if (Objects.requireNonNull(e.getItem().getItemMeta()).hasCustomModelData()) return;
                e.getPlayer().getInventory().removeItem(Items.GUNPOWDER);
                e.getPlayer().getInventory().addItem( Ingredients.FINE_GUNPOWDER, Ingredients.FINE_GUNPOWDER);
                e.getPlayer().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_GRINDSTONE_USE,100,100);
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(IRON_BLOCK);
                e.getClickedBlock().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getClickedBlock().getLocation(), 10, e.getClickedBlock().getWorld().getBlockAt(0,0,0).getBlockData());
                e.getClickedBlock().getWorld().getBlockAt(0,0,0).setType(BEDROCK);
                break;
        }
        e.setCancelled(true);
    }
}
