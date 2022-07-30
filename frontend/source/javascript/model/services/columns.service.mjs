export class ColumnsService {

    async getColumns() {

        const {data} = await fetch(Config.ApiBoards)
        const columns = new Array();

        data.data.forEach(({ id, name, createdAt, updatedAt, columnsForBoard }) =>
            columns.push(new boardModel(id, name, createdAt, updatedAt, columnsForBoard))
        );

        return columns;

    }


   async deleteColumns(id) {
        await fetch(Config.ApiColumns + id, {
            method: 'DELETE'
        })
    }

    createColumns(objeto) {
        await fetch(Config.ApiColumns, {
            method: 'POST',
            body: JSON.stringify(objeto),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        })
    }

  updateColumns(id, objeto){
    await fetch(Config.ApiColumns + id, {
        method: 'PUT',
        body: JSON.stringify(objeto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    })
  }
    

}