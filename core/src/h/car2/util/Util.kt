package h.car2.util

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager

val isMobile = Gdx.app.type == Application.ApplicationType.Android
		|| Gdx.app.type == Application.ApplicationType.iOS

fun AssetManager.atlas(regionName: String) =
		get(AssetsDescription.atlas).findRegion(regionName)!!

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