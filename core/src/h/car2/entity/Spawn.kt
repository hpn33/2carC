package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.Pool
import h.car2.util.Timer
import h.car2.util.downWith
import ktx.log.debug

class Spawn(side: Side) {

	private val pool = object : Pool<FallObject>() {
		override fun newObject() = FallObject(side)
	}

	private val activeObject = mutableListOf<FallObject>()

	private val timer = Timer(1f)


	fun update(delta: Float, car: Car) {

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

			item.update(delta)
			item.collation(car)

			if (activeObject.size > 0 && !item.active) {
				activeObject.removeAt(it)
				pool.free(item)
			}
		}

	}


	fun draw(batch: Batch) = activeObject.forEach { it.draw(batch) }


	fun reset() {

		downWith(activeObject.size) {
			pool.free(activeObject[it])
		}

		activeObject.clear()

		timer.reset()
	}

}