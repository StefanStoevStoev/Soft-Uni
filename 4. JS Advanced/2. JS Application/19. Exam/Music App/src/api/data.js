import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function createAlbum(body) {
    return api.post('/data/albums', body);
}

export async function getAllAlbums() {
    return api.get('/data/albums?sortBy=_createdOn%20desc&distinct=name');
}

export async function getAlbumsById(id) {
    return api.get('/data/albums/' + id);
}

export async function editAlbum(id, abum) {
    return api.put('/data/albums/' + id, abum);
}

export async function deleteAlbum(id) {
    return api.del('/data/albums/' + id);
}

export async function searchByAlbumName(albumId) {
    return api.get(`/data/albums?where=name%20LIKE%20%22${albumId}%22`);
}

// export async function getAllGames() {
//     return api.get('/data/games?sortBy=_createdOn%20desc');
// }

// export async function getRecentGames() {
//     return api.get('/data/games?sortBy=_createdOn%20desc&distinct=category')
// }

// export async function createGame(body) {
//     return api.post('/data/games', body);
// }

// export async function getGameById(id) {
//     return api.get('/data/games/' + id);
// }

// export async function editGame(id, game) {
//     return api.put('/data/games/' + id, game);
// }

// export async function deleteGame(id) {
//     return api.del('/data/games/' + id);
// }

// export async function getAllComments(gameId) {
//     return api.get(`/data/comments?where=gameId%3D%22${gameId}%22`);
// }

// export async function postComment(body) {
//     return api.post('/data/comments', body);
// }