package hu.bendi.randomstuff.mashines;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CauldronThing implements ICrafterMachine {

    private CauldronData data;

    @Override
    public IOutputData craft(IInputData input) {
        return null;
    }

    public class CauldronInputData implements IInputData {
        public ItemStack item = new ItemStack(Material.AIR);
    }

    public class CauldronOutputData implements IOutputData {
        public ItemStack[] items = {new ItemStack(Material.AIR)};
    }

    public class CauldronData implements IMachineData {

        @Override
        public void apply(IInputData data) {

        }

        @Override
        public void apply(IOutputData data) {

        }
    }
}
