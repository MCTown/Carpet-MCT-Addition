package tech.mctown.cma;

import carpet.settings.Rule;

import static carpet.settings.RuleCategory.SURVIVAL;

public class CMASettings {
    static final String CMA = CMAExtension.MODID;

    @Rule(
            desc = "Execute the command on the sign if it's right-clicked, the player is not sneaking nor holding " +
                    "anything in the main hand and the text starts with '/...'.",
            category = {CMA, SURVIVAL}
    )
    public static boolean runCommandOnSign = false;

    @Rule(
            desc = "Player can edit the sign when it's right-clicked, the player is sneaking and not holding anything " +
                    "in the main hand",
            category = {CMA, SURVIVAL}
    )
    public static boolean editableSign = false;
}
