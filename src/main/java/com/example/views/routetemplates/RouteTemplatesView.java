package com.example.views.routetemplates;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "routetemplates")
@PageTitle("Route Templates")
@CssImport("views/routetemplates/route-templates-view.css")
public class RouteTemplatesView extends Div {

    public RouteTemplatesView() {
        setId("route-templates-view");
        add(new Label("Content placeholder"));
    }

}
