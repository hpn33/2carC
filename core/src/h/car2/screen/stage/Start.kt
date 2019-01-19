package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import h.car2.entity.score
import h.car2.screen.PlayScreen.Companion.stateManager
import h.car2.screen.assets
import h.car2.util.Timer
import ktx.scene2d.label
import ktx.scene2d.table

class Start : State {

	override val layout = table {
		setFillParent(true)


		label("ready")
	}

	private val timer = Timer(2f, false)

	override fun load() {

		timer.reset()

		score = 0

		assets {

			carL.start()
			carR.start()

		}
	}


	override fun update(delta: Float) {

		timer.update(delta) {

			stateManager.set<Play>()

		}

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