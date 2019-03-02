package h.car2

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import ktx.inject.Context

abstract class CustomGame : KtxGame<Screen>() {

	private val lessDelta = 1 / 60f

	protected val context = Context()

	override fun render() {

		var delta = Gdx.graphics.deltaTime

		delta = if (delta > lessDelta) lessDelta else delta


		currentScreen.render(delta)
	}
}