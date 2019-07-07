package com.shtand.imageanalyzer.springdesktopapp.image;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageManager {
    private List<PlaygroundImage> images = new ArrayList<>();

    public void addImage(String fileName, InputStream inputStream) {
        try {
            PlaygroundImage playgroundImage = new PlaygroundImage(fileName, IOUtils.toByteArray(inputStream));
            images.add(playgroundImage);
        } catch (IOException e) {
            throw new RuntimeException("Invalid image", e);
        }
    }

    public PlaygroundImage getLastImage() {
        return images.get(images.size() - 1);
    }

    public PlaygroundImage getImage(int index) {
        return images.get(index % images.size());
    }
}
