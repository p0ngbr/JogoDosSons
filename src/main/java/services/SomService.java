package services;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.*;
import java.util.Random;

public class SomService {

    public static void play(byte[] som){
        Media media = null;
        try {
            media = new Media(getTempFile(som).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getTempFile(byte[] som) throws IOException {
        Random random = new Random();
        String fileName = random.nextInt(50) + "_sound";
        File tempFile = File.createTempFile(fileName, ".mp3", null);
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(som);
        fos.close();

        return tempFile;
    }
}
