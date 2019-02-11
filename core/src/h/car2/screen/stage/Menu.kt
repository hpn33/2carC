package h.car2.screen.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.entity.Speed
import h.car2.entity.Speed.low
import h.car2.entity.speed
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.screen.PlayScreen.Companion.stateManager
import ktx.actors.onClick
import ktx.scene2d.table
import ktx.scene2d.textButton

class Menu : State {

	override val layout = table {


		setFillParent(true)

		pad(0f, 50f, 0f, 50f)

		textButton("PLAY") {

			onClick {
				stateManager.set<Start>()
			}

			inCell.growX()
		}

		row().space(10f)

		textButton("EXIT") {

			onClick { Gdx.app.exit() }

			inCell.growX()
		}

		row().space(10f)

		table {
			left()

			textButton("S")
			textButton("M")

			inCell.growX()
		}

	}

	override fun load() {
		assets.apply {

			speed = Speed.low

			world.setSpeed()

			spawnL.setSpeed()
			spawnR.setSpeed()

			carL.load()
			carR.load()

		}

	}

	override fun update(delta: Float) {

		assets.world.update(delta)


	}

	override fun draw(batch: Batch) {

		assets.apply {
			world.draw(batch)

			carL.draw(batch)
			carR.draw(batch)
		}
	}

}