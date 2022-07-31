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

            window.location.href("http://127.0.0.1:5500/frontend/source/columns.html")
    })
   
}};