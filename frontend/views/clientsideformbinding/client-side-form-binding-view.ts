import { LitElement, html, css, customElement } from 'lit-element';

@customElement('client-side-form-binding-view')
export class ClientSideFormBindingView extends LitElement {
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
