package h.car2.screen.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.screen.PlayScreen
import h.car2.screen.assets
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

		textButton("enughe") {

			onClick {
				PlayScreen.stateManager.set<Menu>()
			}

			inCell.growX()
		}

		row().space(10f)


	}

	override fun load() {

		assets {
			carL.start()
			carR.start()
		}
	}

	override fun update(delta: Float) {
		assets {

			world.setSpeed()

			world.update(delta)
		}

	}


	override fun draw(batch: Batch) {
		assets {

			world.draw(batch)

			carL.draw(batch)
			carR.draw(batch)
		}
	}

}
