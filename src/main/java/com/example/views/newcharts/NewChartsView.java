package com.example.application.views.newcharts;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.AxisType;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataLabels;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItemBullet;
import com.vaadin.flow.component.charts.model.DataSeriesItemTimeline;
import com.vaadin.flow.component.charts.model.DataSeriesItemXrange;
import com.vaadin.flow.component.charts.model.Level;
import com.vaadin.flow.component.charts.model.MarkerSymbolEnum;
import com.vaadin.flow.component.charts.model.Node;
import com.vaadin.flow.component.charts.model.NodeLayout;
import com.vaadin.flow.component.charts.model.NodeSeries;
import com.vaadin.flow.component.charts.model.PlotBand;
import com.vaadin.flow.component.charts.model.PlotOptionsBullet;
import com.vaadin.flow.component.charts.model.PlotOptionsOrganization;
import com.vaadin.flow.component.charts.model.PlotOptionsTimeline;
import com.vaadin.flow.component.charts.model.PlotOptionsXrange;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.charts.model.style.SolidColor;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "charts")
@PageTitle("New Charts")
@CssImport("./views/newcharts/new-charts-view.css")
public class NewChartsView extends VerticalLayout {

    public NewChartsView() {
        setId("new-charts-view");
        drawBulletChart();
        drawXRangeChart();
        drawTimelineChart();
        drawOrgChart();
    }

    private void drawBulletChart() {
        // Create a bullet chart
        Chart chart = new Chart(ChartType.BULLET);
        chart.setHeight("115px");

        // Modify the default configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("2020 YTD");
        conf.getChart().setInverted(true);
        conf.getLegend().setEnabled(false);
        conf.getTooltip().setPointFormat("<b>{point.y}</b> (with target at {point.target})");

        // Add data
        PlotOptionsBullet options = new PlotOptionsBullet();
        options.setPointPadding(0.25);
        options.setBorderWidth(0);
        options.setColor(SolidColor.BLACK);
        options.getTargetOptions().setWidth("200%");
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItemBullet(275, 250));
        series.setPlotOptions(options);
        conf.addSeries(series);

        // Configure the axes
        YAxis yAxis = conf.getyAxis();
        yAxis.setGridLineWidth(0);
        yAxis.setTitle("");
        yAxis.addPlotBand(new PlotBand(0, 150, new SolidColor("#666666")));
        yAxis.addPlotBand(new PlotBand(150, 225, new SolidColor("#999999")));
        yAxis.addPlotBand(new PlotBand(225, 9e9, new SolidColor("#bbbbbb")));
        conf.getxAxis()
                .addCategory("<span style=\"font-size: 13px; font-weight: bold;\">Revenue</span><br/>U.S. $ (1,000s)");

