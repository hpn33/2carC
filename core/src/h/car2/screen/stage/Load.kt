package h.car2.screen.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import h.car2.screen.PlayScreen.Companion.assets
import h.car2.screen.PlayScreen.Companion.stateManager
import h.car2.util.AssetsDescription
import h.car2.util.Timer
import h.car2.util.near
import ktx.scene2d.Scene2DSkin
import ktx.scene2d.label
import ktx.scene2d.table

class Load : State {

	private lateinit var lab: Label

	override val layout = table {


		Scene2DSkin.defaultSkin = Skin()
				.apply {
					val fontStyle = Label.LabelStyle(BitmapFont(), Color.WHITE)
					add("default", fontStyle)
				}

		setFillParent(true)


		label("Loading").inCell.expandX()


		row()


		lab = label("%0")

	}

	//	private val timer = Timer(.2f)
	private var progress = 0f

	override fun update(delta: Float) {

//		timer.update(delta) {
		if (assets.load() && progress == 1f) {


			Scene2DSkin.defaultSkin = assets.assetManager[AssetsDescription.skin]

			with(stateManager) {

				add(Menu())
				add(Start())
				add(Play())
				add(Pause())
				add(PreOver())
				add(Over())

				set<Menu>()

			}

			stateManager.remove<Load>()



//			timer.stop()
		} else {
			progress = MathUtils.lerp(progress, assets.assetManager.progress, .2f)

			progress = near(progress, 1f, .1f)
			progress = MathUtils.clamp(progress, 0f, 1f)

			val value = (progress * 100).toInt()
			lab.setText("%$value")

		}
//		}

	}

}