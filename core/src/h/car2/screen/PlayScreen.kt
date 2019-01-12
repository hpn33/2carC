package h.car2.screen

import com.badlogic.gdx.ScreenAdapter
import h.car2.Game
import h.car2.screen.stage.StageManager

class PlayScreen : ScreenAdapter() {


	private val asset = Assets()
	private val renderer = Renderer()
//	private val stageManager = StageManager(asset)

	override fun show() {
		asset.load()

	}

	override fun resize(width: Int, height: Int) = renderer.resize(width, height)


	override fun render(delta: Float) {

//		stageManager.update ()

		asset.update(delta)

		renderer.draw(asset)
	}

	override fun hide() {
		dispose()
	}

	override fun dispose() {
		asset.dispose()
	}

}
