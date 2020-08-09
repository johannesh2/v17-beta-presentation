package com.example.views.routetemplates;

import java.util.List;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "routetemplates/:id")
@RouteAlias(value = "routetemplates/:id/edit")
@PageTitle("Route Templates")
@CssImport("views/routetemplates/route-templates-view.css")
public class RouteTemplatesView extends VerticalLayout implements BeforeEnterObserver {

    private Paragraph p = new Paragraph();

    public RouteTemplatesView() {
        setId("route-templates-view");
        add(p);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        String id = event.getRouteParameters().get("id").get();
        if ("edit".equals(getLastSegment(event))) {
            p.setText("Opening " + id + " for editing");
        } else {
            p.setText("Opening " + id + " for viewing");
        }
    }

    private String getLastSegment(BeforeEnterEvent beforeEnterEvent) {
        final List<String> segments = beforeEnterEvent.getLocation().getSegments();
        return segments.get(segments.size() - 1);
    }
}
