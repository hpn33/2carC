package h.car2.util

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin


object AssetsPath {
	const val atlas = "2carC.atlas"
	const val skin = "skin/uiskin.json"
}

object AssetsDescription {
	val atlas = AssetDescriptor(AssetsPath.atlas, TextureAtlas::class.java)
	val skin = AssetDescriptor(AssetsPath.skin, Skin::class.java)
}

object RegionName {
	const val blockBlue = "block-blue"
	const val blockRed = "block-red"
	const val carBlue = "car-blue"
	const val carRed = "car-red"
	const val coinBlue = "coin-blue"
	const val coinRed = "coin-red"
	const val lineCenterStreet = "l-c-s"
	const val lineCenter1 = "l-c1"
	const val lineCenter2 = "l-c2"
	const val street = "street"
}