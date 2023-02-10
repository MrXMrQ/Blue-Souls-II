package Launcher;

import Items.*;

public class ItemLauncher {
    public static UseItems[] useItemsArray = healItems();
    public static Weapon[] weaponsArray = weapons();
    public static Ring[] ringsArray = rings();


    public static UseItems[] healItems() {
        UseItems stoneOfLife = new UseItems("Stone of life", "HealUse", 20, 0,false,0);
        UseItems fragmentOfLight = new UseItems("Fragment of light", "HealUse", 50, 0,false,0);
        UseItems throwKnife = new UseItems("Throw knife", "DamageUse", 0,20,false,0);
        return new UseItems[]{stoneOfLife, fragmentOfLight, throwKnife};
    }

    public static Weapon[] weapons() {
        Weapon bastardSword = new Weapon("Bastard sword", "weapon", 10, 10);

        return new Weapon[]{bastardSword};
    }

    public static Ring[] rings() {
        Ring ringOfHealing = new Ring("Ring of Heal", "ring", 1.5);

        return new Ring[]{ringOfHealing};
    }
}