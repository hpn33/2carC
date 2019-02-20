package h.car2.screen

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import h.car2.screen.Renderer.Companion.camera
import h.car2.screen.stage.*
import h.car2.util.AssetsDescription
import ktx.app.clearScreen
import ktx.graphics.use

class PlayScreen : ScreenAdapter() {


	companion object {

		val assets = Assets()
		val stateManager = StateManager<State>()

		val renderer = DebugRenderer()

	}

	override fun show() {

		stateManager.add(Load())

		stateManager.set<Load>()

	}

	override fun resize(width: Int, height: Int) = stateManager.resize(width, height)


	override fun render(delta: Float) {
		clearScreen(1f, 1f, 1f, 1f)

		stateManager.update(delta)

		renderer.use(camera) {

			stateManager.draw()

		}

	}

	override fun hide() = dispose()

	override fun dispose() {

		renderer.dispose()

		assets[AssetsDescription.music].stop()
		assets.dispose()
	}


}

class DebugRenderer {

	val renderer = ShapeRenderer()
			.apply{ color = Color.GREEN }


	fun use(camera: Camera, function: () -> Unit) {
		renderer.projectionMatrix = camera.combined
		renderer.use(ShapeRenderer.ShapeType.Line) {

			function()

		}
	}


	fun draw(vertices: FloatArray) = renderer.polygon(vertices)

	fun dispose() = renderer.dispose()

}
