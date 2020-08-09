import { Flow } from '@vaadin/flow-frontend/Flow';
import { Router } from '@vaadin/router';

import './global-styles';

const { serverSideRoutes } = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports'),
});

const routes = [
  // for client-side, place routes below (more info https://vaadin.com/docs/v15/flow/typescript/creating-routes.html)
  {
	path: '',
	component: 'main-view', 
	action: async () => { await import ('./views/main/main-view'); },
	children: [
		{
			path: '',
			component: 'summary-view', 
			action: async () => { await import ('./views/summary/summary-view'); }
		},
		{
			path: 'summary',
			component: 'summary-view', 
			action: async () => { await import ('./views/summary/summary-view'); }
		},
		{
			path: 'forms',
			component: 'client-side-form-binding-view', 
			action: async () => { await import ('./views/clientsideformbinding/client-side-form-binding-view'); }
		},
 		// for server-side, the next magic line sends all unmatched routes:
		...serverSideRoutes // IMPORTANT: this must be the last entry in the array
	]
},
];

export const router = new Router(document.querySelector('#outlet'));
router.setRoutes(routes);
