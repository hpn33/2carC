package h.car2.screen.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.GdxRuntimeException
import com.badlogic.gdx.utils.ObjectMap
import h.car2.screen.Renderer
import ktx.log.debug
import ktx.scene2d.KTableWidget
import ktx.scene2d.table


class StateManager<StateType : State> {


	private val states: ObjectMap<Class<out StateType>, StateType> = ObjectMap()
	internal val stage = Stage()

	private val renderer = Renderer()


	private var currentState: State =
			object : State {
				override val layout = table {}
			}

	val shownState: StateType
		@Suppress("UNCHECKED_CAST")
		get() = currentState as StateType


	inline fun <reified Type : StateType> add(state: Type) = add(Type::class.java, state)
	fun <Type : StateType> add(type: Class<Type>, state: Type) {

		!states.containsKey(type) || throw GdxRuntimeException("state already registered to type: $type.")
		states.put(type, state)

		state.layout.isVisible = false
		stage.addActor(state.layout)

		debug { "SM:: add ${type.simpleName}" }


		setInput()

	}


	inline fun <reified Type : StateType> set() = set(Type::class.java)
	fun <Type : StateType> set(type: Class<Type>) {

		currentState.layout.isVisible = false
		currentState.reset()

		currentState = get(type)

		currentState.layout.isVisible = true
		currentState.load()

		debug { "SM:: set ${type.simpleName} " }


	}

	inline fun <reified Type : StateType> get(): Type = get(Type::class.java)
	@Suppress("UNCHECKED_CAST")
	fun <Type : StateType> get(type: Class<Type>): Type =
			states[type] as Type?
					?: throw GdxRuntimeException("Missing state instance of type: $type.")

	inline fun <reified Type : StateType> shown(): Type = shown(Type::class.java)
	@Suppress("UNCHECKED_CAST")
	fun <Type : StateType> shown(type: Class<Type>): Type =
			currentState as Type?
					?: throw GdxRuntimeException("Missing state instance of type: $type.")

	inline fun <reified Type : StateType> remove() = remove(Type::class.java)
	@Suppress("UNCHECKED_CAST")
	fun <Type : StateType> remove(type: Class<Type>) {

		stage.root.removeActor(get(type).layout)
		states.remove(type)

		debug { "SM:: remove ${type.simpleName} " }


		setInput()

	}

	private fun setInput() {
		Gdx.input.inputProcessor = stage

		debug { "SM:: setInput" }

	}

	fun resize(width: Int, height: Int) = renderer.resize(width, height)

	fun update(delta: Float) {


		currentState.update(delta)


		stage.act(delta)


	}


	fun draw() {

		renderer.draw {

			currentState.draw(it)

		}


		stage.draw()

	}


}

interface State {
	val layout: KTableWidget

	fun load() {}

	fun update(delta: Float) {}

	fun draw(batch: Batch) {}

	fun reset() {}

}