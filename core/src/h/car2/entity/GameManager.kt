package h.car2.entity


var score = 0

fun scoreUp() {
	score++
}


object Speed {
	const val low = -65f
	const val medium = -100f
	const val high = -130f
	const val top = -150f
}

//enum class State{ Load, Menu, Start, Play, Pause, PreOver, Over }
//
//var correctState = State.Play

//fun state(state: State) {
//	correctState = state
//}