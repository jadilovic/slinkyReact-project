package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class FirstComponent extends Component {
    case class Props(msg: String, back: () => Unit)
    case class State(text: String)
    
    def initialState: State = State("")
    def render(): ReactElement = div(
        h1(props.msg),
        input(`type`:= "text", value := state.text, onChange:=(e => setState(state.copy(text = e.target.value)))),
        button("Go back", onClick := (e => props.back())),
        p(state.text)
    )
}