'use strict';

export class boardModel {
    #privateID;
    #privateName;
    #privateCreatedAt;
    #privateUpdatedAt;
    #privateColumnsForBoard
    


    constructor(id, name, createdAt, updatedAt, columsForBoard) {
            this.#privateID = id;
            this.#privateCreatedAt = createdAt;
            this.#privateUpdatedAt = updatedAt;
            this.#privateName = name
            this.#privateColumnsForBoard = columsForBoard;
    }

    get id() {
        return this.#privateID;
    }


    get name() {
        return this.#privateName;
    }


    get createdAt() {
        return this.#privateCreatedAt;
    }

    get updatedAt() {
        return this.#privateUpdatedAt;
    }
   

    get columsForBoard() {
        return this.#privateColumnsForBoard;
    }

}