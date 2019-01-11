package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Pool
import h.car2.util.centerOfLine
import h.car2.util.wHeight

class FallObject(private val side: SpawnSide) : Sprite(), Pool.Poolable {

	var active = true


	fun init() {


		val random = MathUtils.random(0, 9)

		val region = when (random) {
			1, 2, 3, 4 -> side.coinTexture
			5, 6, 7, 8 -> side.blockTexture
			0, 9 -> return
			else -> return
		}

		active = true

		setRegion(region)
		setColor(1f, 1f, 1f, 1f)
		setSize(region.regionWidth.toFloat(), region.regionHeight.toFloat())
		setOrigin(width / 2, height / 2)



		x = when (random) {
			0, 1, 2, 3, 4 -> regionWidth centerOfLine side.lines.first
			5, 6, 7, 8, 9 -> regionWidth centerOfLine side.lines.second
			else -> regionWidth centerOfLine side.lines.first
		}

		y = wHeight + regionHeight + 10f

	}

	fun update(delta: Float) {

		y -= 100 * delta

		if (y <= -regionHeight)
			active = false

	}


	override fun reset() {

		texture = null

	}


}
