package h.car2.screen.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import h.car2.screen.Assets
import h.car2.util.AssetsDescription
import h.car2.util.near
import ktx.inject.Context
import ktx.scene2d.Scene2DSkin
import ktx.scene2d.label
import ktx.scene2d.table

class Load(private val context: Context) : State {

	private val assets  = context<Assets>()
	private val stateManager = context<StateManager<State>>()

	private lateinit var lab: Label

	override val layout = table {


		Scene2DSkin.defaultSkin = Skin()
				.apply {
					val fontStyle = Label.LabelStyle(BitmapFont(), Color.GRAY)
					add("default", fontStyle)
				}

		setFillParent(true)


		label("Loading").inCell.expandX()


		row()


		lab = label("%0")

	}

	private var progress = 0f

	override fun load() = assets.load()


	override fun update(delta: Float) {

		if (assets.update() && progress == 1f) {


			Scene2DSkin.defaultSkin = assets[AssetsDescription.skin]
					.apply {
						val font = getFont("default-font")
								.apply { color = Color.GRAY }
//						val fontStyle = Label.LabelStyle(font, Color.GRAY)
						add("default-font", font)
//						add("default", fontStyle)
					}

			with(stateManager) {

				add(Menu(context))
				add(Start(context))
				add(Play(context))
				add(Pause(context))
				add(PreOver(context))
				add(Over(context))

				set<Menu>()

			}

			stateManager.remove<Load>()


		} else {
			progress = MathUtils.lerp(progress, assets.manager.progress, .2f)

			progress = near(progress, 1f, .1f)
			progress = MathUtils.clamp(progress, 0f, 1f)

			val value = (progress * 100).toInt()
			lab.setText("%$value")

		}

	}

}