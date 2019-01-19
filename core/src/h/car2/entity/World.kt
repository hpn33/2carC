package h.car2.entity

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.util.*
import ktx.log.debug

class World(private val assetManager: AssetManager) {


	private val line by lazy { assetManager.atlas(RegionName.lineCenterStreet) }
	private val centerLine by lazy { assetManager.atlas(RegionName.lineCenter1) }
	private val street by lazy { assetManager.atlas(RegionName.street) }


	var offSetLine = 0f
	var offSetStreet = 0f


	fun update(delta: Float) {


		val speed = 30 * delta

		offSetLine -= speed

		if (offSetLine < -line.regionHeight)
			offSetLine = 0f

		offSetStreet -= speed

		if (offSetStreet < -street.regionHeight)
			offSetStreet = 0f
	}


	fun draw(batch: Batch) {


		var x = 0f
		var y = offSetStreet
		while (x < ww + street.regionWidth) {
			while (y < wh + street.regionHeight) {

				batch.draw(street, x, y)

				y += street.regionHeight

			}
			y = offSetStreet
			x += street.regionWidth


		}

		y = offSetLine
		while (y < wh + line.regionWidth) {

			val w = line.regionWidth / 2f

			batch.draw(line,
					w linePosition 1/* - centerLine.regionWidth / 2*/, y,
					w, line.regionHeight.toFloat())

			batch.draw(centerLine, centerLine.regionWidth linePosition 2, y)

			batch.draw(line, w linePosition 3/* + centerLine.regionWidth / 2*/, y,
					w, line.regionHeight.toFloat())

			y += line.regionHeight

		}
	}


}