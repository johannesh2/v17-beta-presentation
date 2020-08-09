package com.example.views.dataprovider;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "dataprovider")
@PageTitle("Data Provider")
@CssImport("views/dataprovider/data-provider-view.css")
public class DataProviderView extends Div {

    public DataProviderView() {
        setId("data-provider-view");
        add(new Label("Content placeholder"));
    }

}
