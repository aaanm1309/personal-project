export interface Task {
    key: number;
    taskName: string,
    checked: boolean, 
    links?: any
}


export interface TaskCreate {
    taskName: string,
    user: UserCreate
}


export interface UserCreate {
    id: number
}
