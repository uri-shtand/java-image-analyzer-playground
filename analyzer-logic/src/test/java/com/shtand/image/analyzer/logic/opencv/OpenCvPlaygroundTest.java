package com.shtand.image.analyzer.logic.opencv;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;

import java.io.IOException;
import java.io.InputStream;

class OpenCvPlaygroundTest {

    private OpenCvPlayground openCvPlayground;

    @BeforeEach
    void setUp() {
        openCvPlayground = new OpenCvPlayground();
    }

    @Test
    public void testLoadImage() throws IOException {
        InputStream resourceAsStream = OpenCvPlaygroundTest.class.getResourceAsStream("/images_nohead/1.jpg");
        Mat mat = openCvPlayground.loadImageToMatrix(IOUtils.toByteArray(resourceAsStream));
        System.out.println(mat.height());
    }
}