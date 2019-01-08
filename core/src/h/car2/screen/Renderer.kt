package h.car2.screen

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import h.car2.util.isMobile
import h.car2.wHeight
import h.car2.wWidth
import ktx.app.LetterboxingViewport
import ktx.graphics.use

class Renderer {

	private val camera = OrthographicCamera()

	private val viewport =
			if (isMobile) StretchViewport(wWidth, wHeight, camera)
			else LetterboxingViewport(aspectRatio = wWidth / wHeight)

	private var batch = SpriteBatch()



	fun resize(width: Int, height: Int) {
		viewport.update(width, height, true)
	}


	fun draw(assets: Assets) {

		batch.projectionMatrix = viewport.camera.combined
		batch.use {

			assets.draw(it)

			assets.draw(viewport)
		}

	}


}
