package h.car2.screen

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import h.car2.entity.*
import h.car2.util.AssetsDescription

class Assets {

	private val assetManager = AssetManager()


	private val world = World(assetManager)

	private val carR = Car(CarSide.Right(assetManager))
	private val carL = Car(CarSide.Left(assetManager))

	private val spawnR = Spawn(SpawnSide.Right(assetManager))
	private val spawnL = Spawn(SpawnSide.Left(assetManager))


	init {
		with(assetManager) {
			load(AssetsDescription.atlas)

			finishLoading()
		}
	}


	fun load() {

		carR.start()
		carL.start()

	}


	fun update(delta: Float) {
		world.update(100 * delta)

		carR.update(delta)
		carL.update(delta)

		spawnR.update(delta, carR)
		spawnL.update(delta, carL)

	}


	fun draw(batch: SpriteBatch) {

		world.draw(batch)

		spawnR.draw(batch)
		spawnL.draw(batch)

		carR.draw(batch)
		carL.draw(batch)

	}


	fun dispose() = assetManager.dispose()


}