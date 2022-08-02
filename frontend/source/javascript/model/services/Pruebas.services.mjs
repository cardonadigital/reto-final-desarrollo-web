import { IndexView } from "../../view/index.view.mjs";
import { boardModel } from "../boards.model.mjs";

export class Pruebas{
    #privateView;
 
    constructor() {
      this.#privateView = new IndexView();
    }

    prueba(){
        const on = (element, event, selector, handler) => {
            element.addEventListener(event, (e) => {
              if (e.target.closest(selector)) {
                e.preventDefault();
                handler(e);
              }
            });
          };
          
          
          on(document, "click", ".proyect", (e) => {
            const proyect = e.target.getAttribute('value');

            window.location.href("http://127.0.0.1:5500/source/columns.html")
    });


    /**
     * delete board
     */
    const deleteElements = document.querySelectorAll('#delete');
    deleteElements.forEach(element=>{
      element.addEventListener("click", (e)=>{
        let boardId = e.target.getAttribute('value');
        console.log(boardId);
        fetch(`http://localhost:8080/api/v1/board/${boardId}`, {
          method: 'DELETE'
        })
        .then((response) => response.json())
        .then((data)=> console.log(`elemento eliminado ${data}`))
        .catch((error) => console.log(`algo sucedio: ${error}`));
      })
    })

    /**
     * update board (FALTA CONSEGUIR DATOS DE UN CUESTIONARIO)
     */


    const updateElements = document.querySelectorAll('.formBoard');
    updateElements.forEach(element=>{
      element.addEventListener("click", (e)=>{
        let boardName = document.getElementById('updateBoard').value;
        let id = e.target.getAttribute('id');
        console.log(id);
        let json = `{"name": "${boardName}", "createdAt": null, "updatedAt": null}`
        console.log(json);
        fetch(`http://localhost:8080/api/v1/board/${id}`, {
          method: 'PUT',
          body: json,
          headers:{
            'Content-Type': 'application/json'
          }
        })
        .then((response) => response.json())
        .then((data)=> console.log(`elemento actualizado ${data}`))
        .catch((error) => console.log(`algo sucedio: ${error}`));
      })
    })
}


  sendBoard(){
    const update = document.querySelectorAll('#update');
    update.forEach(element=>{
      element.addEventListener("click", (e)=>{
        let boardId = e.target.getAttribute('value');
        fetch(`http://localhost:8080/api/v1/board/${boardId}`)
        .then((response) => response.json())
        .then((data)=> this.#privateView.edit(data))
        .catch((error) => console.log(`algo sucedio: ${error}`));
      })
    })
  }



};