package com.shtand.imageanalyzer.springdesktopapp.image;

public class PlaygroundImage {

    private final String fileName;
    private final byte[] bytes;

    public PlaygroundImage(String fileName, byte[] bytes) {
        this.fileName = fileName;
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
