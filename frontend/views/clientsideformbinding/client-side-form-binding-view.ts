import { LitElement, html, css, customElement } from "lit-element";
import "@vaadin/vaadin-button/vaadin-button";
import "@vaadin/vaadin-text-field/vaadin-text-field";
import "@vaadin/vaadin-date-picker/vaadin-date-picker";
import "@vaadin/vaadin-ordered-layout/vaadin-vertical-layout";
import { Binder, field } from "@vaadin/form";

import { savePerson, loadPerson } from "../../generated/PersonEndpoint";
import PersonModel from "../../generated/com/example/views/clientsideformbinding/PersonModel";

@customElement("client-side-form-binding-view")
export class ClientSideFormBindingView extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
      }
    `;
  }

  private binder = new Binder(this, PersonModel);

  render() {
    if (!this.binder.value) return html`Loading`;
    return html`
      <vaadin-vertical-layout theme="spacing margin">
        <p>
          <a
            href="https://vaadin.com/docs/v17/flow/client-side-forms/tutorial-binder.html"
            >Documentation</a
          >
        </p>
        <vaadin-text-field
          label="First name"
          ...="${field(this.binder.model.first)}"
        ></vaadin-text-field>
        <vaadin-text-field
          label="Last name"
          ...="${field(this.binder.model.last)}"
        ></vaadin-text-field>
        <vaadin-date-picker
          label="Date of birth"
          ...="${field(this.binder.model.dateOfBirth)}"
        ></vaadin-date-picker>
        <vaadin-button
          @click=${this.save}
          theme="primary"
          ?disabled="${this.binder.invalid || this.binder.submitting}"
          >Save</vaadin-button
        >
      </vaadin-vertical-layout>
    `;
  }

  async save() {
    await this.binder.submitTo(savePerson);
  }

  async firstUpdated() {
    this.binder.read(await loadPerson());
  }
}
