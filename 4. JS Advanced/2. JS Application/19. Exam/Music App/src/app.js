import { page, render } from './lib.js';
import { homePage } from './views/home.js';
import { catalogPage } from './views/catalog.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { logout } from './api/data.js';
import { getUserData } from './util.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';

// import * as api from './api/data.js';
// window.api = api;
const root = document.querySelector('#main-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);
page(decorateContext);
page('/', homePage);
page('/catalog', catalogPage);
page('/login', loginPage);
page('/register', registerPage);
// page('/logout', onLogout);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);

updateUserNav();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}

export function updateUserNav() {
    const userData = getUserData();
    if (userData) {
        document.getElementById('login').style.display = 'none';
        document.getElementById('register').style.display = 'none';
        document.getElementById('create').style.display = 'inline-block';
        document.getElementById('logoutBtn').style.display = 'inline-block';
    } else {
        document.getElementById('login').style.display = 'inline-block';
        document.getElementById('register').style.display = 'inline-block';
        document.getElementById('create').style.display = 'none';
        document.getElementById('logoutBtn').style.display = 'none';
    }
}