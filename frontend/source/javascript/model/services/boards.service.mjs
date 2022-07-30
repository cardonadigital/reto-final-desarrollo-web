import { Config } from "../../config.mjs";
import { boardModel } from "../boards.model.mjs";

export class BoardService {

    async getBoards() {
        const peticion = await fetch(`${Config.ApiBoards}/`)
        const data = await peticion.json()
        const boards = new Array();
        data.data.forEach(({ id, name, createdAt, updatedAt, columnsForBoard }) =>
            boards.push(new boardModel(id, name, createdAt, updatedAt, columnsForBoard))
        );
        return boards;

    }
  async deleteBoards(id) {
        await fetch(Config.ApiBoards + id, {
            method: 'DELETE'
        })
    }

   async createBoards(objeto) {
        await fetch(Config.ApiBoards, {
            method: 'POST',
            body: JSON.stringify(objeto),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        })
    }

  async updateBoards(id, objeto){
    await fetch(Config.ApiBoards + id, {
        method: 'PUT',
        body: JSON.stringify(objeto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    })
  }
    

}