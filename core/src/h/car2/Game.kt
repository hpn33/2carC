package h.car2

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import h.car2.screen.PlayScreen
import h.car2.screen.Tst
import h.car2.util.Setting

class Game : CustomGame() {

	override fun create() {

		Gdx.app.logLevel = Application.LOG_DEBUG

		Setting.load()

		addScreen(PlayScreen())
		addScreen(Tst())

		setScreen<PlayScreen>()

	}
}