package com.mclegoman.inventoryupdate.config;

import com.mclegoman.inventoryupdate.util.InventoryPair;
import me.magistermaks.SimpleConfig;

import java.util.ArrayList;
import java.util.List;

public class InventoryConfigProvider implements SimpleConfig.DefaultConfig {
    private String configContents = "";
    public List<InventoryPair> getConfigsList() {
        return configsList;
    }
    private final List<InventoryPair> configsList = new ArrayList<>();
    public void addKeyValuePair(InventoryPair<String, ?> keyValuePair) {
        configsList.add(keyValuePair);
        configContents += keyValuePair.getLeft() + "=" + keyValuePair.getRight() + "\n";
    }
    public void addComment(String string) {
        configContents += "#" + string + "\n";
    }
    @Override
    public String get(String namespace) {
        return configContents;
    }
}