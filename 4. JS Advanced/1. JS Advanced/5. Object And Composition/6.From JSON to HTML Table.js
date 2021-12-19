function JsonToHtmlTable(json) {
    let arr = JSON.parse(json);

    let outputArr = ["<table>"];
    outputArr.push('   <tr>' + makeKeyRow(arr) + '</tr>');

    arr.forEach((obj) => outputArr.push('   <tr>' + makeValueRow(obj) + '</tr>'));
    outputArr.push("</table>");

    function makeKeyRow(arr) {
        let tRow = [];
        for (const tables of arr) {
            tRow.push(Object.keys(tables));
        }

        let str = '';
        for (const iterator of tRow[0]) {
            str += `<th>${escapeHtml(iterator)}</th>`;
        }
        return str;
    };

    function makeValueRow(obj) {

        let str = '';
        for (const iterator of Object.values(obj)) {
            let ss = escapeHtml(iterator);
            str += `<td>${ss}</td>`;
        }
        return str;
    };

    function escapeHtml(value) {
        return value
            .toString()
            .replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;')
            .replace(/\s+/g, '');
    };

    console.log(outputArr.join('\n'));
};

JsonToHtmlTable(`[{"Name":"Stamat",
"Score":5.5},
{"Name":"Rumen",
"Score":6}]`);

// JsonToHtmlTable(`[{"Name":"Pesho",
// "Score":4,
// " Grade":8},
// {"Name":"Gosho",
// "Score":5,
// " Grade":8},
// {"Name":"Angel",
// "Score":5.50,
// " Grade":10}]`);