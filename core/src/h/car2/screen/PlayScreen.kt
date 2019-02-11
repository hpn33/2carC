package h.car2.screen

import com.badlogic.gdx.ScreenAdapter
import h.car2.screen.stage.*
import ktx.app.clearScreen

class PlayScreen : ScreenAdapter() {


	companion object {

		val assets = Assets()
		val stateManager = StateManager<State>()

	}

	override fun show() {

		stateManager.add(Load())

		stateManager.set<Load>()

	}

	override fun resize(width: Int, height: Int) = stateManager.resize(width, height)


	override fun render(delta: Float) {
		clearScreen(0f, 0f, 0f, 1f)

		stateManager.update(delta)

		stateManager.draw()

	}

	override fun hide() = dispose()

	override fun dispose() = assets.dispose()


}

//fun assets(function: Assets.() -> Unit) =
//		PlayScreen.assets.function()
