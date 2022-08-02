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
    <div class="text-center proyect h-75"  onclick='window.location.href="http://127.0.0.1:5500/frontend/source/columns.html?id=${this.#board.id}"'>
          <h3>${this.#board.name}</h3>
      </div>
      <div class="d-flex h-25">
          <button type="button" class="menu dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659022047/mas_2_qp3qtn.png" alt="MDN">
          </button>
          <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#" id="delete" value="${this.#board.id}">Eliminar</a></li>
              <li><a class="dropdown-item" href="#" id="update" value="${this.#board.id}" data-bs-toggle="modal" data-bs-target="#editModal">Editar</a></li>
            </ul>
          </div>
    </div>


    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form action="">
            <label for="">cambiar nombre</label>
            <input type="text" name="name" placeholder="" id="updateBoard">
            <input type="submit" value="Submit" class="formBoard" id="">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          </form>
        </div>
      </div>
    </div>
  </div>


  
  <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Crear tablero</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
          <form id="formulario">
          <div class="form">
            <label for="nombreBoard">Nombre tablero</label>
            <input name="nombreBoard" id="nombreBoard">
            <button type="submit" onclick="#submitBoard()" id="create" >Guardar</button>
          </div>
          </form>
          </div>
         
        
        </div>
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




