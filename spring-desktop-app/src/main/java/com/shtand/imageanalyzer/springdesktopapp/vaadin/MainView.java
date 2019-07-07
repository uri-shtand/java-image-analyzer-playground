package com.shtand.imageanalyzer.springdesktopapp.vaadin;

import com.shtand.imageanalyzer.springdesktopapp.image.ImageManager;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route
public class MainView extends VerticalLayout {

    private final ImageManager imageManager;



    private Button loadButton;
    private Image image;

    public MainView(ImageManager imageManager) {
        this.imageManager = imageManager;
        this.image = new Image();
        this.loadButton = createAnalyzeButton();
        Upload upload = createUpload();
        HorizontalLayout actions = new HorizontalLayout(loadButton);
        add(image, upload, actions);
    }

    private Upload createUpload() {
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFileSize(10485760);
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

        upload.addSucceededListener(event -> {
            imageManager.addImage(buffer.getFileData().getFileName(), buffer.getInputStream());
            image.setSrc(new StreamResource(event.getFileName(), () -> buffer.getInputStream()));
        });
        return upload;
    }

    private Button createAnalyzeButton() {
        Button button = new Button("analyze", VaadinIcon.BULLSEYE.create());
        return button;
    }
}
