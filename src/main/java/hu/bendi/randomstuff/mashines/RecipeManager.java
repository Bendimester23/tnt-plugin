package hu.bendi.randomstuff.mashines;

import hu.bendi.randomstuff.tnt.Tnts;
import hu.bendi.randomstuff.util.Ingredients;
import hu.bendi.randomstuff.util.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RecipeManager {

    public static Recipe COMPRESSED_TNT;
    public static Recipe BUILDER_TNT;

    static {
        COMPRESSED_TNT = new Recipe(new ItemStack[][]
                {
                        {Ingredients.GLUE, Items.OBSIDIAN, Items.PISTON,       Items.PISTON,        Items.OBSIDIAN, Ingredients.GLUE},
                        {Items.OBSIDIAN,   Items.TNT,      Items.TNT,          Items.TNT,           Items.TNT,      Items.OBSIDIAN},
                        {Items.PISTON,     Items.TNT,      Ingredients.GLUE,   Ingredients.TERMIT,  Items.TNT,      Items.PISTON},
                        {Items.PISTON,     Items.TNT,      Ingredients.TERMIT, Ingredients.GLUE,    Items.TNT,      Items.PISTON},
                        {Items.OBSIDIAN,   Items.TNT,      Items.TNT,          Items.TNT,           Items.TNT,      Items.OBSIDIAN},
                        {Ingredients.GLUE, Items.OBSIDIAN, Items.PISTON,       Items.PISTON,        Items.OBSIDIAN, Ingredients.GLUE}
                },
                Tnts.COMPRESSED_TNT);

        BUILDER_TNT = new Recipe(new ItemStack[][]
                {
                        {Items.RED_CONCRETE,   Items.RED_CONCRETE, Items.RED_CONCRETE, Items.RED_CONCRETE,  Items.RED_CONCRETE, Items.RED_CONCRETE},
                        {Items.RED_CONCRETE,   Items.STONE,        Items.STONE,        Items.STONE,         Items.STONE,        Items.RED_CONCRETE},
                        {Items.WHITE_CONCRETE, Items.STONE,        Items.TNT,          Items.TNT,           Items.STONE,        Items.WHITE_CONCRETE},
                        {Items.WHITE_CONCRETE, Items.STONE,        Items.TNT,          Items.TNT,           Items.STONE,        Items.WHITE_CONCRETE},
                        {Items.RED_CONCRETE,   Items.STONE,        Items.STONE,        Items.STONE,         Items.STONE,        Items.RED_CONCRETE},
                        {Items.RED_CONCRETE,   Items.RED_CONCRETE, Items.RED_CONCRETE, Items.RED_CONCRETE,  Items.RED_CONCRETE, Items.RED_CONCRETE}
                },
                Tnts.BUILDER_TNT);
    }

    public static ItemStack getResult(ItemStack[][] items) {
        if (isSame(items,COMPRESSED_TNT.stacks)) return COMPRESSED_TNT.result;
        return new ItemStack(Material.AIR);
    }

    public static boolean isSame(ItemStack[][] a, ItemStack[][] b) {
        if (a.length != b.length) return false;
        for (int i =0; i<a.length;i++) {
            for (int x =0; x<a.length;x++) {
                if (a[i][x] == null || b[i][x] == null) return false;
                if (!a[i][x].equals(b[i][x])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Recipe {
        ItemStack[][] stacks;
        ItemStack result;

        public Recipe(ItemStack[][] stacks, ItemStack result) {
            this.stacks = stacks;
            this.result = result;
        }
    }
}
