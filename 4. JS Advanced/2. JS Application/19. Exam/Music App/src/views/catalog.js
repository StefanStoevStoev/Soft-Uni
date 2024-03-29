import { getAllAlbums } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const catalogTemplate = (albums) => html `
<section id="catalogPage">
    <h1>All Albums</h1>
    ${albums.length == 0
        ? html`<p>No Albums in Catalog!</p>`
        : albums.map(catalogAlbum)}
 </section>`;

const catalogTemplateBtn = (albums) => html `
<section id="catalogPage">
    <h1>All Albums</h1>
    ${albums.length == 0
        ? html`<p>No Albums in Catalog!</p>`
        : albums.map(catalogAlbumBtn)}
 </section>`;

const catalogAlbum = (album) => html `
<div class="card-box">
    <img src="${album.imgUrl}">
    <div>
        <div class="text-center">
            <p class="name">Name: ${album.name}</p>
            <p class="artist">Artist: ${album.artist}</p>
            <p class="genre">Genre: ${album.genre}</p>
            <p class="price">Price: ${album.price}</p>
            <p class="date">Release Date: ${album.releaseDate}</p>
        </div>

    </div>
</div>`;

const catalogAlbumBtn = (album) => html `
<div class="card-box">
    <img src="${album.imgUrl}">
    <div>
        <div class="text-center">
            <p class="name">Name: ${album.name}</p>
            <p class="artist">Artist: ${album.artist}</p>
            <p class="genre">Genre: ${album.genre}</p>
            <p class="price">Price: ${album.price}</p>
            <p class="date">Release Date: ${album.releaseDate}</p>
        </div>
        <div class="btn-group">
            <a href="/details/${album._id}" id="details">Details</a>
        </div>

    </div>
</div>`;


export async function catalogPage(ctx) {
    const albums = await getAllAlbums();
    const userData = getUserData();
    // console.log(userData);
    if(userData == null){
        ctx.render(catalogTemplate(albums));
    }else{
        ctx.render(catalogTemplateBtn(albums));
    }
}