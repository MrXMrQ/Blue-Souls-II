package Launcher;

import NPCS.NPC;

public class NPCLauncher {
    public static NPC[] npc() {
        NPC pascal = new NPC("Pascal", 100,"friendly", "quest");

        return new NPC[]{pascal};
    }
}
