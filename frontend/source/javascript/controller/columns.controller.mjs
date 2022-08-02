"use strict";


import { ColumnsService } from "../model/services/columns.service.mjs";
import { TaskService } from "../model/services/taks.service.mjs";
import { ColumnsView } from "../view/columns.view.mjs";



class columnsController {
    #privateView;
    #privateService;
    #task
    constructor() {
        this.#privateService = new ColumnsService();
        this.#privateView = new ColumnsView();
        this.#task = new TaskService();
    }

    

    async init() {
        const params = new URLSearchParams(window.location.search);
		console.log(params.get("id"));

        const colums =  await this.#privateService.getColumns();
        console.log(colums);
        this.#privateView.init(colums);
        this.#task.changeColumn();
        this.#task.sendFormTask();
        this.#task.updateTask();
        this.#task.deleteTask();
        this.#task.createTask();
    }
}

export const index = new columnsController();
index.init();