package com.example.views.littemplates;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "littemplates")
@PageTitle("Lit Templates")
@CssImport("views/littemplates/lit-templates-view.css")
@Tag("lit-templates-view")
@JsModule("./views/littemplates/lit-templates-view.js")
public class LitTemplatesView extends LitTemplate {

    @Id
    private Button helloButton;

    @Id
    private TextField nameField;

    public LitTemplatesView() {
        helloButton.addClickListener(event -> Notification.show("Hello " + nameField.getValue()));

    }

}
