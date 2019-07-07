package com.shtand.imageanalyzer.springdesktopapp.image;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageManager {
    private List<PlaygroundImage> images = new ArrayList<>();

    public void addImage(String fileName, InputStream inputStream) {

    }
}
