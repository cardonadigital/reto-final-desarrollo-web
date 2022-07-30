'use strict';

export class columnsModel {
   #id;
   #taskId;
   #previousId;
   currentId;
   created
    

    constructor(id, name, tasks) {
           this.#id = id;
           this.#name= name;
           this.#tasks =tasks;

    }
    
    get id() {
        return this.#id;
    }


    get name() {
        return this.#name;
    }


    get tasks() {
        return this.#tasks;
    }

}