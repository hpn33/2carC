package h.car2

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import h.car2.screen.Assets
import h.car2.screen.DebugRenderer
import h.car2.screen.PlayScreen
import h.car2.screen.Tst
import h.car2.screen.stage.State
import h.car2.screen.stage.StateManager
import h.car2.util.Setting

class Game : CustomGame() {

	override fun create() {

		Gdx.app.logLevel = Application.LOG_DEBUG


		context.register {
			bindSingleton { Assets(this) }
			bindSingleton { Setting(this).apply { load() } }
			bindSingleton { StateManager<State>() }
			bindSingleton { DebugRenderer() }
		}

		addScreen(PlayScreen(context))
		addScreen(Tst(context))

		setScreen<PlayScreen>()

	}
}