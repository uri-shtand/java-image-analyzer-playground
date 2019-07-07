package com.shtand.imageanalyzer.springdesktopapp.vaadin;

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

    private Button loadButton;
    private Image image;

    public MainView() {
//        add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
        this.image = new Image();
        this.loadButton = createLoadButton();
//        createUpload(loadButton,null);
        Upload upload = createUpload();
        HorizontalLayout actions = new HorizontalLayout(loadButton);
//
        add(image, upload, actions);
    }

    private Upload createUpload() {
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFileSize(10485760);
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

        upload.addSucceededListener(event -> {
            image.setSrc(new StreamResource(event.getFileName(), () -> buffer.getInputStream()));

        });
        return upload;
    }

    private Button createLoadButton() {
        Button button = new Button("load image", VaadinIcon.BROWSER.create());
        return button;
    }
}
