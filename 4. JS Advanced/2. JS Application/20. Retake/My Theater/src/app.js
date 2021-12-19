import * as api from './api/data.js';
window.api = api;

import { page, render } from './lib.js';
import { getUserData } from './util.js';
import { logout } from './api/data.js';
import { loginaPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { homePage } from './views/home.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { myTheaterPage } from './views/profile.js';

const root = document.getElementById('content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', homePage);
page('/login', loginaPage);
page('/register', registerPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/profile', myTheaterPage);


updateUserNav();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;

    next();
}

function updateUserNav() {
    const userData = getUserData();
    if (userData) {
        document.getElementById('profile').style.display = 'inline-block';
        document.getElementById('create').style.display = 'inline-block';
        document.getElementById('logoutBtn').style.display = 'inline-block';
        document.getElementById('login').style.display = 'none';
        document.getElementById('register').style.display = 'none';
    } else {
        document.getElementById('profile').style.display = 'none';
        document.getElementById('create').style.display = 'none';
        document.getElementById('logoutBtn').style.display = 'none';
        document.getElementById('login').style.display = 'inline-block';
        document.getElementById('register').style.display = 'inline-block';
    }
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}