"use strict";


import { ColumnsView } from "../view/columns.view.mjs";



class columnsController {
    #privateView;
  
    constructor() {
        
        this.#privateView = new ColumnsView();
    }

    async init() {
        this.#privateView.init();

    }
}

export const index = new columnsController();
index.init();