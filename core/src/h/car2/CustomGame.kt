package h.car2

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import ktx.app.clearScreen

abstract class CustomGame : KtxGame<Screen>() {


	override fun render() {
		clearScreen(0f, 0f, 0f, 1f)

		val delta = run {

			val d = Gdx.graphics.deltaTime
			val lessD = 1 / 60f

			if (d > lessD) lessD else d

		}

		currentScreen.render(delta)
	}
}