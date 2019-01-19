package h.car2.entity

import com.badlogic.gdx.scenes.scene2d.ui.*
import ktx.scene2d.*
import ktx.scene2d.KTableWidget


public class TouchArea : Widget()


inline fun <S> KWidget<S>.touchArea(
		init: (@Scene2dDsl TouchArea).(S) -> Unit = {}) =
		actor(TouchArea(), init)