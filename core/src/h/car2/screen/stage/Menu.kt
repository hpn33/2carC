package h.car2.screen.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import h.car2.entity.Speed
import h.car2.entity.speed
import h.car2.screen.Assets
import h.car2.util.AssetsDescription
import h.car2.util.Setting
import ktx.actors.onClick
import ktx.inject.Context
import ktx.scene2d.KCheckBox
import ktx.scene2d.checkBox
import ktx.scene2d.table
import ktx.scene2d.textButton

class Menu(context: Context) : State {

	private val stateManager = context<StateManager<State>>()
	private val setting = context<Setting>()
	private val assets = context<Assets>()

	private lateinit var soundCheck: KCheckBox
	private lateinit var musicCheck: KCheckBox

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

			checkBox("S") {
				isChecked = setting.sound

				onClick { setting.sound = !setting.sound }
			}.also { box -> soundCheck = box }

			checkBox("M") {
				isChecked = setting.music
				onClick {
					setting.music = !setting.music
				}
			}.also { box -> musicCheck = box }

			inCell.growX()
		}

	}

	override fun load() {
		assets.apply {

			speed = Speed.low

			world.setSpeed()

			spawnL.setSpeed()
			spawnR.setSpeed()

			playerL.load()
			playerR.load()

			if (setting.music)
				get(AssetsDescription.music).apply {
					isLooping = true
					play()
				}

		}

	}

	override fun update(delta: Float) {

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