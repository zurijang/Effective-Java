package ej.study.chapter4.item20;

import javafx.scene.media.AudioClip;

public abstract class abstractSingerSongWriter {

    abstract AudioClip sing(String s);
    abstract String compose(int charPosition);
    abstract AudioClip strum();
    abstract void actSensitive();
}
