package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.math.MathUtils
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.util.RegionName

sealed class Side {

	abstract val firstLine: Int
	abstract val lines: Pair<Int, Int>

	abstract val coin: String
	abstract val block: String
	abstract val car: String

	internal val carTexture get() = assets.atlas(car)
	internal val coinTexture get() = assets.atlas(coin)
	internal val blockTexture get() = assets.atlas(block)

	abstract val offset: Float


	class Right : Side() {
		override val firstLine = 4
		override val lines: Pair<Int, Int> = 3 to 4

		override val car = RegionName.carRed
		override val coin = RegionName.coinRed
		override val block = RegionName.blockRed

		override val offset = MathUtils.random(50f, 150f)
	}

	class Left : Side() {
		override val firstLine = 1
		override val lines: Pair<Int, Int> = 1 to 2

		override val car = RegionName.carBlue
		override val coin = RegionName.coinBlue
		override val block = RegionName.blockBlue

		override val offset = MathUtils.random(20f, 200f)

	}

}