import { TaskService, taskService } from "../model/services/taks.service.mjs";

class TasksController {
    #privateView;
    #taskService;   
    constructor() {
        // this.#privateView = new IndexView();
        // this.#taskService = new TaskService();
    }

    async init() {
        // const tasks = await this.#taskService.getTasks();  
        this.#privateView.init(tasks);
    }

    async delete(id) {
        // return this.#taskService.deleteTasks(id);           
      }

      async create(objeto) {
       
        //   return this.#taskService.createTasks(objeto);    
      }

      async update(objeto,id){
        //   return this.#taskService.edit(objeto, id);
      }
}


export const index = new IndexController();
index.init();
