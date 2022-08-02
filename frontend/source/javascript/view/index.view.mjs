"use strict";

import { ProyectView } from "./components/proyect.component.mjs";

export class IndexView {
  #privateProyect;
  #boardController;
  #structure;

  constructor(boardController) {
    this.#boardController = boardController;
    this.#privateProyect = document.querySelector(".krello-container");
  }

  init(boards) {
    const titulo = document.createElement("h2");
    titulo.textContent = "Tus espacios de trabajo";
    titulo.classList.add("titulo");
    const contenedor = document.createElement("div");
    contenedor.classList.add("proyects", "d-flex",  "justify-content-center");
    this.#structure = contenedor;
    const boton = document.createElement("button");
    boton.classList.add("button");
    boton.textContent= 'Agregar'
    boton.classList.add("button")
    boton.setAttribute("data-bs-toggle", "modal");
    boton.setAttribute("data-bs-target", "#staticBackdrop");
    
    this.#privateProyect.append(titulo, this.#structure,  boton);
    boards.forEach((boards) => {
      new ProyectView(boards, this.#structure, this.#boardController);
    });
  }

 

  edit(data){
    let name = data.data.name;
    console.log(data.data.name);
    let formTitle = document.querySelector('.modal-title');
    formTitle.textContent = name;


    /* let Logs = ; */

    let formBoard = document.querySelector('.formBoard');
    formBoard.setAttribute('id', data.data.id);
    formBoard.addEventListener("click", function(e){
      alert(e.target.id)
      console.log(data);
    })
    
  }
}
