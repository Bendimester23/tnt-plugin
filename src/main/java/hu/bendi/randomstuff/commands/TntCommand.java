package hu.bendi.randomstuff.commands;

import hu.bendi.randomstuff.RandomPlugin;
import hu.bendi.randomstuff.util.Ingredients;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public class TntCommand implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player p = (Player) commandSender;
        p.getInventory().addItem(Ingredients.GLUE);
        p.getInventory().addItem(Ingredients.TERMIT);
        return true;
    }

    @EventHandler
    public void boom(ExplosionPrimeEvent event) {
        if (event.getEntity().hasMetadata("custom-tnt")) {
            switch (event.getEntity().getMetadata("custom-tnt").get(0).asInt()) {
                case 1:
                    oszdod(event.getEntity().getLocation());
                    break;
            }
        }
    }

    public void oszdod(Location loc) {
        for (int x = 0; x < 9; x++) {
            for (int z = 0;z < 9; z++) {
                int xx = x - 5;
                int zz = z - 5;
                Entity e = loc.getWorld().spawnEntity(new Location(loc.getWorld(),
                                loc.getX()+(xx*5),loc.getY()+5,loc.getZ()+(zz*5)),
                                EntityType.PRIMED_TNT);
            }
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() != Material.TNT) return;
        if (!Objects.requireNonNull(event.getItemInHand().getItemMeta()).hasCustomModelData()) return;
        if (event.getItemInHand().getItemMeta().getCustomModelData() != 30) return;
        event.getBlock().setType(Material.AIR);
        Entity e = event.getBlock().getLocation().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
        e.setMetadata("custom-tnt", new FixedMetadataValue(RandomPlugin.INSTANCE,1));
    }

    @EventHandler
    public void explode(EntityExplodeEvent event) {

    }

    @EventHandler
    public void ignite(BlockIgniteEvent event) {

    }

    @EventHandler
    public void chunkLoad(ChunkLoadEvent e) {
        if (!e.isNewChunk()) return;
        if (e.getChunk().getBlock(0,0,0).getBiome() != Biome.OCEAN) return;
        System.out.println("generate");
    }
}
