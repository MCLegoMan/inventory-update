package com.mclegoman.config;

import com.mojang.datafixers.util.Pair;

public class InventoryConfig {
    public static SimpleConfig CONFIG;
    private static InventoryConfigProvider configs;
    public static int MAX_STACK_DEFAULT;
    public static int MAX_STACK_MINI;
    public static boolean REMOVE_LIMIT;
    public static void registerConfigs() {
        configs = new InventoryConfigProvider();
        createConfigs();
        CONFIG = SimpleConfig.of("inventory-update").provider(configs).request();
        assignConfigs();
    }
    private static void createConfigs() {
        configs.addComment("inventory-update properties file");
        configs.addKeyValuePair(new Pair<>("max_stack.default", 1));
        configs.addKeyValuePair(new Pair<>("max_stack.mini", 1));
        configs.addKeyValuePair(new Pair<>("remove_limit", false));
    }
    private static void assignConfigs() {
        MAX_STACK_DEFAULT = CONFIG.getOrDefault("max_stack.default", 1);
        MAX_STACK_MINI = CONFIG.getOrDefault("max_stack.mini", 1);
        REMOVE_LIMIT = CONFIG.getOrDefault("remove_limit", false);
    }
}