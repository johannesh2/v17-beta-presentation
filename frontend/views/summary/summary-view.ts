import { LitElement, html, css, customElement } from 'lit-element';

@customElement('summary-view')
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
      <br />
      Content placeholder
    `;
  }
}
