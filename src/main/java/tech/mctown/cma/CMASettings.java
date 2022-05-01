package tech.mctown.cma;

import carpet.settings.Rule;

import static carpet.settings.RuleCategory.SURVIVAL;

public class CMASettings {
    static final String CMA = CMAExtension.MODID;

    @Rule(
            desc = "Execute the command on the sign if it's right-clicked and the text starts with '/...'.",
            category = {CMA, SURVIVAL}
    )
    public static boolean runCommandOnSign = false;
}
