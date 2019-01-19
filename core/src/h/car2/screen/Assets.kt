package h.car2.screen

import com.badlogic.gdx.assets.AssetManager
import h.car2.entity.Car
import h.car2.entity.Side
import h.car2.entity.Spawn
import h.car2.entity.World
import h.car2.util.AssetsDescription

class Assets {


	internal val assetManager = AssetManager()


	internal val world = World(assetManager)

	internal val carR = Car(Side.Right(assetManager))
	internal val carL = Car(Side.Left(assetManager))

	internal val spawnR = Spawn(Side.Right(assetManager))
	internal val spawnL = Spawn(Side.Left(assetManager))


	fun load(): Boolean {


		assetManager.load(AssetsDescription.atlas)
		assetManager.load(AssetsDescription.skin)

		return assetManager.update()
	}

	fun loadF() {


		assetManager.load(AssetsDescription.atlas)
		assetManager.load(AssetsDescription.skin)

		assetManager.finishLoading()

	}

	fun dispose() = assetManager.dispose()


}