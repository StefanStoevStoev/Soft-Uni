function solve(obj) {

    validateMethod(obj);
    validateUri(obj);
    validateVersion(obj);
    validateMessage(obj);

    return obj;

    function validateMessage(obj) {
        let propName = 'message';
        let messageRegex = /^[^<>\\&'"]*$/;

        if (obj[propName] === undefined ||
            !messageRegex.test(obj[propName])) {
            throw new Error(`Invalid request header: Invalid Message`);
        }
    }

    function validateVersion(obj) {
        let propName = 'version';
        let validVersion = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
        if (obj[propName] === undefined ||
            !validVersion.includes(obj[propName])) {
            throw new Error(`Invalid request header: Invalid Version`);
        }
    }

    function validateUri(obj) {
        let propName = 'uri';
        let uriRegex = /^\*$|^[a-zA-Z0-9.]+$/;

        if (obj[propName] === undefined || !uriRegex.test(obj[propName])) {
            throw new Error(`Invalid request header: Invalid URI`);
        }
    }

    function validateMethod(obj) {
        let validMethod = ['GET', 'POST', 'DELETE', 'CONNECT'];
        let propName = 'method';

        if (obj[propName] === undefined || !validMethod.includes(obj[propName])) {
            throw new Error(`Invalid request header: Invalid Method`);
        }
    }
}

// try {
//     console.log(solve({
//         method: 'GET',
//         uri: 'svn.public.catalog',
//         version: 'HTTP/1.1',
//         message: ''

//     }));
// } catch (a) {
//     throw new Error(a.message);
// }
try {
    {
        console.log(solve({
            method: 'OPTIONS',
            uri: 'git.master',
            version: 'HTTP/1.1',
            message: '-recursive'
        }));
    }

} catch (a) {
    throw new Error(a.message);
}