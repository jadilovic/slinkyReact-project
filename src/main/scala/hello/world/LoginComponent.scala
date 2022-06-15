package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class LoginComponent extends Component {
    type Props = Unit
    case class State(loginName: String, createName: String, loginPass: String, createPass: String, loginMessage: String, createMessage: String)
def initialState: State = State("", "", "", "", "", "")

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
    "Hello : !",
    br(),
    )
}