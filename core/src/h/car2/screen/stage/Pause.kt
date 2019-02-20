package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.screen.PlayScreen.Companion.stateManager
import ktx.actors.onClick
import ktx.scene2d.label
import ktx.scene2d.table
import ktx.scene2d.textButton

class Pause : State {

	override val layout = table {
		setFillParent(true)

		pad(0f, 50f, 0f, 50f)

		label("PAUSE")

		row().space(10f)


		textButton("more") {

			onClick { stateManager.set<Play>() }

			inCell.growX()

		}

		row().space(10f)

		textButton("home") {

			onClick { stateManager.set<Menu>() }

			inCell.growX()

		}

	}


	override fun draw(batch: Batch) {
		assets.apply {

			world.draw(batch)

			playerL.draw(batch)
			playerR.draw(batch)

			spawnL.draw(batch)
			spawnR.draw(batch)

		}
	}

}