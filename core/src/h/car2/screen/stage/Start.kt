package h.car2.screen.stage

import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.entity.GameManager
import h.car2.screen.Assets
import h.car2.util.Timer
import ktx.inject.Context
import ktx.scene2d.label
import ktx.scene2d.table

class Start(context: Context) : State {

	private val stateManager = context<StateManager<State>>()
	private val assets = context<Assets>()

	override val layout = table {
		setFillParent(true)


		label("ready")
	}

	private val timer = Timer(2f, false)

	override fun load() {

		timer.reset()

		GameManager.start ()

		assets.apply {
			world.setSpeed()

			playerL.start()
			playerR.start()

			spawnL.start()
			spawnR.start()

		}
	}


	override fun update(delta: Float) {

		timer.update(delta) {

			stateManager.set<Play>()

		}

		assets.world.update(delta)


	}


	override fun draw(batch: Batch) {
		assets.apply {

			world.draw(batch)

			playerL.draw(batch)
			playerR.draw(batch)
		}
	}

}