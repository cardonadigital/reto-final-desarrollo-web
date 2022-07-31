export class Pruebas{

 
    constructor() {
       
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
    const updateElements = document.querySelectorAll('#update');
    updateElements.forEach(element=>{
      element.addEventListener("click", (e)=>{
        let boardId = e.target.getAttribute('value');
        let json = {name: 'prueba up', createdAt: null, updatedAt: null}
        console.log(boardId);
        fetch(`http://localhost:8080/api/v1/board/${boardId}`, {
          method: 'PUT',
          body: JSON.stringify(json),
          headers:{
            'Content-Type': 'application/json'
          }
        })
        .then((response) => response.json())
        .then((data)=> console.log(`elemento actualizado ${data}`))
        .catch((error) => console.log(`algo sucedio: ${error}`));
      })
    })
    
   
}};