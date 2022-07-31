export class Column {
    #column;
    #parentNode;
    #component;
    #tasks = '';

    constructor(column, parenNode) {
        this.#column = column
        this.#parentNode = parenNode;
        this.getTasks();
        this.#component = this.createComponent();
        this.addContent();
        console.log(this.#tasks);
        
    }

    getTasks() {
      this.#column.tasks.forEach(element => {
        this.#tasks +=`
        <div class="container-tarea" data-bs-toggle="modal" data-bs-target="#exampleModal">
        <div class="tarea">
          <p class="nombre-tarea">${element.name}</p>
        </div>
  
        <div>
          <div class="fecha">
            <img class="reloj" src="https://res.cloudinary.com/paolavbm/image/upload/v1659069920/reloj_2_zcu6nl.png"
              width="16px" height="16px">
            18 de jul.
          </div>
        </div>
      </div>
        `
      });
    }


    createComponent() {
        const columns = `
    <div class="column">
    <div class="flex">
      <h6 class="tablas-titulo">${this.#column.name}</h6>
      <button type="button" class="dropdown-toggle boton" role="button" data-bs-toggle="dropdown"
        aria-expanded="false">
        <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659061014/mas_4_ck96bt.png" alt="MDN">
      </button>

      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#">Agregar</a></li>
        <li><a class="dropdown-item" href="#">Editar</a></li>
        <li><a class="dropdown-item" href="#">Eliminar</a></li>
      </ul>
    </div>

        ${this.#tasks}
        
    <div class="sticky-bottom agregar">
      <img class="mas" src="https://res.cloudinary.com/paolavbm/image/upload/v1659094757/mas_5_djwimz.png" alt="mdn"
        width="18em">
      <p class="mas">Añadir tarjeta</p>
    </div>

  </div>

  `
      console.log(this.#column.tasks);
        const fragnmet = document.createElement("template");
        fragnmet.innerHTML = columns;
        return fragnmet.content;
    }

    addContent() {
        this.#parentNode.append(this.#component);
    }

}