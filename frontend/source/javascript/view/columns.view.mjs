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


    init(columns) {
        const backlog = document.createElement('div')
        backlog.classList.add('backlog')

        columns.forEach(element => {
            new Column(element, backlog)
        });

       
        this.#privateBody.append(backlog);

    }
   

}