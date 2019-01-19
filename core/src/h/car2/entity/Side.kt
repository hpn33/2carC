package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import h.car2.util.RegionName
import h.car2.util.atlas

sealed class Side(private val assetManager: AssetManager) {

	abstract val firstLine: Int
	abstract val lines: Pair<Int, Int>

	abstract val coin: String
	abstract val block: String
	abstract val car: String

	internal val carTexture get() = assetManager.atlas(car)
	internal val coinTexture get() = assetManager.atlas(coin)
	internal val blockTexture get() = assetManager.atlas(block)


	class Right(assetManager: AssetManager) : Side(assetManager) {
		override val firstLine = 4
		override val lines: Pair<Int, Int> = 3 to 4

		override val car = RegionName.carRed
		override val coin = RegionName.coinRed
		override val block = RegionName.blockRed
	}

	class Left(assetManager: AssetManager) : Side(assetManager) {
		override val firstLine = 1
		override val lines: Pair<Int, Int> = 1 to 2

		override val car = RegionName.carBlue
		override val coin = RegionName.coinBlue
		override val block = RegionName.blockBlue
	}

}