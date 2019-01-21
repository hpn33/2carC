package h.car2.screen

import com.badlogic.gdx.assets.AssetManager
import h.car2.entity.Car
import h.car2.entity.Side
import h.car2.entity.Spawn
import h.car2.entity.World
import h.car2.util.AssetsDescription

class Assets {


	internal val manager = AssetManager()


	internal val world = World(manager)

	internal val carR = Car(Side.Right(manager))
	internal val carL = Car(Side.Left(manager))

	internal val spawnR = Spawn(Side.Right(manager))
	internal val spawnL = Spawn(Side.Left(manager))


	fun load(): Boolean {


		manager.load(AssetsDescription.atlas)
		manager.load(AssetsDescription.skin)

		return manager.update()
	}

	fun loadF() {


		manager.load(AssetsDescription.atlas)
		manager.load(AssetsDescription.skin)

		manager.finishLoading()

	}

	fun dispose() = manager.dispose()


}