package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Intersector
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Polygon
import com.badlogic.gdx.utils.Pool
import h.car2.screen.Assets
import h.car2.screen.DebugRenderer
import h.car2.screen.stage.Over
import h.car2.screen.stage.State
import h.car2.screen.stage.StateManager
import h.car2.util.*
import ktx.inject.Context

class FallObject(context: Context, private val side: Side) : Sprite(), Pool.Poolable {

	private val assets = context<Assets>()
	private val stateManager = context<StateManager<State>>()
	private val renderer = context<DebugRenderer>()
	private val setting = context<Setting>()


	var active = true


	enum class Type { None, Coin, Block }

	var type = Type.None

	private val bound
		get() = Polygon(
				arrayOf(x, y,
						x, y + height,
						x + width, y + height,
						x + width, y).toFloatArray())

	private val random get() = MathUtils.random(0, 9)

//	init { init()}
	
	fun init() {

		val region: TextureAtlas.AtlasRegion

		when (random) {
			1, 2 -> {
				type = Type.Coin
				region = side.coinTexture
			}
			3, 4, 5, 6, 7, 8, 9 -> {
				type = Type.Block
				region = side.blockTexture
			}
			0 -> return
			else -> return
		}

//		if (type == Type.None) return

		active = true

		setRegion(region)
		setColor(1f, 1f, 1f, 1f)
		setSize(region.regionWidth.toFloat(), region.regionHeight.toFloat())
		setOrigin(width / 2, height / 2)



		x = when (random) {
			0, 2, 4, 6, 8 -> regionWidth centerOfLine side.lines.first
			1, 3, 5, 7, 9 -> regionWidth centerOfLine side.lines.second
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

	fun collation(player: Player) {
		if (type == Type.None) return


//		if (boundingRectangle.overlaps(player.boundingRectangle)) {
		if (Intersector.overlapConvexPolygons(player.bound, bound)) {
			when (type) {

				Type.Coin -> {
					if (setting.sound) assets[AssetsDescription.coin].play()
					GameManager.scoreUp()
				}
				Type.Block -> {
					if (setting.sound) assets[AssetsDescription.block].play()
					stateManager.set<Over>()
				}

				Type.None -> Unit

			}

			active = false
		}
	}


	override fun draw(batch: Batch) {

		if (type == Type.None) return
		super.draw(batch)

//		batch?.draw(texture,
//				x - width / 2, y,
//				width * 2, height * 2,
//				u, v, u2, v2)


		renderer.draw(bound.transformedVertices)


	}

	override fun reset() {
		type = Type.None
		texture = null
	}


}
