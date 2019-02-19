package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Intersector
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Polygon
import com.badlogic.gdx.utils.Pool
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.screen.PlayScreen.Companion.renderer
import h.car2.screen.PlayScreen.Companion.stateManager
import h.car2.screen.stage.Over
import h.car2.util.*
import ktx.graphics.use
import ktx.log.debug

class FallObject(private val side: Side) : Sprite(), Pool.Poolable {

	var active = true


	enum class Type { None, Coin, Block }

	var type = Type.None

	private val bound
		get() = Polygon(
				arrayOf(x, y,
						x, y + height,
						x + width, y + height,
						x + width, y).toFloatArray())

	val random get() = MathUtils.random(0, 9)
	fun init() {


		val region = when (random) {
			1, 2 -> {
				type = Type.Coin
				side.coinTexture
			}
			3, 4, 5, 6, 7, 8, 9 -> {
				type = Type.Block
				side.blockTexture
			}
			0 -> return
			else -> return
		}

		if (type == Type.None) return

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

		y = wh + regionHeight + 10f + side.offset

	}

	fun update(delta: Float, speed: Float) {
		if (type == Type.None) return


		y += speed * delta


		if (y <= -regionHeight)
			active = false

		if (type == Type.Coin && y <= wh / 9f - 10) {
			active = false
			stateManager.set<Over>()
		}


	}

	fun collation(car: Car) {
		if (type == Type.None) return


//		if (boundingRectangle.overlaps(car.boundingRectangle)) {
		if (Intersector.overlapConvexPolygons(car.bound, bound)) {
			when (type) {

				Type.Coin -> {
					if (Setting.sound) assets[AssetsDescription.coin].play()
					GameManager.scoreUp()
				}
				Type.Block -> {
					if (Setting.sound) assets[AssetsDescription.block].play()
					stateManager.set<Over>()
				}

				Type.None -> Unit

			}

			active = false
		}
	}


	override fun draw(batch: Batch?) {

		if (type == Type.None) return
//		super.draw(batch)

		batch?.draw(texture,
				x - width / 2, y,
				width * 2, height * 2,
				u, v, u2, v2)


		renderer.draw(bound.transformedVertices)


	}

	override fun reset() {
		type = Type.None
		texture = null
	}


}
