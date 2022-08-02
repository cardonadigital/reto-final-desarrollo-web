import { taskModel } from "../task.model.mjs";
import { ColumnsView } from "../../view/columns.view.mjs";

export class TaskService {

    #privateView;
 
    constructor() {
      this.#privateView = new ColumnsView();
    }

  changeColumn() {
    const valores = window.location.search;
    const urlParams = new URLSearchParams(valores);
    //Accedemos a los valores
    const id = urlParams.get("id");
    let tasks = document.querySelectorAll(".changeColumn");
    tasks.forEach((element) => {
      element.addEventListener("click", (e) => {
        let idColumn = e.target.getAttribute("id");
        let idTask = e.target.parentNode.getAttribute("id");
        let taskName = e.target.parentNode.getAttribute("value");
        let currentColumn =
          e.target.parentNode.parentNode.parentNode.parentNode.parentNode.getAttribute(
            "id"
          );
        let json = `{"idColumn": ${idColumn}, "idBoard": ${id}, "name": "${taskName}"}`;
        console.log(json);
        fetch(`http://localhost:8080/api/v1/task/${idTask}`, {
          method: "PUT",
          body: json,
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then((response) => response.json())
          .then((data) => this.#sendLog(idTask, idColumn, currentColumn))
          .catch((error) => console.log(`algo sucedio: ${error}`));
      });
    });
  }

  #sendLog(idTask, idColumn, idCurretnColumn) {
    console.log(idTask, idColumn, idCurretnColumn);
    let json = `{"taskId": ${idTask}, "previousId": ${idCurretnColumn}, "currentId": ${idColumn}}`;
    fetch(`http://localhost:8080/api/v1/log`, {
      method: "POST",
      body: json,
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        console.log('log deleted');
        location.reload();
      })
      .catch((error) => console.log(`algo sucedio: ${error}`));
  }

  sendFormTask() {
    let tasks = document.querySelectorAll(".formTask");
    tasks.forEach((element) => {
      element.addEventListener("click", (e) => {
        e.preventDefault();
        var taskId = e.target.getAttribute("id");
        console.log(taskId);
        fetch(`http://localhost:8080/api/v1/task/${taskId}`)
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            this.#privateView.form(data);
          })
          .catch((error) => console.log(`algo sucedio: ${error}`));
      });
    });
  }



  updateTask() {
    const valores = window.location.search;
    const urlParams = new URLSearchParams(valores);
    //Accedemos a los valores
    const idBoard = urlParams.get("id");
    const submitTask = document.querySelector('.submitUpdateTask');
        submitTask.addEventListener('click', (e)=>{
            let idColumn = document.querySelector('.submitUpdateTask').getAttribute('id');
            let idTask = document.querySelector('.submitUpdateTask').getAttribute('value');
            let taskName = document.querySelector('.taskName').value;
            let taskDescription = document.querySelector('.taskDescription').value;
            let dateTask = document.querySelector('.dateTask').getAttribute('value');
            let date = new Date(dateTask);
            let dateTime = date.toISOString();
            let json = `{"idColumn": ${idColumn}, "idBoard": ${idBoard}, "name": "${taskName}", "description": "${taskDescription}", "delivery": "${dateTime}" }`;
            console.log(dateTime);
            fetch(`http://localhost:8080/api/v1/task/${idTask}`, {
                method: "PUT",
                body: json,
                headers: {
                  "Content-Type": "application/json",
                }
            })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
            })
            .catch((error) => console.log(`algo sucedio: ${error}`));
            location.reload();
            e.preventDefault();
        })
  }


  deleteTask(){
    let deleteTask = document.querySelectorAll('.deleteTask');
    deleteTask.forEach(element=>{
        element.addEventListener('click', (e)=>{
            let idTask = e.target.getAttribute('value');
            fetch(`http://localhost:8080/api/v1/task/${idTask}`, {
            method: 'DELETE'
            })
            .then((response) => response.json())
            .then((data)=> {
                console.log(`elemento eliminado ${data}`);
                location.reload();
            })
            .catch((error) => console.log(`algo sucedio: ${error}`));
        })
    })
  }

  createTask(){
    this.setColumnId();
    const valores = window.location.search;
    const urlParams = new URLSearchParams(valores);
    //Accedemos a los valores
    const idBoard = urlParams.get("id");
    const submitTask = document.querySelector('.submitUpdateTask');
    let createTask = document.querySelectorAll('.addTask');
    createTask.forEach(element=>{
        element.addEventListener('click', (e)=>{
            /* e.preventDefault(); */
            var idColumn = localStorage.getItem('idColumn');
            let taskName = document.querySelector('.taskNameCreate').value;
            let taskDescription = document.querySelector('.taskDescriptionCreate').value;
            let dateTask = document.querySelector('.dateTaskCreate').getAttribute('value');
            let date = new Date(dateTask);
            let dateTime = date.toISOString();
            let json = `{"idColumn": ${idColumn}, "idBoard": ${idBoard}, "name": "${taskName}", "description": "${taskDescription}", "delivery": "${dateTime}" }`;
            
            fetch(`http://localhost:8080/api/v1/task`, {
                method: "POST",
                body: json,
                headers: {
                  "Content-Type": "application/json",
                }
            })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                location.reload();
            })
            .catch((error) => console.log(`algo sucedio: ${error}`));
            e.preventDefault();
        })
    })
    
  }


  setColumnId(){
    const column1 = document.querySelector('#columnId1');
    column1.addEventListener('click', (e)=>{
        console.log('sddd');
        localStorage.setItem('idColumn', 1);
    })

    const column2 = document.querySelector('#columnId2');
    column2.addEventListener('click', (e)=>{
        localStorage.setItem('idColumn', 2);
    })


    const column3 = document.querySelector('#columnId3');
    column3.addEventListener('click', (e)=>{
        localStorage.setItem('idColumn', 3);
    })
  }

  /* async getTasks() {

    const {data} = await fetch(Config.ApiTasks)
    

    const Tasks = new Array();

    data.data.forEach(({ id, idColumn, idBoard, name, description, delivery, created, updated, logs }) =>
        Tasks.push(new boardModel( id, idColumn, idBoard, name, description, delivery, created, updated, logs))
    );

    return Tasks;

}


async deleteTasks(id) {
    await fetch(Config.ApiTasks + id, {
        method: 'DELETE'
    })
}

async createTasks(objeto) {
    await fetch(Config.ApiTasks, {
        method: 'POST',
        body: JSON.stringify(objeto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    })
}

async updateTasks(id, objeto){
await fetch(Config.ApiTasks + id, {
    method: 'PUT',
    body: JSON.stringify(objeto),
    headers: {
        "Content-Type": "application/json; charset=utf-8"
    }
})
} */
}
