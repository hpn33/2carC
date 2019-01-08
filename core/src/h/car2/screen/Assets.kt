package h.car2.screen

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import h.car2.entity.World

class Assets {

	private val assetManager = AssetManager()


	private val world = World(assetManager)

//	private val carR = Car(assetManager, CarSide.Right)
//	private val carL = Car(assetManager, CarSide.Left)

//	private val spawnR = Spawn(assetManager, SpawnSide.Right)
//	private val spawnL = Spawn(assetManager, SpawnSide.Left)



	fun draw(batch: SpriteBatch) {

		world.draw(batch)

//		carR.draw(batch)
//		carL.draw(batch)

//		spawnR.draw(batch)
//		spawnL.draw(batch)

	}

	fun draw(viewport: Viewport) {
		world.draw(viewport)
	}


}