package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.scalajs.dom.document
import org.scalajs.dom.html

@react class LoginComponent extends Component {
    case class Props(doLogin: () => Unit)
    case class State(bool: Boolean, loginName: String, createName: String, loginPass: String, createPass: String, loginMessage: String, createMessage: String)
def initialState: State = State(true, "", "", "", "", "", "")

def render(): ReactElement = div (
    h1("Login"),
    br(),
    "Username: ",
    input(`type` := "text", value := state.loginName, onChange := (e => setState(state.copy(loginName = e.target.value)))),
    br(),
    "Password: ",
    input(`type` := "text", value := state.loginPass, onChange := (e => setState(state.copy(loginPass = e.target.value)))),
    br(),
    "Message: ",
    input(`type` := "text", value := state.loginMessage, onChange := (e => setState(state.copy(loginMessage = e.target.value)))),
    br(),
    button("Login", onClick := (e => login())),
    state.loginMessage,
    br(),
    )

    def login(): Unit = {
            if (state.bool){
                println("Your are logged 1 in is " + state.bool)
                setState(state.copy(bool = false))
                props.doLogin()
            } else {
                setState(state.copy(loginMessage = "Login Failed"))
                println("Your are logged 2 in is " + state.bool + " " + state.loginMessage)
                setState(state.copy(bool = true))
            }
        }

}