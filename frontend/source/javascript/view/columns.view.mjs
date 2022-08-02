'use strict';

import { Column } from "./components/columns.component.mjs";



export class ColumnsView {

    #privateBody;
    #privateColumn;
    #createCard
    #createImage
    #createTile
    

    constructor() {
        this.#privateBody = document.querySelector('.body2');

    }


    init(columns) {
        const backlog = document.createElement('div')
        backlog.classList.add('backlog')

        columns.forEach(element => {
            new Column(element, backlog)
        });

       
        this.#privateBody.append(backlog);
    }


    form(data){
        console.log(data);
        const taskName = document.querySelector('.taskName');
        taskName.setAttribute('value', `${data.data.name}`)

        const taskDescription = document.querySelector('.taskDescription');
        taskDescription.setAttribute('value', `${data.data.description}`)

        const submitUpdateTask = document.querySelector('.submitUpdateTask');
        submitUpdateTask.setAttribute('value', `${data.data.id}`)
        submitUpdateTask.setAttribute('id', `${data.data.idColumn}`)


        const showTaskName = document.querySelector('.showTaskName');
        showTaskName.textContent = `titulo: ${data.data.name}`;

        const showTaskDescription = document.querySelector('.showTaskDescription');
        showTaskDescription.textContent = `description: ${data.data.description}`;

        const showTaskCreate = document.querySelector('.showTaskCreate');
        showTaskCreate.textContent = `created: ${data.data.created}`;

        
        let logData = '';

        let logs = data.data.logs;
        logs.forEach(element =>{
            logData += `
            <div class="text-center container row">
                <p class="col-md-6">previous ID: ${element.previousId}</p>
                <p class="col-md-6">current ID: ${element.currentId}</p>
            </div>
                `
        })

        let showLogs = document.querySelector('.showLogs');
        showLogs.innerHTML = logData;

        
    }


    create(){

    }
   

}