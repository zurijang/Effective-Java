package ej.study.chapter4.item20;

import javafx.scene.media.AudioClip;

public interface SingerSongwriter extends Singer, Songwriter {
    AudioClip strum();
    void actSensitive();
}
