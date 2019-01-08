package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import h.car2.wHeight
import h.car2.wWidth
import ktx.graphics.rect

class World(assetManager: AssetManager) {


	private val shapeRenderer by lazy { ShapeRenderer() }

	fun draw(batch: SpriteBatch) {


	}

	fun draw(viewport: Viewport) {
		shapeRenderer.projectionMatrix = viewport.camera.combined


		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)


		shapeRenderer.rect(0f, 0f, wWidth, wHeight)

		shapeRenderer.end()

	}


}