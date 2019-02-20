package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Pool
import h.car2.util.Timer
import h.car2.util.downWith
import h.car2.util.near

class Spawn(var side: Side) {

	private var pool = Map(side)

	private val activeObject = mutableListOf<FallObject>()

	private val timer = Timer(1f)

	private var currentSpeed = 0f
	private var targetSpeed = 0f

	fun setSpeed(value: Float = speed) {
		currentSpeed = value
		targetSpeed = value
	}


	fun update(delta: Float, player: Player) {

		targetSpeed = speed

		currentSpeed = MathUtils.lerp(currentSpeed, targetSpeed, 3 * delta)
		currentSpeed = near(currentSpeed, targetSpeed, 1f)


		timer.time = when (speed) {
			Speed.medium -> .7f
			Speed.high -> .5f
			Speed.top -> .3f
			else -> timer.time
		}

		// add
		timer.update(delta) {

			val item = pool.obtain()
			item.init()

			if (item.active)
				activeObject.add(item)
			else pool.free(item)

		}

		// check for remove

		downWith(activeObject.size) {


			val item = activeObject[it]

			item.update(delta, currentSpeed)
			item.collation(player)

			if (activeObject.size > 0 && !item.active) {
				activeObject.removeAt(it)
				pool.free(item)
			}
		}

	}


	fun draw(batch: Batch) = activeObject.forEach { it.draw(batch) }


	fun start() {

		setSpeed()


		downWith(activeObject.size) {
			pool.free(activeObject[it])
		}

		side.init()

		pool = Map(side)

		activeObject.clear()

		timer.reset()
	}
}

class Map(private val side: Side): Pool<FallObject>() {
	override fun newObject() = FallObject(side)
}