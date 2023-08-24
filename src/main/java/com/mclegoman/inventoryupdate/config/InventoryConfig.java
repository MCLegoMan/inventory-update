package com.mclegoman.inventoryupdate.config;

import jdk.internal.net.http.common.Pair;
import me.magistermaks.SimpleConfig;

public class InventoryConfig {
    public static SimpleConfig CONFIG;
    private static InventoryConfigProvider configs;
    public static int MAX_STACK;
    public static void registerConfigs() {
        configs = new InventoryConfigProvider();
        createConfigs();
        CONFIG = SimpleConfig.of("inventory-update").provider(configs).request();
        assignConfigs();
    }
    private static void createConfigs() {
        configs.addComment("inventory-update properties file");
        configs.addKeyValuePair(new Pair<>("max_stack", 1));
    }
    private static void assignConfigs() {
        MAX_STACK = CONFIG.getOrDefault("max_stack", 1);
    }
}