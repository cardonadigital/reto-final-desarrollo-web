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
     
    <div class="proyecto">
    <div class="text-center proyect h-75"  onclick='window.location.href="http://127.0.0.1:5500/source/columns.html?id=${this.#board.id}"'>
          <h3>${this.#board.name}</h3>
      </div>
      <div class="d-flex h-25">
          <button type="button" class="menu dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659022047/mas_2_qp3qtn.png" alt="MDN">
          </button>
          <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#" id="delete" value="${this.#board.id}">Eliminar</a></li>
              <li><a class="dropdown-item" href="#" id="update" value="${this.#board.id}">Editar</a></li>
            </ul>
          </div>
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




