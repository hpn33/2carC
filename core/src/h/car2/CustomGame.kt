package h.car2

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import ktx.app.clearScreen

abstract class CustomGame : KtxGame<Screen>() {

	private val lessDelta = 1 / 60f

	override fun render() {
		clearScreen(0f, 0f, 0f, 1f)


		var delta = Gdx.graphics.deltaTime

		delta = if (delta > lessDelta) lessDelta else delta


		currentScreen.render(delta)
	}
}