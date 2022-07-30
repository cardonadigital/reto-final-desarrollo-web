export class Column {
    #name;
    #parentNode;
    #component;

    constructor(name, parenNode) {
        this.#name = name
        this.#parentNode = parenNode;
        this.#component = this.#createComponent();
        this.#addContent();
    }

    #createComponent() {
        const columns = `
    <div class="column">
    <div class="flex">
      <h6 class="tablas-titulo">${this.#name}</h6>
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

    <div class="sticky-bottom agregar">
      <img class="mas" src="https://res.cloudinary.com/paolavbm/image/upload/v1659094757/mas_5_djwimz.png" alt="mdn"
        width="18em">
      <p class="mas">Añadir tarjeta</p>
    </div>

  </div>

  `
        const fragnmet = document.createElement("template");
        fragnmet.innerHTML = columns;
        return fragnmet.content;
    }

    #addContent() {
        this.#parentNode.append(this.#component);
    }

}