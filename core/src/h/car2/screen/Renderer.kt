package h.car2.screen

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.StretchViewport
import h.car2.screen.stage.State
import h.car2.screen.stage.StateManager
import h.car2.util.isMobile
import h.car2.util.wh
import h.car2.util.ww
import ktx.app.clearScreen
import ktx.graphics.use

class Renderer {

	companion object {
		val viewport =

				if (isMobile)
//				StretchboxingViewport(aspectRatio = ww / wh)
					StretchViewport(ww, wh)
				else
//				LetterboxingViewport(aspectRatio = ww / wh)
					FitViewport(ww, wh)

		val camera get() = viewport.camera
	}

	val batch = SpriteBatch()


	fun resize(width: Int, height: Int) =
			viewport.update(width, height, true)


	fun draw(func: (SpriteBatch) -> Unit) {

		batch.projectionMatrix = viewport.camera.combined
		batch.use {

			func(it)

		}

	}

}
