package h.car2.entity


var score = 0


var speed = Speed.low

//fun speed(value: Float) {
//	speed = value
//}

fun scoreUp() {
	score++
	speedUpdate()

	println("$speed")
}


fun speedUpdate() {

	speed = when {
		score >= 20 -> Speed.top
		score >= 10 -> Speed.high
		else -> speed
	}
}

object Speed {
	const val low = -105f
	const val medium = -170f
	const val high = -280f
	const val top = -350f
}

//enum class State{ Load, Menu, Start, Play, Pause, PreOver, Over }
//
//var correctState = State.Play

//fun state(state: State) {
//	correctState = state
//}