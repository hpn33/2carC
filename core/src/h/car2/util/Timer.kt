package h.car2.util

class Timer(
		internal var time: Float,
		private val loop: Boolean = true) {

	private var correctTime = 0f
	private var stop = false


	private fun timeJob(delta: Float): Boolean {

		if (!stop) {
			if (correctTime > time) {
				if (loop) correctTime = 0f

				return true
			}

			correctTime += delta
		}

		return false
	}


	fun update(delta: Float, function: () -> Unit) {
		if (timeJob(delta)) function()
	}


	fun reset() {
		correctTime = 0f
		stop = false
	}


	fun stop() {
		stop = true
	}

}