package h.car2.screen.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import h.car2.screen.assets
import h.car2.screen.PlayScreen.Companion.stateManager
import ktx.actors.onClick
import ktx.log.debug
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
		assets {


			carL.load()
			carR.load()

		}

	}

	override fun update(delta: Float) {

		assets {

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