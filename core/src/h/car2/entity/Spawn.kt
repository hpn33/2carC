package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.Pool
import h.car2.util.RegionName
import h.car2.util.Timer
import h.car2.util.atlas

class Spawn(side: SpawnSide) {

	private val pool = object : Pool<FallObject>() {
		override fun newObject() = FallObject(side)
	}

	private val activeObject = mutableListOf<FallObject>()

	private val timer = Timer(1f)


	fun update(delta: Float) {

		// add
		timer.update(delta) {

			val item = pool.obtain()
			item.init()

			if (item.active)
				activeObject.add(item)
			else pool.free(item)

		}

		// check for remove
		(activeObject.size - 1 downTo 0).forEach {

			val item = activeObject[it]
			item.update(delta)

			if (!item.active) {
				activeObject.removeAt(it)
				pool.free(item)
			}
		}

	}


	fun draw(batch: Batch) = activeObject.forEach { it.draw(batch) }


}


sealed class SpawnSide(private val assetManager: AssetManager) {

	abstract val coin: String
	abstract val block: String

	abstract val lines: Pair<Int, Int>

	val coinTexture get() = assetManager.atlas(coin)
	val blockTexture get() = assetManager.atlas(block)


	class Right(assetManager: AssetManager) : SpawnSide(assetManager) {
		override val coin = RegionName.coinRed
		override val block = RegionName.blockRed

		override val lines: Pair<Int, Int> = LinesRight.lines
	}


	class Left(assetManager: AssetManager) : SpawnSide(assetManager) {
		override val coin = RegionName.coinBlue
		override val block = RegionName.blockBlue

		override val lines: Pair<Int, Int> = LinesLeft.lines
	}
}