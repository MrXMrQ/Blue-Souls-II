package Launcher;

import Items.ConsumableWeapon;
import Items.HealItems;
import Items.Weapon;

public class ItemLauncher {
    public static HealItems[] healItemsArray = healItems();
    public static Weapon[] weaponsArray = weapons();
    public static ConsumableWeapon[] consumableWeaponsArray = consumableWeapons();

    public static Object[] allItems = {healItemsArray, weaponsArray, consumableWeaponsArray};


    public static HealItems[] healItems() {
        HealItems stoneOfLife = new HealItems("Stone of life", "heal", 20);

        return new HealItems[]{stoneOfLife};
    }

    public static Weapon[] weapons() {
        Weapon bastardSword = new Weapon("Bastard sword", "weapon", 50, 30);

        return new Weapon[]{bastardSword};
    }

    public static ConsumableWeapon[] consumableWeapons() {
        ConsumableWeapon throwKnife = new ConsumableWeapon("Throw knife", "consumableWeapon", 10, 2, true, 16);

        return new ConsumableWeapon[]{throwKnife};
    }
}
