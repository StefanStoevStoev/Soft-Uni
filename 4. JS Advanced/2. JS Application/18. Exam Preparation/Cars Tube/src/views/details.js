import { editCar, deleteCar, getCarById } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (car, isOwner, onDelete) => html `
<section id="listing-details">
    <h1>Details</h1>
    <div class="details-info">
        <img src="${car.imageUrl}">
        <hr>
        <ul class="listing-props">
            <li><span>Brand:</span>${car.brand}</li>
            <li><span>Model:</span>${car.model}</li>
            <li><span>Year:</span>${car.year}</li>
            <li><span>Price:</span>${car.price}$</li>
        </ul>

        <p class="description-para">${car.description}
        </p>

        ${isOwner 
        ? html`
        <div class="listings-buttons">
            <a href="/edit/${car._id}" class="button-list">Edit</a>
            <a @click=${onDelete} href="javascript:void(0)" class="button-list">Delete</a>
        </div>`
         : null
        }

    </div>
</section>`;

const bookControlsTemplate = (book, isOwner, onDelete) => {
    if (isOwner) {
        return html `
        <a class="button" href="/edit/${book._id}">Edit</a>
        <a @click=${onDelete} class="button" href="javascript:void(0)">Delete</a>`;
    } else {
        return null;
    }
};

const likeControlTemplate = (showLikeBtn) => {
    if (showLikeBtn) {
        return html `<a class="button" href="javascript:void(0)">Like</a>`;
    } else {
        return null;
    }
}

export async function detailsPage(ctx) {
    const userData = getUserData();

    const car = await getCarById(ctx.params.id);

    const isOwner = userData && userData.id == car._ownerId;

    ctx.render(detailsTemplate(car, isOwner, onDelete));

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete ${car.brand}`);

        if (choice) {
            await deleteCar(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    }
}