package com.example.views.newcharts;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.AxisType;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataLabels;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.DataSeriesItem3d;
import com.vaadin.flow.component.charts.model.DataSeriesItemBullet;
import com.vaadin.flow.component.charts.model.DataSeriesItemTimeline;
import com.vaadin.flow.component.charts.model.DataSeriesItemXrange;
import com.vaadin.flow.component.charts.model.Labels;
import com.vaadin.flow.component.charts.model.Level;
import com.vaadin.flow.component.charts.model.MarkerSymbolEnum;
import com.vaadin.flow.component.charts.model.Node;
import com.vaadin.flow.component.charts.model.NodeLayout;
import com.vaadin.flow.component.charts.model.NodeSeries;
import com.vaadin.flow.component.charts.model.PlotBand;
import com.vaadin.flow.component.charts.model.PlotOptionsBubble;
import com.vaadin.flow.component.charts.model.PlotOptionsBullet;
import com.vaadin.flow.component.charts.model.PlotOptionsOrganization;
import com.vaadin.flow.component.charts.model.PlotOptionsTimeline;
import com.vaadin.flow.component.charts.model.PlotOptionsXrange;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.charts.model.style.FontWeight;
import com.vaadin.flow.component.charts.model.style.SolidColor;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "charts")
@PageTitle("New Charts")
@CssImport("./views/newcharts/new-charts-view.css")
public class NewChartsView extends VerticalLayout {

        public NewChartsView() {
                setId("new-charts-view");
                add(new H2("Java styling API"));
                add(new Paragraph(
                                "Now it's possible to control the styling of Charts from Java. CSS styling is optional."));
                drawCharts4Sample();

                add(new H2("New chart types"));
                addDescription("Bullet",
                                "A graph to compare one value to another value and relate those to qualitative ranges.");
                drawBulletChart();

                addDescription("X Range",
                                "A graph to visualize ranges on the X axis. An X-range is similar to a column range, but displays ranges in the X data where the column range displays lows and highs in the Y data.");
                drawXRangeChart();

                addDescription("Timeline", "Visualize important events or milestones over a time span.");
                drawTimelineChart();

                addDescription("Organization",
                                "Visualize a structure of an organization and the relationships and relative ranks.");
                drawOrgChart();
        }

        private void drawCharts4Sample() {
                Chart chart = new Chart(ChartType.BUBBLE);

                Configuration conf = chart.getConfiguration();
                conf.setTitle((String) null);

                DataSeries dataSeries = new DataSeries();
                dataSeries.add(item(9, 81, 13));
                dataSeries.add(item(98, 5, 39));
                dataSeries.add(item(51, 50, 23));
                dataSeries.add(item(41, 22, -36));
                dataSeries.add(item(58, 24, -30));
                dataSeries.add(item(78, 37, -16));
                dataSeries.add(item(55, 56, 3));
                dataSeries.add(item(18, 45, 20));
                dataSeries.add(item(42, 44, -22));
                dataSeries.add(item(3, 52, 9));
                dataSeries.add(item(31, 18, 47));
                dataSeries.add(item(79, 91, 13));
                dataSeries.add(item(93, 23, -27));
                dataSeries.add(item(44, 83, -28));

                PlotOptionsBubble opts = new PlotOptionsBubble();
                opts.setNegativeColor(new SolidColor("#CB0E40"));
                opts.setMaxSize("120");
                opts.setMinSize("3");

                YAxis yaxis = new YAxis();
                Labels ylabels = yaxis.getLabels();
                ylabels.getStyle().setColor(new SolidColor("#4F5B67"));
                ylabels.getStyle().setFontWeight(FontWeight.BOLD);
                conf.addyAxis(yaxis);

                conf.setPlotOptions(opts);

                conf.addSeries(dataSeries);

                chart.drawChart();
                add(chart);
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
                conf.getxAxis().addCategory(
                                "<span style=\"font-size: 13px; font-weight: bold;\">Revenue</span><br/>U.S. $ (1,000s)");

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
                conf.setTitle("Vaadin releases");
                conf.setSubTitle("Non-LTS releases of Vaadin in H2/2020");
                conf.getTooltip().setEnabled(true);

                // Add data
                DataSeries series = new DataSeries();
                series.add(new DataSeriesItemTimeline(getInstant(2020, 8, 5), "Vaadin 17 beta release",
                                "Vaadin 17 beta release", ""));
                series.add(new DataSeriesItemTimeline(getInstant(2020, 9, 2), "Vaadin 17 general availability release",
                                "Vaadin 17 general availability release", ""));
                series.add(new DataSeriesItemTimeline(getInstant(2020, 11, 4), "Vaadin 18 beta", "Vaadin 18 beta", ""));
                series.add(new DataSeriesItemTimeline(getInstant(2020, 12, 2), "Vaadin 18 GA", "Vaadin 18 GA", ""));
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
                Node sales = new Node("Sales");
                Node marketing = new Node("Marketing");

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
                series.add(headOffice, sales);
                series.add(headOffice, marketing);
                series.add(headOffice, accounting);
                series.add(headOffice, administration);
                series.add(headOffice, mdsOffice);
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

        private void addDescription(String title, String description) {
                add(new H3(title));
                add(new Paragraph(description));
        }

        private Instant getInstant(int year, int month, int dayOfMonth) {
                return LocalDate.of(year, month, dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC);
        }

        private DataSeriesItem item(int x, int y, int z) {
                DataSeriesItem3d dataSeriesItem = new DataSeriesItem3d();
                dataSeriesItem.setX(x);
                dataSeriesItem.setY(y);
                dataSeriesItem.setZ(z);
                return dataSeriesItem;
        }

}
