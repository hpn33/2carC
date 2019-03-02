package h.car2.screen

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.StretchViewport
import h.car2.entity.ParallaxLayout
import h.car2.util.*
import ktx.app.clearScreen
import ktx.graphics.use
import ktx.inject.Context

class Tst(context: Context) : ScreenAdapter() {
	val assets = context<Assets>()


	private lateinit var streetP: ParallaxLayout


	val viewport =
			if (isMobile)
//				StretchboxingViewport(aspectRatio = ww / wh)
				StretchViewport(ww, wh)
			else
//				LetterboxingViewport(aspectRatio = ww / wh)
				FitViewport(ww, wh)


	val batch = SpriteBatch()

	override fun show() {

		assets.loadF()


		val street = assets.atlas(RegionName.street)

		streetP = ParallaxLayout(street)

	}


	override fun resize(width: Int, height: Int) =
			viewport.update(width, height, true)


	override fun render(delta: Float) {

		clearScreen(0f, 0f, 0f, 1f)

		batch.projectionMatrix = viewport.camera.combined
		batch.use {

			streetP.draw(batch)

		}

	}


}