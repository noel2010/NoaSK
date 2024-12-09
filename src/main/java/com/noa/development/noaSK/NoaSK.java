package com.noa.development.noaSK;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class NoaSK extends JavaPlugin {
    private static NoaSK instance;
    private static SkriptAddon addonInstance;

    public NoaSK(){
        if (instance == null){
            instance = this;
        }else{
            throw new IllegalStateException();
        }
    }

    public static SkriptAddon getAddonInstance(){
        if (addonInstance == null){
            addonInstance = Skript.registerAddon(getInstance());
        }
        return addonInstance;
    }

    public static NoaSK getInstance(){
        if (instance == null){
            throw new IllegalStateException();
        }
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        try{
            getAddonInstance().loadClasses("com.development.noa", "effects");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
