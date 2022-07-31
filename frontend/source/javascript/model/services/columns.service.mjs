import { Config } from "../../config.mjs";
import { columnsModel } from "../columns.model.mjs";

export class ColumnsService {

    async getColumns() {
 
        const urlParams = new URLSearchParams(window.location.search);
        let idParam = urlParams.get('id');
        let url =  `${Config.dto}` + `${idParam}`;

        console.log(url);
        const resp = await fetch(url);
        const data = await resp.json();

        const columns = new Array();
        console.log(data);
        data.data.forEach(({ id, name, tasks }) =>
          
            columns.push(new columnsModel(id, name, tasks))
        );

        return columns;

    }


    async deleteColumns(id) {
        await fetch(Config.ApiColumns + id, {
            method: 'DELETE'
        })
    }

    async createColumns(objeto) {
        await fetch(Config.ApiColumns, {
            method: 'POST',
            body: JSON.stringify(objeto),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        })
    }

    async updateColumns(id, objeto) {
        await fetch(Config.ApiColumns + id, {
            method: 'PUT',
            body: JSON.stringify(objeto),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        })
    }


}