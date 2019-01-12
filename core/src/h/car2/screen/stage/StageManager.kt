package h.car2.screen.stage

import h.car2.entity.State
import h.car2.entity.correctState
import h.car2.screen.Assets


class StageManager(private val assets: Assets) {


	private val load = Load()
//	private val start = Start()
//	private val menu = Menu()
//	private val play = Play()
//	private val pause = Pause()
//	private val preOver = PreOver()
//	private val over = Over()

	private lateinit var hud: Stage


	fun update(delta: Float) {

		when (correctState) {

			State.Load -> TODO()
			State.Menu -> TODO()
			State.Start -> TODO()
			State.Play -> TODO()
			State.Pause -> TODO()
			State.Over -> TODO()
		}


	}


}



