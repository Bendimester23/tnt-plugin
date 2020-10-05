package hu.bendi.randomstuff.tnt;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tnts {

    public static ItemStack COMPRESSED_TNT = new ItemStack(Material.TNT);

    static {
        ItemMeta im = COMPRESSED_TNT.getItemMeta();
        if (im != null) {
            im.setDisplayName((ChatColor.RESET+"")+ChatColor.BOLD+ChatColor.RED+"Ultimate Tnt");
            im.setCustomModelData(30);
            im.addEnchant(Enchantment.DURABILITY,10,true);
            COMPRESSED_TNT.setItemMeta(im);
        }
    }
}
