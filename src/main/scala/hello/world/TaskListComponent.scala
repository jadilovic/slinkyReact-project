package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class TaskListComponent extends Component {
    case class Props(doLogout: () => Unit )
    case class State(tasks: List[String], newTask: String, taskMessage: String)
    def initialState: State = State(Nil, "", "")

    override def componentDidMount(): Unit = {
        loadTasks()
    }

    def render(): ReactElement = div(
        ul(
            state.tasks.zipWithIndex.map{
                case (taskItem, i) => 
                    li(key := i.toString(), taskItem, onClick := (e => deleteTask(taskItem)))
            }
        ),
        "Create new task: ",
        input(`type` := "text", value := state.newTask, onChange := (e => setState(state.copy(newTask = e.target.value)))),
        br(),
        button("Submit", onClick := (e => addTask())),
        br(),
        state.newTask,
        br(),
        button("Logout", onClick := (e => props.doLogout()))
    )

    def deleteTask(task: String): Unit = {
        val newList = state.tasks.filter(item => item != task)
        setState(state.copy(tasks = newList))
        println(newList)
    }

    def addTask(): Unit = {
        val newList = state.newTask :: state.tasks
        setState(state.copy(newTask = ""))
        println(newList)
        setState(state.copy(tasks = newList))
    }

    def loadTasks(): Unit = {
        setState(state.copy(tasks = List("Java", "JS")))
    }
}