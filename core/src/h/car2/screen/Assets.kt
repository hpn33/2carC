package h.car2.screen

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import h.car2.entity.Player
import h.car2.entity.Side
import h.car2.entity.Spawn
import h.car2.entity.World
import h.car2.util.AssetsDescription

class Assets {


	internal val manager = AssetManager()


	internal val world = World()

	private val right = Side.Right()
	private val left = Side.Left()

	internal val playerR = Player(right)
	internal val playerL = Player(left)

	internal val spawnR = Spawn(right)
	internal val spawnL = Spawn(left)


	fun load() =
			with(manager) {

				load(AssetsDescription.atlas)
				load(AssetsDescription.skin)

				load(AssetsDescription.music)
				load(AssetsDescription.coin)
				load(AssetsDescription.block)

			}


	fun loadF() {

		load()
		manager.finishLoading()

	}

	operator fun <T> get(descriptor: AssetDescriptor<T>) = manager.get(descriptor)!!

	fun atlas(regionName: String) =
			get(AssetsDescription.atlas).findRegion(regionName)!!

	/**
	 * just for loading
	 */
	fun update() = manager.update()

	fun dispose() = manager.dispose()


}