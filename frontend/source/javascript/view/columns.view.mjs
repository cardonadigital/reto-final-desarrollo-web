'use strict';

import { Column } from "./components/columns.component.mjs";



export class ColumnsView {

    #privateBody;
    #privateColumn;
    #createCard
    #createImage
    #createTile
    

    constructor() {
        this.#privateBody = document.querySelector('.body2');
       

    }


    init() {
        const backlog = document.createElement('div')
        backlog.classList.add('backlog')
        const toDo = new Column("To-do", backlog);
        const inProgress = new Column("In Progress", backlog)
        const done = new Column("Done", backlog)
 
       
        // this.#privateBody.append(backlog);

    }
   

}