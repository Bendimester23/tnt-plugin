package hu.bendi.randomstuff.util;

public class CustomHead {

    //public static ItemStack CALM = getSkull("http://textures.minecraft.net/texture/b59c0e9d83dbf04fbdaa7eb2bde8e9fc67994f83420301e582248680fa819f61");

    //public static ItemStack getSkull(String url) {
        //ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        //if(url.isEmpty())return head;

        //SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        //GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        //byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        //profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        //Field profileField = null;
        //try {
        //    profileField = headMeta.getClass().getDeclaredField("profile");
        //    profileField.setAccessible(true);
        //    profileField.set(headMeta, profile);
        //} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
        //    e1.printStackTrace();
        //}
        //head.setItemMeta(headMeta);
        //return head;
    //}
}
