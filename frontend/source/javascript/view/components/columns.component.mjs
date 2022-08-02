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


  }

  getTasks() {
    this.#column.tasks.forEach(element => {
      this.#tasks += `
        <div class="container-tarea" id ="${element.id}">
        <div class="tarea">
          <p class="nombre-tarea">${element.name}</p>
        </div>
  
        <div class="d-flex justify-content-between">
          <div class="fecha">
            <img class="reloj" src="https://res.cloudinary.com/paolavbm/image/upload/v1659069920/reloj_2_zcu6nl.png"
              width="16px" height="16px">
            18 de jul.
          </div>



<div class="containerBotones">
          <div class="dropdown">
          <button class="btn dropdown-toggle btn-sm" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false"> 
          <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659413145/avance-rapido_crcylb.png" width="10px">
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1" id=${element.id} value="${element.name}">
            <a class="dropdown-item changeColumn" href="#" id ="1">Por realizar</a>
            <a class="dropdown-item changeColumn" href="#" id ="2">En proceso/a>
            <a class="dropdown-item changeColumn" href="#" id ="3">Terminado</a>
          </ul>
        </div>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-sm formTask" id="${element.id}" data-bs-toggle="modal" data-bs-target="#form">
        <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659413145/lupa_4_z0klfy.png" width="10px">
          </button>


          <button type="button" class="btn  btn-sm deleteTask" value=${element.id}>
          <img src="https://res.cloudinary.com/paolavbm/image/upload/v1659413146/cerrar_y4qk72.png" width="10px">
          </button>
</div>
        </div>
      </div>
  
        `
    });
  }


  createComponent() {
    const columns = `
    <div class="column" id="${this.#column.id}">
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
        
    <div class="sticky-bottom agregar" id="columnId${this.#column.id}" style="z-index:1" data-bs-toggle="modal" data-bs-target="#createTask">
      <img class="mas" src="https://res.cloudinary.com/paolavbm/image/upload/v1659094757/mas_5_djwimz.png" alt="mdn"
        width="18em">
      <p class="mas">Añadir tarjeta</p>
    </div>

  </div>




  <!-- Modal -->
  <div class="modal fade" id="form" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Tarea</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-center">
              <div class="card">
                  <form>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input type="text" class="form-control taskName" value="">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">descripción</label>
                        <input type="text" class="form-control taskDescription" value="">
                      </div>
                      <div class="form-check">
                          <label class="form-check-label" for="exampleCheck1">Fecha de entrega</label>
                          <input type="date" class="mt-2 dateTask" value="2022-09-01">
                      </div>
                      <div class="mt-2 mb-2">
                      <button type="submit" class="btn btn-primary submitUpdateTask">Update</button>
                      </div>
                    </form>
              </div>

              <h2 class="mt-5">Informacion Tarea: </h2>

              <div class="text-center card">
                <h3 class="showTaskName">name: </h3>
                <p class="showTaskDescription">description: </p>
                <p class="showTaskCreate">created: </p>

                <h4>historial logs: </h4>
                <div class="showLogs">
                <p class="">previous</p>
                <p class="">current</p>

                </div>

              </div>



          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>






    <!-- Modal -->
  <div class="modal fade" id="createTask" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-center">
              <div class="card">
                  <form>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input type="text" class="form-control taskNameCreate" value="">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">descripción</label>
                        <input type="text" class="form-control taskDescriptionCreate" value="">
                      </div>
                      <div class="form-check">
                          <label class="form-check-label" for="exampleCheck1">Fecha de entrega</label>
                          <input type="date" class="mt-2 dateTaskCreate" value="2022-09-01">
                      </div>
                      <div class="mt-5">
                      <button type="submit" id="create" class=" addTask">Submit</button>
                      </div>
                    </form>
              </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          </div>
        </div>
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