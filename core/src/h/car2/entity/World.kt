package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.MathUtils
import h.car2.screen.Renderer.Companion.camera
import h.car2.util.*

class World(private val assetManager: AssetManager) {


	private val street
			by lazy {
				ParallaxLayout(assetManager.atlas(RegionName.street))
						.apply {

							speed.y = Speed.low
							dimension.set(
									camera.viewportWidth,
									camera.viewportHeight)

						}
			}


	private val centerLine by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenter1))
				.apply {

					speed.y = Speed.low
					position.x = width linePosition 2
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}

	private val lineL by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenterStreet))
				.apply {

					speed.y = Speed.low
					position.x = width linePosition 1
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}

	private val lineR by lazy {
		ParallaxLayout(assetManager.atlas(RegionName.lineCenterStreet))
				.apply {

					speed.y = Speed.low
					position.x = width linePosition 3
					dimension.set(width / 2, camera.viewportHeight)

					overlap.x(false)

				}
	}


	private var currentSpeed = 0f
	private var targetSpeed = 0f

	fun setSpeed(value: Float = speed) {
		currentSpeed = value
		targetSpeed = value
	}

	fun update(delta: Float) {

		targetSpeed = speed

		currentSpeed = MathUtils.lerp(currentSpeed, targetSpeed, 3 * delta)
		currentSpeed = near(currentSpeed, targetSpeed, 1f)

		street.apply {
			speed.y = currentSpeed
		}

		centerLine.apply {
			speed.y = currentSpeed
		}
		lineL.apply {
			speed.y = currentSpeed
		}
		lineR.apply {
			speed.y = currentSpeed
		}


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