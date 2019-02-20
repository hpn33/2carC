package h.car2.entity

import com.badlogic.gdx.math.MathUtils
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.util.RegionName

sealed class Side {

	abstract val firstLine: Int
	abstract val lines: Pair<Int, Int>

	//	val coin = RegionName.coin
//	val block = RegionName.block
	abstract val player: String

	internal val playerTexture get() = assets.atlas(player)
	internal val coinTexture get() = assets.atlas(RegionName.coin)
	internal val blockTexture get() = assets.atlas(RegionName.block)

	internal var offset = MathUtils.random(50f, 250f)

	internal fun init() {
		offset = MathUtils.random(50f, 250f)
	}

	class Right : Side() {
		override val firstLine = 4
		override val lines: Pair<Int, Int> = 3 to 4

		override val player = RegionName.rightP

	}

	class Left : Side() {
		override val firstLine = 1
		override val lines: Pair<Int, Int> = 1 to 2

		override val player = RegionName.leftP

	}

}