        add(chart);
        chart.drawChart();
    }

    private void drawXRangeChart() {
        // Create a xrange chart
        Chart chart = new Chart(ChartType.XRANGE);

        // Modify the default configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("X-range");

        // Add data
        DataSeries series = new DataSeries();
        series.setName("Project 1");
        series.add(new DataSeriesItemXrange(getInstant(2014, 11, 21), getInstant(2014, 12, 2), 0, 0.25));
        series.add(new DataSeriesItemXrange(getInstant(2014, 12, 2), getInstant(2014, 12, 5), 1));
        series.add(new DataSeriesItemXrange(getInstant(2014, 12, 8), getInstant(2014, 12, 9), 2));
        series.add(new DataSeriesItemXrange(getInstant(2014, 12, 9), getInstant(2014, 12, 19), 1));
        series.add(new DataSeriesItemXrange(getInstant(2014, 12, 10), getInstant(2014, 12, 23), 2));
        PlotOptionsXrange options = new PlotOptionsXrange();
        options.setBorderColor(SolidColor.GRAY);
        options.setPointWidth(20);
        options.getDataLabels().setEnabled(true);
        series.setPlotOptions(options);
        conf.addSeries(series);

        // Configure the axes
        conf.getxAxis().setType(AxisType.DATETIME);
        conf.getyAxis().setTitle("");
        conf.getyAxis().setCategories("Prototyping", "Development", "Testing");
        conf.getyAxis().setReversed(true);

        add(chart);
        chart.drawChart();
    }

    private void drawTimelineChart() {
        // Create a timeline chart
        Chart chart = new Chart(ChartType.TIMELINE);

        // Modify the default configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Timeline of Space Exploration");
        conf.setSubTitle(
                "Info source: <a href=\"https://en.wikipedia.org/wiki/Timeline_of_space_exploration\">www.wikipedia.org</a>");
        conf.getTooltip().setEnabled(true);

        // Add data
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItemTimeline(getInstant(1951, 6, 22), "First dogs in space", "First dogs in space",
                "Dezik and Tsygan were the first dogs to make a sub-orbital flight on 22 July 1951. Both dogs were recovered unharmed after travelling to a maximum altitude of 110 km."));
        series.add(new DataSeriesItemTimeline(getInstant(1957, 10, 4), "First artificial satellite",
                "First artificial satellite",
                "Sputnik 1 was the first artificial Earth satellite. The Soviet Union launched it into an elliptical low Earth orbit on 4 October 1957, orbiting for three weeks before its batteries died, then silently for two more months before falling back into the atmosphere."));
        series.add(new DataSeriesItemTimeline(getInstant(1959, 1, 4), "First artificial satellite to reach the Moon",
                "First artificial satellite to reach the Moon",
                "Luna 1 was the first artificial satellite to reach the Moon vicinity and first artificial satellite in heliocentric orbit."));
        series.add(new DataSeriesItemTimeline(getInstant(1961, 4, 12), "First human spaceflight",
                "First human spaceflight",
                "Yuri Gagarin was a Soviet pilot and cosmonaut. He became the first human to journey into outer space when his Vostok spacecraft completed one orbit of the Earth on 12 April 1961."));
        series.add(new DataSeriesItemTimeline(getInstant(1966, 2, 3), "First soft landing on the Moon",
                "First soft landing on the Moon",
                "Yuri Gagarin was a Soviet pilot and cosmonaut. He became the first human to journey into outer space when his Vostok spacecraft completed one orbit of the Earth on 12 April 1961."));
        series.add(new DataSeriesItemTimeline(getInstant(1969, 7, 20), "First human on the Moon",
                "First human on the Moon",
                "Apollo 11 was the spaceflight that landed the first two people on the Moon. Commander Neil Armstrong and lunar module pilot Buzz Aldrin, both American, landed the Apollo Lunar Module Eagle on July 20, 1969, at 20:17 UTC."));
        series.add(new DataSeriesItemTimeline(getInstant(1971, 4, 19), "First space station", "First space station",
                "Salyute 1 was the first space station of any kind, launched into low Earth orbit by the Soviet Union on April 19, 1971. The Salyut program followed this with five more successful launches out of seven more stations."));
        series.add(new DataSeriesItemTimeline(getInstant(1971, 12, 2), "First soft Mars landing",
                "First soft Mars landing",
                "Mars 3 was an unmanned space probe of the Soviet Mars program which spanned the years between 1960 and 1973. Mars 3 was launched May 28, 1971, nine days after its twin spacecraft Mars 2. The probes were identical robotic spacecraft launched by Proton-K rockets with a Blok D upper stage, each consisting of an orbiter and an attached lander."));
        series.add(new DataSeriesItemTimeline(getInstant(1976, 4, 17), "Closest flyby of the Sun",
                "Closest flyby of the Sun",
                "Helios-A and Helios-B (also known as Helios 1 and Helios 2) are a pair of probes launched into heliocentric orbit for the purpose of studying solar processes. A joint venture of West Germany's space agency DFVLR (70 percent share) and NASA (30 percent), the probes were launched from Cape Canaveral Air Force Station, Florida."));
        series.add(new DataSeriesItemTimeline(getInstant(1978, 12, 4), "First orbital exploration of Venus",
                "First orbital exploration of Venus",
                "The Pioneer Venus Orbiter entered orbit around Venus on December 4, 1978, and performed observations to characterize the atmosphere and surface of Venus. It continued to transmit data until October 1992."));
        series.add(new DataSeriesItemTimeline(getInstant(1986, 2, 19), "First inhabited space station",
                "First inhabited space station",
                "was a space station that operated in low Earth orbit from 1986 to 2001, operated by the Soviet Union and later by Russia. Mir was the first modular space station and was assembled in orbit from 1986 to 1996. It had a greater mass than any previous spacecraft."));
        series.add(new DataSeriesItemTimeline(getInstant(1989, 8, 8), "First astrometric satellite",
                "First astrometric satellite",
                "Hipparcos was a scientific satellite of the European Space Agency (ESA), launched in 1989 and operated until 1993. It was the first space experiment devoted to precision astrometry, the accurate measurement of the positions of celestial objects on the sky."));
        series.add(new DataSeriesItemTimeline(getInstant(1998, 11, 20), "First multinational space station",
                "First multinational space station",
                "The International Space Station (ISS) is a space station, or a habitable artificial satellite, in low Earth orbit. Its first component was launched into orbit in 1998, with the first long-term residents arriving in November 2000.[7] It has been inhabited continuously since that date."));

        PlotOptionsTimeline options = new PlotOptionsTimeline();
        options.getMarker().setSymbol(MarkerSymbolEnum.CIRCLE);
        DataLabels labels = options.getDataLabels();
        labels.setAllowOverlap(false);
        labels.setFormat(
                "<span style=\"color:{point.color}\">● </span><span style=\"font-weight: bold;\" > {point.x:%d %b %Y}</span><br/>{point.label}");
        series.setPlotOptions(options);
        conf.addSeries(series);

        // Configure the axes
        conf.getxAxis().setVisible(false);
        conf.getxAxis().setType(AxisType.DATETIME);
        conf.getyAxis().setVisible(false);

        add(chart);
        chart.drawChart();
    }

    private void drawOrgChart() {
        Chart chart = new Chart(ChartType.ORGANIZATION);
        Configuration conf = chart.getConfiguration();
        conf.getChart().setInverted(true);
        conf.getChart().setHeight("500px");
        conf.getTooltip().setOutside(true);
        conf.setTitle("Acme organization chart");
        add(chart);

        PlotOptionsOrganization plotOptions = new PlotOptionsOrganization();
        plotOptions.setColorByPoint(false);
        plotOptions.setColor(new SolidColor("#007ad0"));

        // Special color for first level
        Level level0 = new Level();
        level0.setLevel(0);
        level0.setColor(new SolidColor("#99AED3"));
        plotOptions.addLevel(level0);
        conf.setPlotOptions(plotOptions);

        NodeSeries series = new NodeSeries();
        series.setName("Acme");
        Node acme = new Node("Acme");
        Node headOffice = new Node("Head Office");
        Node labs = new Node("Labs");
        Node coyoteBuilding = new Node("Coyote Building");
        Node roadRunnerBuilding = new Node("Road Runner Building");
        Node sales = new Node("Sales");
        Node marketing = new Node("Marketing");
        marketing.setColor(new SolidColor("#E4B651"));

        Node accounting = new Node("Accounting");
        Node administration = new Node("Administration");
        Node mdsOffice = new Node("MD's Office");

        Node josephMiler = new Node("Joseph Miler");
        josephMiler.setTitle("Head of Sales");
        josephMiler.setLayout(NodeLayout.HANGING);

        Node erikPerez = new Node("Erik Perez");
        erikPerez.setTitle("Head of Marketing");
        erikPerez.setLayout(NodeLayout.HANGING);

        Node emilyFox = new Node("Emily Fox");
        emilyFox.setTitle("Head of Accounting");

        Node ewanHerbert = new Node("Ewan Herbert");
        ewanHerbert.setTitle("Head of Admin");
        ewanHerbert.setLayout(NodeLayout.HANGING);

        Node kateKirby = new Node("Kate Kirby");
        Node vaughnWhiting = new Node("Vaughn Whiting");
        Node lisaWarner = new Node("Lisa Warner");
        Node mollyDodd = new Node("Molly Dodd");
        Node natashaKelly = new Node("Natasha Kelly");
        Node managingDirector = new Node("Sally Brown", "Sally Brown", "Managing Director");

        series.add(acme, headOffice);
        series.add(acme, labs);
        series.add(headOffice, coyoteBuilding);
        series.add(headOffice, roadRunnerBuilding);
        series.add(coyoteBuilding, sales);
        series.add(coyoteBuilding, marketing);
        series.add(coyoteBuilding, accounting);
        series.add(roadRunnerBuilding, administration);
        series.add(roadRunnerBuilding, mdsOffice);
        series.add(sales, josephMiler);
        series.add(marketing, erikPerez);
        series.add(accounting, emilyFox);
        series.add(administration, ewanHerbert);
        series.add(josephMiler, kateKirby);
        series.add(josephMiler, vaughnWhiting);
        series.add(erikPerez, lisaWarner);
        series.add(ewanHerbert, mollyDodd);
        series.add(ewanHerbert, natashaKelly);
        series.add(mdsOffice, managingDirector);
        conf.addSeries(series);

        chart.drawChart();
    }

    private Instant getInstant(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC);
    }

}
