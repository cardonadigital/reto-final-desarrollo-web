import { index } from "../../controller/columns.controller.mjs";

export class ProyectView {

  #board;
  #parentNode;
  #component;
  #boardController;

  constructor(boards, parenNode, boardController) {
    this.#boardController = boardController;
    this.#board = boards;
    this.#parentNode = parenNode;
    this.#component = this.#createComponent();
    this.#contenido();

  }


  #createComponent() {
    const contBoard = `
     
        <div class="proyect" onclick='window.location.href="http://127.0.0.1:5500/frontend/source/columns.html?id=${this.#board.id}"'>
            <h5>${this.#board.name}</h5>
             <button type="button" class="menu dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659022047/mas_2_qp3qtn.png" alt="MDN">
             </button>

             <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Eliminar</a></li>
                <li><a class="dropdown-item" href="#">Editar</a></li>
              </ul>
        </div>

        `

    const template = document.createElement("template");
    template.innerHTML = contBoard;
    template.content
    
  
    return template.content;
  }

 
  #contenido() {
    this.#parentNode.append(this.#component);
  }

}




