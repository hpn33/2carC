package h.car2.screen.stage

import ktx.scene2d.label
import ktx.scene2d.table

class PreOver : State {

	override val layout = table { setFillParent(true)
		label(this.javaClass.simpleName)
	}

	override fun update(delta: Float) {}

}