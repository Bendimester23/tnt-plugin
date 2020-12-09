package hu.bendi.randomstuff.tnt;

import hu.bendi.randomstuff.util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Tnts {

    public static ItemStack COMPRESSED_TNT = new ItemBuilder()
            .createItem(Material.TNT)
            .addEnchant(Enchantment.DURABILITY, 10)
            .hideEnchants()
            .setCustomModelData(30)
            .setName(ChatColor.RED + "Ultimate Tnt")
            .build();

    public static ItemStack BUILDER_TNT = new ItemBuilder()
            .createItem(Material.TNT)
            .addEnchant(Enchantment.DURABILITY, 10)
            .hideEnchants()
            .setCustomModelData(31)
            .setName(ChatColor.RED + "Builder Tnt")
            .build();


}
