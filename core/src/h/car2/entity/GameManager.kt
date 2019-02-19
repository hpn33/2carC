package h.car2.entity


var score = 0
var speed = Speed.low


object Speed {

	const val low = -105f
	const val medium = -170f
	const val high = -280f
	const val top = -350f
}

object GameManager {

	fun start() {
		score = 0
		speed = Speed.medium
	}

	fun scoreUp() {
		score++
		speedUpdate()
	}


	private fun speedUpdate() {

		speed = when {
			score >= 770 -> Speed.top
			score >= 40 -> Speed.high
			else -> speed
		}
	}

}

//enum class State{ Load, Menu, Start, Play, Pause, PreOver, Over }
//
//var correctState = State.Play

//fun state(state: State) {
//	correctState = state
//}