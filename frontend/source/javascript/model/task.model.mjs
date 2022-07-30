'use strict';

export class taskModel {
    #privateID;
    #privateColumn;
    #privateBoard;
    #privateName;
    #privateDescription;
    #privateDelivery;
    #privateCreated;
    #privateUpdated;
    #privateLogs;


    constructor(id, column, board, name, description, delivery, created, updated, logs) {
  
            this.#privateID = id;
            this.#privateColumn = column;
            this.#privateBoard = board
            this.#privateName = name
            this.#privateDescription =description;
            this.#privateDelivery = delivery;
            this.#privateCreated = created;
            this.privateUpdated = updated;
            this.#privateLogs= logs;

    }

    get ID() {
        return this.#privateID;
    }


    get Nombre() {
        return this.#privateName;
    }

    get Column() {
        return this.#privateColumn;
    }


    get Board() {
        return this.#privateBoard;
    }


    get Description() {
        return this.#privateDescription;
    }

    

    get Delivery() {
        return this.#privateDelivery;
    }



    get Created() {
        return this.#privateCreated;
    }

   

    get Updated() {
        return this.#privateUpdated;
    }

   

    
    get Logs() {
        return this.#privateLogs;
    }

   
}