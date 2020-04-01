package com.frunnkis.firstmod;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

import static net.minecraftforge.fml.Logging.CORE;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_POWER = "power";
    public static final String SUBCATEGORY_POWERBLOCK = "powerblock";

    public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue POWERBLOCK_MAXPOWER;
    public static ForgeConfigSpec.IntValue POWERBLOCK_GENERATE;
    public static ForgeConfigSpec.IntValue POWERBLOCK_SEND;
    public static ForgeConfigSpec.IntValue POWERBLOCK_TICKS;

    static {

        COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Power Settings").push(CATEGORY_POWER);

        setupPowerBlockConfig();

        COMMON_BUILDER.pop();



        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupPowerBlockConfig() {
        COMMON_BUILDER.comment("PowerBlock Settings").push(SUBCATEGORY_POWERBLOCK);

        POWERBLOCK_MAXPOWER = COMMON_BUILDER.comment("Maximum Power for the PowerBlock generator")
                .defineInRange("maxPower", 100000, 0, Integer.MAX_VALUE);
        POWERBLOCK_GENERATE = COMMON_BUILDER.comment("Power generation per diamond")
                .defineInRange("generate", 1000, 0, Integer.MAX_VALUE);
        POWERBLOCK_SEND = COMMON_BUILDER.comment("Energy sent per tick")
                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
        POWERBLOCK_TICKS = COMMON_BUILDER.comment("Ticks per diamond")
                .defineInRange("ticks", 20, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {

    }
}
