"use strict";

import { Config } from "../config.mjs";
import { BoardService} from "../model/services/boards.service.mjs";
import { Pruebas } from "../model/services/Pruebas.services.mjs";

import { ProyectView } from "../view/components/proyect.component.mjs";

import { IndexView } from "../view/index.view.mjs";

class IndexController {
    #privateView;
    #boardService;   
    #prueba
    constructor() {
        this.#privateView = new IndexView();
        this.#boardService = new BoardService();
        this.#prueba = new Pruebas()
    }

    async init() {
        const boards = await this.#boardService.getBoards();  
        this.#privateView.init(boards);
        this.#prueba.prueba();
    }

    async delete(id) {
        return this.#boardService.deleteBoards(id);           
      }

      async create(objeto) {
       
          return this.#boardService.createBoards(objeto);    
      }

      async update(objeto, id){
          return this.#boardService.updateBoards(objeto, id);
      }


    
}


export const index = new IndexController();
index.init();



