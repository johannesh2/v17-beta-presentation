import {LitElement, html} from 'lit-element';
import '@vaadin/vaadin-button/vaadin-button';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';


class LitTemplatesView extends LitElement {

    render() {
        return html`
            <vaadin-vertical-layout theme="margin spacing">
                <p>A view created with layout from a LitElement template and logic in server-side Java code.</p>
                <vaadin-text-field label="Name" id="nameField"></vaadin-text-field>
                <vaadin-button id="helloButton">Say Hello</vaadin-button>
            </vaadin-vertical-layout>`;
    }
}

customElements.define('lit-templates-view', LitTemplatesView);

