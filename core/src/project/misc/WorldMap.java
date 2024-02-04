/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.misc;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author NirajDell
 */
public class WorldMap {
    private final static WorldMap INSTANCE = new WorldMap();

    private WorldMap() {
        System.out.println("Just the Map");
    }

    public static WorldMap getInstance() {
        return INSTANCE;
    }

    public void render(SpriteBatch batch) {
    }


    public void setLevel() {
        System.out.println("LEVEL SET");
    }

    public void next() {
        System.out.println("NEXTED");
    }
}
