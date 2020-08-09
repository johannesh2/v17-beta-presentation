package com.example.views.dataprovider;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "dataprovider")
@PageTitle("Data Provider")
@CssImport("./views/dataprovider/data-provider-view.css")
public class DataProviderView extends VerticalLayout {

    public DataProviderView(@Autowired MyService service) {
        setId("data-provider-view");

        add(new H2("Count query is now optional"));
        Grid<Integer> grid = new Grid<>();
        grid.addColumn(i -> String.valueOf(i)).setHeader("Number");
        grid.addColumn(i -> String.valueOf(i*i)).setHeader("Squared");
        grid.setItems(query -> service.fetch(query.getOffset(), query.getLimit()));
        add(grid);
    }

}
