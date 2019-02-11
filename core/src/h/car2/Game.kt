package h.car2

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import h.car2.screen.PlayScreen
import h.car2.screen.Tst
import ktx.app.KtxGame

class Game : CustomGame() {


	override fun create() {

		Gdx.app.logLevel = Application.LOG_DEBUG

		addScreen(PlayScreen())
		addScreen(Tst())

		setScreen<PlayScreen>()

	}
}