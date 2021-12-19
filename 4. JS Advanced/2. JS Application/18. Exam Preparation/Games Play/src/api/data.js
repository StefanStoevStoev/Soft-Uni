import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function getAllGames() {
    return api.get('/data/games?sortBy=_createdOn%20desc');
}

export async function getGameById(id) {
    return api.get('/data/games/' + id);
}

export async function getLastThreeGames() {
    return api.get(`/data/games?sortBy=_createdOn%20desc&distinct=category`);
}

export async function createGame(game) {
    return api.post('/data/games', game);
}

export async function editGames(id, game) {
    return api.put('/data/games/' + id, game);
}

export async function deleteGame(id) {
    return api.del('/data/games/' + id);
}

// export async function likeBook(bookId) {
//     return api.post('/data/likes', {
//         bookId
//     });
// }

// export async function getLikesByBookId(bookId) {
//     return api.get(`/data/likes?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`);
// }

// export async function getMyLikeByBookId(bookId, userId) {
//     return api.get(`/data/likes?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
// }