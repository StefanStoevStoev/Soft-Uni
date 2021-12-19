import { deleteTheater, getTheaterById, getLikesByThetherId, getMyLikeByThetherId, likeTheather } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (theather, isOwner, onDelete, likes, showLikeBtn, onLike) => html `
<section id="detailsPage">
    <div id="detailsBox">
        <div class="detailsInfo">
            <h1>Title: ${theather.title}</h1>
            <div>
                <img src="${theather.imageUrl}" />
            </div>
        </div>

        <div class="details">
            <h3>Theater Description</h3>
            <p>${theather.description}</p>
            <h4>Date: ${theather.date}</h4>
            <h4>Author: ${theather.author}</h4>

            ${theaterControlsTemplate(theather, isOwner, onDelete)}
            ${likeControlTemplate(showLikeBtn, onLike)}

            <p class="likes">Likes: ${likes}</p>
        </div>
    </div>
</section>`;

const theaterControlsTemplate = (theather, isOwner, onDelete) => {
    if (isOwner) {
        return html `<div class="buttons">
        <a @click=${onDelete} class="btn-delete" href="javascript:void(0)">Delete</a>
        <a class="btn-edit" href="/edit/${theather._id}">Edit</a>
        </div>`
    } else {
        return null;
    }
};
const likeControlTemplate = (showLikeBtn, onLike) => {
    if (showLikeBtn) {
        return html `<a @click=${onLike} class="btn-like" href="javascript:void(0)">Like</a>`;
    } else {
        return null;
    }
}

export async function detailsPage(ctx) {
    const userData = getUserData();

    // const theather = await getTheaterById(ctx.params.id);

    const [theather, likes, hasLike] = await Promise.all([
        getTheaterById(ctx.params.id),
        getLikesByThetherId(ctx.params.id),
        userData ? getMyLikeByThetherId(ctx.params.id, userData.id) : 0
    ]);

    const isOwner = userData && userData.id == theather._ownerId;
    const showLikeBtn = userData != null && isOwner == false && hasLike == false;

    ctx.render(detailsTemplate(theather, isOwner, onDelete, likes, showLikeBtn, onLike));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${theather.title}`);

        if (choice) {
            await deleteTheater(ctx.params.id);
            ctx.page.redirect('/');
        }
    }
    async function onLike() {
        await likeTheather(ctx.params.id);
        ctx.page.redirect('/details/' + ctx.params.id);
    }
}