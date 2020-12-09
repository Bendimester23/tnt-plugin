package hu.bendi.randomstuff.listener;

import hu.bendi.randomstuff.mashines.Grinder;
import hu.bendi.randomstuff.mashines.PyroWorkshop;
import hu.bendi.randomstuff.util.Ingredients;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;

import static org.bukkit.Material.BLAST_FURNACE;
import static org.bukkit.Material.IRON_INGOT;

public class MutiblockListener implements Listener {

    public static HashMap<Location,DataHolder> save = new HashMap<>();

    @EventHandler
    public void use(PlayerInteractEvent e) {
        Block b = e.getClickedBlock();
        if (b == null) return;
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        switch (b.getType()) {
            case SMITHING_TABLE:
                if (b.getRelative(0,-1,0).getType() != BLAST_FURNACE) return;
                e.setCancelled(true);
                new PyroWorkshop().openWorkshop(e.getPlayer(),b.getLocation());
                break;
            case CAULDRON:
                if (!e.hasItem()) return;
                if (Objects.requireNonNull(e.getItem()).getType() != IRON_INGOT) return;
                Levelled l = (Levelled) b.getState().getBlockData();
                if (l.getLevel() == 0) return;
                l.setLevel(l.getLevel()-1);
                b.setBlockData(l);
                e.getPlayer().getInventory().removeItem(new ItemStack(IRON_INGOT));
                e.getPlayer().getInventory().addItem(Ingredients.RUSTY_IRON);
                e.getPlayer().getWorld().playSound(b.getLocation(), Sound.AMBIENT_UNDERWATER_ENTER,100,100);
                b.getWorld().spawnParticle(Particle.WATER_SPLASH,b.getLocation(),10);
                break;
            case GRINDSTONE:
                if (!e.hasItem()) return;
                Grinder.process(e);
                break;
        }

    }

    public static class DataHolder {
        public ItemStack[][] items = new ItemStack[6][6];
    }
}
