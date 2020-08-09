package com.example.views.littemplates;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "littemplates")
@PageTitle("Lit Templates")
@CssImport("views/littemplates/lit-templates-view.css")
public class LitTemplatesView extends Div {

    public LitTemplatesView() {
        setId("lit-templates-view");
        add(new Label("Content placeholder"));
    }

}
