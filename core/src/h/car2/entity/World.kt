package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.screen.Renderer.Companion.camera
import h.car2.util.*

class World(private val assetManager: AssetManager) {





	private val street
			by lazy {
				ParallaxLayout(assetManager.atlas(RegionName.street))
						.apply {
							speed.y = speedy

							dimension.set(
									camera.viewportWidth,
									camera.viewportHeight)

						}
			}


	private val centerLine by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenter1))
				.apply {

					speed.y = speedy
					position.x = width linePosition 2
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}

	private val lineL by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenterStreet))
				.apply {

					speed.y = speedy
					position.x = width linePosition 1
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}

	private val lineR by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenterStreet))
				.apply {

					speed.y = speedy
					position.x = width linePosition 3
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}

	fun update(delta: Float) {

		street.update(delta)

		centerLine.update(delta)
		lineL.update(delta)
		lineR.update(delta)
	}


	fun draw(batch: Batch) {

		street.draw(batch)

		lineL.draw(batch)
		centerLine.draw(batch)
		lineR.draw(batch)

	}


}