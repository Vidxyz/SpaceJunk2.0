package com.spacejunk.game;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.spacejunk.game.SpaceJunk;
import com.spacejunk.game.interfaces.SystemServices;

public class IOSLauncher extends IOSApplication.Delegate implements SystemServices {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new SpaceJunk(SpaceJunk.DIFFICULTY_LEVEL.EASY, this), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }

    @Override
    public void setSettings(boolean sound, boolean record, boolean vibrate) {
        Preferences prefs = Gdx.app.getPreferences("SpaceJunkPreferences");

        //Set values
        prefs.putBoolean("sound", sound);
        prefs.putBoolean("record", record);
        prefs.putBoolean("vibrate", vibrate);

        prefs.flush();
    }

    @Override
    public boolean[] getSettings() {
        Preferences prefs = Gdx.app.getPreferences("SpaceJunkPreferences");
        return new boolean[] { prefs.getBoolean("sound", true),
                prefs.getBoolean("record", true),
                prefs.getBoolean("vibrate", true)};
    }

    @Override
    public void startRecording(int xMax, int yMax, boolean recordAudioSetting) {

    }

    @Override
    public void stopRecording() {

    }
}
