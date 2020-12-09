package hu.bendi.randomstuff.mashines;

import hu.bendi.randomstuff.RandomPlugin;
import hu.bendi.randomstuff.util.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import me.mattstudios.mfgui.gui.guis.PersistentGui;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class PyroWorkshop {

    public static HashMap<Location,PersistentGui> guis = new HashMap<>();

    public void openWorkshop(Player p, Location loc) {
        if (!guis.containsKey(loc)) {
            guis.put(loc, new PersistentGui(RandomPlugin.INSTANCE,6,"Pyrotechnic Workshop"));
        }
        PersistentGui gui = guis.get(loc);

        GuiItem blank = new GuiItem(new ItemBuilder()
        .createItem(Material.BLACK_STAINED_GLASS_PANE)
        .setName(" ")
        .build(),(e) -> e.setCancelled(true));

        for (int s = 0; s < 54; s++) {
            if (s%9 > 5) gui.setItem(s,blank);
        }

        GuiItem resultI = new GuiItem(new ItemStack(Material.AIR), (e) -> {
            if (e.getCursor() != null) e.setCancelled(true);
        });

        gui.setItem(25,resultI);

        gui.setDefaultClickAction((e) -> Bukkit.getScheduler().runTaskLaterAsynchronously(RandomPlugin.INSTANCE, () -> {
            if (e.getClickedInventory() == null) {
                System.out.println("null1");
                e.setCancelled(true);
                return;
            }
            if (e.getClickedInventory().getItem(e.getSlot()) == null) { System.out.println("null2"); e.setCancelled(true); return; }
            if (e.getClickedInventory().getItem(e.getSlot()).getType() == Material.AIR || e.getCursor().getType() == Material.AIR) { System.out.println("null3"); e.setCancelled(true); return; }
            ItemStack[][] itms = new ItemStack[6][6];

            itms[0] = new ItemStack[6];
            itms[1] = new ItemStack[6];
            itms[2] = new ItemStack[6];
            itms[3] = new ItemStack[6];
            itms[4] = new ItemStack[6];
            itms[5] = new ItemStack[6];

            ItemStack AIR = new ItemStack(Material.AIR);

            for (int x = 0; x <6;x++) {
                for (int y = 0; y<6;y++) {
                    if (gui.getInventory().getItem(x*9+y) == null) itms[x][y] = AIR;
                    else itms[x][y] = gui.getInventory().getItem(x*9+y);
                }
            }

            ItemStack res = RecipeManager.getResult(itms);
            boolean isDone;
            isDone = res.getType() != Material.AIR;

            if (!isDone) return;

            GuiItem i = new GuiItem(res,(ev)-> {
                p.getInventory().addItem(res);
                reset(gui, p);
            });
            gui.updateItem(3,8,i);
        }, 5));
        gui.open(p);
    }

    public void reset(PersistentGui gui, Player p) {
        GuiItem resultI = new GuiItem(new ItemStack(Material.AIR));
        for (int xx = 0; xx<6;xx++) {
            for (int yy = 0; yy<6;yy++) {
                gui.setItem(xx*9+yy,resultI);
            }
        }
        gui.setItem(25,resultI);
        try {
            gui.update();
        } catch (ConcurrentModificationException ignored) {}
    }

    public enum State {
        CRAFTING,
        DONE,
        CLAIMED
    }
}
