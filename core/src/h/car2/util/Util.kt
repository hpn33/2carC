package h.car2.util

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import h.car2.screen.Assets

val isMobile = Gdx.app.type == Application.ApplicationType.Android
		|| Gdx.app.type == Application.ApplicationType.iOS


fun keyJust(key: Int) = Gdx.input.isKeyJustPressed(key)
fun key(key: Int) = Gdx.input.isKeyPressed(key)

fun near(current: Float, target: Float, offSet: Float): Float {

	val more: Float
	val less: Float


	if (target >= 0) {
		more = target + offSet
		less = target - offSet
	} else {
		more = target - offSet
		less = target + offSet
	}


	return if (current in less..more)
		target
	else
		current

}

fun downWith(number: Int, function: (Int) -> Unit) {

	(number - 1 downTo 0).forEach(function)
}