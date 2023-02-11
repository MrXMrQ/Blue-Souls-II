package Launcher;

import Items.*;

public class ItemLauncher {
    public static UseItems[] useItemsArray = healItems();
    public static Weapon[] weaponsArray = weapons();
    public static Ring[] ringsArray = rings();
    public static String[] ringKinds = {};


    public static UseItems[] healItems() {
        UseItems stoneOfLife = new UseItems("Stone of life", "HealUse", 20, 0, false, 0);
        UseItems fragmentOfLight = new UseItems("Fragment of light", "HealUse", 50, 0, false, 0);
        UseItems throwKnife = new UseItems("Throw knife", "DamageUse", 0, 20, false, 0);
        return new UseItems[]{stoneOfLife, fragmentOfLight, throwKnife};
    }

    public static Weapon[] weapons() {
        Weapon bastardSword = new Weapon("Bastard sword", "weapon", 10, 10);

        return new Weapon[]{bastardSword};
    }

    public static Ring[] rings() {
        Ring ringOfHealing = new Ring("Ring of heal", "ring", "heal", 1.5);

        Ring ringOfDamage = new Ring("Ring of damage", "ring", "damage", 1.5);
        Ring ringOfDamagePlus = new Ring("Ring of damage I", "ring", "damage", 1.5);
        Ring ringOfDamagePlusPlus = new Ring("Ring of damage II", "ring", "damage", 1.5);

        Ring ringOfSouls = new Ring("Ring of souls", "ring", "souls", 1.5);
        Ring ringOfSoulsPlus = new Ring("Ring of souls I", "ring", "souls", 1.5);
        Ring ringOfSoulsPlusPlus = new Ring("Ring of souls II", "ring", "souls", 1.5);

        Ring ringOfCrit = new Ring("Ring Of crit", "ring", "critDamage", 1.5);
        Ring ringOfCritPlus = new Ring("Ring Of crit I", "ring", "critDamage", 1.5);
        Ring ringOfCritPlusPlus = new Ring("Ring Of crit I", "ring", "critDamage", 1.5);

        Ring ringOfLifeSteal = new Ring("Ring of life steal", "ring", "lifeSteal", 1.5);
        Ring ringOfResistant = new Ring("Ring of resistant", "ring", "resistant", 1.5);

        return new Ring[]{ringOfHealing, ringOfDamage, ringOfDamagePlus, ringOfDamagePlusPlus, ringOfSouls, ringOfSoulsPlus, ringOfSoulsPlusPlus, ringOfCrit, ringOfCritPlus, ringOfCritPlusPlus ,ringOfLifeSteal ,ringOfResistant};
    }
}