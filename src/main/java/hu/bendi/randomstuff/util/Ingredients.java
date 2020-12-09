package hu.bendi.randomstuff.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Ingredients {

    public static ItemStack TERMIT = new ItemBuilder().createItem(Material.GUNPOWDER)
            .setName(ChatColor.RESET+"Termit")
            .setCustomModelData(11)
            .build();

    public static ItemStack GLUE = new ItemBuilder().createItem(Material.QUARTZ)
            .setName(ChatColor.RESET+"Glue")
            .setCustomModelData(12)
            .build();

    public static ItemStack RUSTY_IRON = new ItemBuilder().createItem(Material.BRICK)
            .setName("Rusty Iron")
            .setCustomModelData(60)
            .build();

    public static ItemStack RUST = new ItemBuilder().createItem(Material.BROWN_DYE)
            .setName("Rust")
            .setCustomModelData(61)
            .build();

    public static ItemStack IRON_DUST = new ItemBuilder().createItem(Material.GUNPOWDER)
            .setName("Iron Dust")
            .setCustomModelData(62)
            .build();

    public static ItemStack FINE_GUNPOWDER = new ItemBuilder().createItem(Material.GUNPOWDER)
            .setName("Fine Gunpowder")
            .setCustomModelData(63)
            .build();
}
