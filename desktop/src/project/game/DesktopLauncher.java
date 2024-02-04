package project.game;

import com.badlogic.gdx.backends.lwjgl3.*;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) throws Exception {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setResizable(false);
        config.setWindowedMode(800, 600);
        config.setWindowPosition(256, 128);
        config.setForegroundFPS(60);
        config.setTitle("Gdx-Game");
        new Lwjgl3Application(new Main(), config);
    }

}
