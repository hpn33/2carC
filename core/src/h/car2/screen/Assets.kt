package h.car2.screen

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import h.car2.entity.Player
import h.car2.entity.Side
import h.car2.entity.Spawn
import h.car2.entity.World
import h.car2.util.AssetsDescription
import ktx.inject.Context

class Assets(context: Context) {


	internal val manager = AssetManager()


	internal val world = World(context)

	private val right = Side.Right(context)
	private val left = Side.Left(context)

	internal val playerR = Player(context, right)
	internal val playerL = Player(context, left)

	internal val spawnR = Spawn(context, right)
	internal val spawnL = Spawn(context, left)


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