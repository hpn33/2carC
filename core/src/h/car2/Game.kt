package h.car2

import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import h.car2.screen.PlayScreen
import ktx.app.KtxGame

class Game : KtxGame<Screen>() {


	override fun create() {

		addScreen(PlayScreen(this))

		setScreen<PlayScreen>()

	}
}