package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.entity.Speed
import h.car2.entity.speed
import h.car2.screen.Assets
import h.car2.screen.PlayScreen
import ktx.actors.onClick
import ktx.inject.Context
import ktx.scene2d.label
import ktx.scene2d.table
import ktx.scene2d.textButton

class Over(context: Context) : State {

	private val stateManager = context<StateManager<State>>()
	private val assets = context<Assets>()

	override val layout = table {
		setFillParent(true)

		pad(0f, 50f, 0f, 50f)

		label("OVER")

		row().space(10f)



		textButton("again") {

			onClick {
				stateManager.set<Start>()
			}

			inCell.growX()
		}

		row().space(10f)

		textButton("menu") {

			onClick {
				stateManager.set<Menu>()
			}

			inCell.growX()
		}

		row().space(10f)


	}

	override fun load() {

		speed = Speed.low

		assets.apply {
			world.setSpeed()

			playerL.start()
			playerR.start()
		}
	}

	override fun update(delta: Float) =assets.world.update(delta)



	override fun draw(batch: Batch) {
		assets.apply {

			world.draw(batch)

			playerL.draw(batch)
			playerR.draw(batch)
		}
	}

}
