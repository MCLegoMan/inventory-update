package com.mclegoman.inventoryupdate.config;

import jdk.internal.net.http.common.Pair;
import me.magistermaks.SimpleConfig;

import java.util.ArrayList;
import java.util.List;

public class InventoryConfigProvider implements SimpleConfig.DefaultConfig {
    private String configContents = "";
    public List<Pair> getConfigsList() {
        return configsList;
    }
    private final List<Pair> configsList = new ArrayList<>();
    public void addKeyValuePair(Pair<String, ?> keyValuePair) {
        configsList.add(keyValuePair);
        configContents += keyValuePair.first + "=" + keyValuePair.second + "\n";
    }
    public void addComment(String string) {
        configContents += "#" + string + "\n";
    }
    @Override
    public String get(String namespace) {
        return configContents;
    }
}