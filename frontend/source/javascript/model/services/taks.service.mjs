
import { taskModel } from "../task.model.mjs";

export class TaskService {

  
  async getTasks() {

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
}

}