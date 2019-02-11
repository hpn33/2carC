package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.ui.Label
import h.car2.entity.score
import h.car2.entity.scoreUp
import h.car2.entity.touchArea
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.screen.PlayScreen.Companion.stateManager
import ktx.actors.onClick
import ktx.scene2d.label
import ktx.scene2d.table
import ktx.scene2d.textButton

class Play : State {

	private lateinit var scoreL: Label

	override val layout = table {

		setFillParent(true)

		top()

		table {

			pad(10f)

			textButton("P") {
				onClick { stateManager.set<Pause>() }
				inCell.expandX().left()
			}

			scoreL = label("0") { cell ->
				cell.growX().right()
			}

			add(scoreL)

			inCell.growX()
		}


		row()

		table {
			inCell.grow()

			touchArea { cell ->
				onClick { assets.carL.changePosition() }

				cell.grow()
			}

			touchArea { cell ->
				onClick { assets.carR.changePosition() }

				cell.grow()
			}

		}

	}

	override fun load() {

		scoreL.setText("0")
	}

	override fun update(delta: Float) {
		assets.apply {

			world.update(delta)

			carL.update(delta)
			carR.update(delta)

			spawnL.update(delta, carL)
			spawnR.update(delta, carR)

		}


		scoreL.setText("$score")

	}


	override fun draw(batch: Batch) {
		assets.apply {

			world.draw(batch)

			spawnL.draw(batch)
			spawnR.draw(batch)

			carL.draw(batch)
			carR.draw(batch)

		}
	}

}