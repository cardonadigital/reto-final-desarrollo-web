"use strict";


import { ColumnsService } from "../model/services/columns.service.mjs";
import { ColumnsView } from "../view/columns.view.mjs";



class columnsController {
    #privateView;
    #privateService;
    constructor() {
        this.#privateService = new ColumnsService();
        this.#privateView = new ColumnsView();
    }

    

    async init() {
        const params = new URLSearchParams(window.location.search);
		console.log(params.get("id"));

        const colums =  await this.#privateService.getColumns();
        console.log(colums);
        this.#privateView.init(colums);


    }
}

export const index = new columnsController();
index.init();