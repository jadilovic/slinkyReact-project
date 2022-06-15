package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Version7Component extends Component {
    type Props = Unit
    case class State(loggedIn: Boolean)

    def initialState: State = State(false)

    def render(): ReactElement = {
        if(state.loggedIn){
         div() //   TestDisplayComponent()
        } else {
            LoginComponent()
        }
    }
}