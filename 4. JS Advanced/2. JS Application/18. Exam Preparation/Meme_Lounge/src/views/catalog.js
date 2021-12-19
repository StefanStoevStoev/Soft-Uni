import { html } from '../lib.js';

const catalogTemplate = () => html `
<section id="meme-feed">
    <h1>All Memes</h1>
    <div id="memes">
        <!-- Display : All memes in database ( If any ) -->

        <!-- Display : If there are no memes in database -->
        <p class="no-memes">No memes in database.</p>
    </div>
</section>`;

const memeCard = (meme) => html `
<div class="meme">
    <div class="card">
        <div class="info">
            <p class="meme-title">Debugging</p>
            <img class="meme-image" alt="meme-img" src="/images/2.png">
        </div>
        <div id="data-buttons">
            <a class="button" href="#">Details</a>
        </div>
    </div>
</div>`;

export function catalogPage(ctx) {
    ctx.render(catalogTemplate());
}