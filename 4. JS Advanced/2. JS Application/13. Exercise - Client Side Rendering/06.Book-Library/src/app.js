import { render } from './utility.js';
import { showCatalog } from './catalog.js';
import { showCreate } from './create.js';
import { showUpdate } from './update.js';

// main module:
// init modules with dependencies
// - rendering
// - comunication

const root = document.body;

const ctx = {
    update
};

update();

function update() {
    render([
        showCatalog(ctx),
        showCreate(ctx),
        showUpdate(ctx)
    ], root);
}