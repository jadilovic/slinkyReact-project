package hello.world

import slinky.core.annotations.react
import slinky.core.Component
import slinky.core.facade.ReactElement
import slinky.web.html.div
import slinky.web.html.h1
import slinky.web.html.button
import slinky.web.html.onClick

@react class TopComponent extends Component {
    type Props = Unit
    case class State(showingInput: Boolean)
    def initialState: State = State(false)

    def render(): ReactElement = {
        if (state.showingInput){
            FirstComponent("Enter input", () => setState(state.copy(showingInput = false)))
        } else {
            div(
                h1("Top Level"),
                button("View input", onClick := (e => setState(state.copy(showingInput = true))))
            )
        }
    }
}