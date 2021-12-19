import { getMyTheaters } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const myTheatersTemplate = (theather, theatersEmail) => html `
<section id="profilePage">
    <div class="userInfo">
        <div class="avatar">
            <img src="./images/profilePic.png">
        </div>
        <h2>${theatersEmail}</h2>
    </div>
    <div class="board">
        <!--If there are event-->
        ${theather.length == 0
            ? html`<div class="no-events">
                        <p>This user has no events yet!</p>
                    </div>`
            : theather.map(theatherEvent)}

        <!--If there are no event-->
        
    </div>
</section>`;

const theatherEvent = (theather) => html `
<div class="eventBoard">
    <div class="event-info">
        <img src="${theather.imageUrl}">
        <h2>${theather.title}</h2>
        <h6>${theather.date}</h6>
        <a href="/details/${theather._id}" class="details-button">Details</a>
    </div>
</div>`


export async function myTheaterPage(ctx) {
    const userData = getUserData();
    const theaters = await getMyTheaters(userData.id);
    const theatersEmail = userData.email;
    // console.log(theatersEmail, userData, userData.email);
    ctx.render(myTheatersTemplate(theaters, theatersEmail));
}