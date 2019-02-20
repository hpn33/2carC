package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.entity.Speed
import h.car2.entity.speed
import h.car2.screen.PlayScreen
import h.car2.screen.PlayScreen.Companion.assets
import ktx.actors.onClick
import ktx.scene2d.label
import ktx.scene2d.table
import ktx.scene2d.textButton

class Over : State {

	override val layout = table {
		setFillParent(true)

		pad(0f, 50f, 0f, 50f)

		label("OVER")

		row().space(10f)



		textButton("again") {

			onClick {
				PlayScreen.stateManager.set<Start>()
			}

			inCell.growX()
		}

		row().space(10f)

		textButton("menu") {

			onClick {
				PlayScreen.stateManager.set<Menu>()
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
