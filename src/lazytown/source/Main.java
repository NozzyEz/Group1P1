package lazytown.source;

import lazytown.source.menu.ConfirmBox;
import lazytown.source.menu.MainMenu;
import lazytown.source.sound.SoundEngine;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the main application class which creates our Stage and sets the scene to MainMenu.
 */
public class Main extends Application {
    // Parameters for the window and buttons
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 768;
    private static final int BUTTON_WIDTH = WINDOW_WIDTH / 4;
    private static final int BUTTON_HEIGHT = WINDOW_HEIGHT / 10;
    // A SoundEngine object to load the menu music. Specifies that this engine will be used for music.
    // ! Important - do not convert into a local variable, as the media will be stopped by the garbage collector.
    private static SoundEngine menuMusic = new SoundEngine("music");
    // A SoundEngine object to load the button click sounds. Specifies that this engine will be used for sfx.
    private static SoundEngine buttonClicks = new SoundEngine("sfx");
    private static Stage ps;

    /**
     * This is our start method, which is our primary method for the game, it initializes our stage as well as sets it's
     * parameters to the desired values. we also add files for menu music and button clicks.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // We create a new stage only to use it in external methods.
        ps = primaryStage;

        // Stage is the window
        // Sets the title of the window
        primaryStage.setTitle("The Great Campus Escape");
        // Prevents the window from being resized
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        // Sets the default scene as MainMenu
        MainMenu.show(primaryStage);

        // Loads in the correct volume and mute settings.
        // Tells the SoundEngines to load their files.
        SoundEngine.loadSettings();
        menuMusic.load("menuMusic.mp3");
        buttonClicks.load("buttonClick.mp3");

        // An event that happens if the close (X) button is pressed.
//        primaryStage.setOnCloseRequest(e -> {
//            //consume cancels out the CloseRequest
//            e.consume();
//            if(ConfirmBox.display("Exit Game","Are you sure you want to exit?")){
//                primaryStage.close();
//            }
//        });

        // Shows the Stage on our screen
        primaryStage.show();

        // Tells the SoundEngine menuMusic to play the loaded file.
        menuMusic.play();

    }

    public static void close() {
        ps.close();
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

    public static int getButtonHeight() {
        return BUTTON_HEIGHT;
    }

    public static SoundEngine getMenuMusic() {
        return menuMusic;
    }

    public static SoundEngine getButtonClicks() {
        return buttonClicks;
    }

}

