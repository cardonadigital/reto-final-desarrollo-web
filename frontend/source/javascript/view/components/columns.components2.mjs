export class Columns2 {

    #privateColumns;

    constructor() {
        this.#privateGenerateColumns();
    }

    get() {
        return this.#privateColumns;
    }

    #privateGenerateColumns() {
        const divColumn = document.createElement('div');
        divColumn.classList.add('backlog');
        
        const column = document.createElement('div');
        column.classList.add('column');


        const flex = document.createElement('div');
        flex.classList.add('flex');


        const h6 = document.createElement('h6');
        h6.classList.add('tablas-titulo');
        h6.textContent="To do"

        divColumn.append(column)
        column.append(h6, flex)
        flex.innerHTML = `
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

        <div class="container-tarea" data-bs-toggle="modal" data-bs-target="#exampleModal">
        <div class="tarea">
          <p class="nombre-tarea">Holi Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus doloremque
            est vero numquam soluta nulla quam sint! Suscipit pariatur aspernatur molestiae quo eum. Quis voluptatibus
            repudiandae voluptate facilis ad debitis?</p>
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
           this.#privateColumns = divColumn;
    }
}