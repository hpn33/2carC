package h.car2

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import h.car2.screen.PlayScreen
import ktx.app.KtxGame

class Game : KtxGame<Screen>() {


	override fun create() {

		Gdx.app.logLevel = Application.LOG_DEBUG

		addScreen(PlayScreen())

		setScreen<PlayScreen>()

	}
}