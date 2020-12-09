package hu.bendi.randomstuff.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class ItemBuilder {

    private ItemStack result;
    private ItemMeta im;

    public ItemBuilder createItem() {
        result = new ItemStack(Material.AIR);
        im = result.getItemMeta();
        return this;
    }

    public ItemBuilder createItem(Material material) {
        result = new ItemStack(material);
        im = result.getItemMeta();
        return this;
    }

    public ItemBuilder createItem(Material material, int count) {
        if (count >= 64) throw new IllegalArgumentException("Count must be below 64.");
        result = new ItemStack(material,count);
        im = result.getItemMeta();
        return this;
    }

    public ItemBuilder fromItem(ItemStack from) {
        result = from;
        im = result.getItemMeta();
        return this;
    }

    public ItemBuilder setMaterial(Material material) {
        result.setType(material);
        return this;
    }

    public ItemBuilder setCount(int count) {
        if (count >= 64) throw new IllegalArgumentException("Count must be below 64.");
        result.setAmount(count);
        return this;
    }

    public ItemBuilder setName(String name) {
        if (im == null) System.out.println("error");
        im.setDisplayName(ChatColor.RESET+name);
        return this;
    }

    public ItemBuilder addLore(String... lore) {
        Collections.addAll(im.getLore(),lore);
        return this;
    }

    public ItemBuilder hideEnchants() {
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        im.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder addEnchant(Enchantment ench,int lvl) {
        im.addEnchant(ench,lvl,true);
        return this;
    }

    public ItemBuilder setCustomModelData(int data) {
        im.setCustomModelData(data);
        return this;
    }

    public ItemStack build() {
        result.setItemMeta(im);
        return result;
    }
}

