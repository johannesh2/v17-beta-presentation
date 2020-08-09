import { LitElement, html, css, customElement } from "lit-element";
import "@vaadin/vaadin-ordered-layout/vaadin-vertical-layout";

@customElement("summary-view")
export class SummaryView extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
      }
    `;
  }

  render() {
    return html`
      <vaadin-vertical-layout theme="margin spacing">
        <div>
          <h1>Vaadin 17 beta</h1>
          <p><a href="https://github.com/vaadin/platform/releases/tag/17.0.0.beta1">Release notes</a></p>
          <h2>Query performance and DX improvements in DataProvider</h2>
          <ul>
            <li>Count query is now optional.</li>
            <li>
              DataView for mutating, reading and observing a data set in a
              component
              <ul>
                <li>
                  ListDataView for in-memory data binding of CheckboxGroup,
                  CrudGrid, Grid, GridPro, Select, and TreeGrid
                </li>
                <li>
                  LazyDataView for lazy data binding of CrudGrid, Grid, GridPro,
                  and TreeGrid
                </li>
              </ul>
            </li>
            <li>
              More straightforward API for lazy data binding to backends with
              "paged access".
            </li>
            <li>
              VaadinSpringDataHelpers for a simplified paged query to Spring
              Data repositories
            </li>
          </ul>
          <h2>TypeScript support improvements</h2>
          <ul>
            <li>TypeScript type definitions for Vaadin components</li>
            <li>
              Client-side form binding with Java Bean Validation
              <ul>
                <li>
                  based built-in validators run on client-side without network
                  round-trip
                </li>
                <li>Server-side validators run when data is submitted.</li>
              </ul>
            </li>
          </ul>
          <h2>New Charts version</h2>
          <ul>
            <li>Updated Highcharts version</li>
            <li>Java styling API from Charts for Vaadin 8 makes a comeback</li>
            <li>Four new chart types</li>
          </ul>
          <h2>LitTemplate support with @Id mapping</h2>
          <ul>
            <li>Basic support without nested templates or template model</li>
          </ul>
          <h2>
            Route URL templates
          </h2>
          <p>
            supporting parameters in the middle of the URL and routes with
            multiple optional parameters, regex matching, etc.
          </p>
          <h2>LiveReload (introduced in Vaadin 14.3)</h2>
        </div>
      </vaadin-vertical-layout>
    `;
  }
}
