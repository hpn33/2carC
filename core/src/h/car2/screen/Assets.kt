package h.car2.screen

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import h.car2.entity.Car
import h.car2.entity.CarSide
import h.car2.entity.World
import h.car2.util.AssetsDescription

class Assets {

	private val assetManager = AssetManager()


	private val world = World(assetManager)

	private val carR = Car(CarSide.Right(assetManager))
	private val carL = Car(CarSide.Left(assetManager))

//	private val spawnR = Spawn(assetManager, SpawnSide.Right)
//	private val spawnL = Spawn(assetManager, SpawnSide.Left)


	init {
		with(assetManager) {
			load(AssetsDescription.atlas)

			finishLoading()
		}
	}

	fun load() {
//
//
//		with(assetManager) {
//			start(AssetsDescription.atlas)
//
//			finishLoading()
//		}
//
//		world.start()

		carR.start()
		carL.start()
	}


	fun update(delta: Float) {
		world.update(100 * delta)

		carR.update(delta)
		carL.update(delta)


	}

	fun draw(batch: SpriteBatch) {

		world.draw(batch)

		carR.draw(batch)
		carL.draw(batch)

//		spawnR.draw(batch)
//		spawnL.draw(batch)

	}

	fun dispose() {
		assetManager.dispose()
	}


}