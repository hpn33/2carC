package h.car2.screen.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import h.car2.screen.Assets
import ktx.scene2d.KTableWidget
import ktx.scene2d.Scene2DSkin
import ktx.scene2d.label
import ktx.scene2d.table

sealed class Stage {
	abstract val layout: KTableWidget

	abstract fun update(delta: Float)
}


class Load : Stage() {

	override val layout = table {


		Scene2DSkin.defaultSkin = Skin()
				.apply {
					val fontStyle = Label.LabelStyle(BitmapFont(), Color.WHITE)
					add("default", fontStyle)
				}

		setFillParent(true)


		label("Loading").inCell.expandX()

	}


	override fun update(delta: Float) {}

}

class Menu(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}
class Start(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}

class Play(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}


class Pause(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}


class PreOver(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}


class Over(assets: Assets) {

	val layout = table {}

	fun update(delta: Float) {}

}
