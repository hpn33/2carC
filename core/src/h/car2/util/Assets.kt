package h.car2.util

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.graphics.g2d.TextureAtlas


object AssetsPath {
	val atlas = "2carC.atlas"
}

object AssetsDescription {
	val atlas = AssetDescriptor(AssetsPath.atlas, TextureAtlas::class.java)
}

object RegionName {
	val blockBlue = "block-blue"
	val blockRed = "block-red"
	val carBlue = "car-blue"
	val carRed = "car-red"
	val coinBlue = "coin-blue"
	val coinRed = "coin-red"
	val lineCenterStreet = "l-c-s"
	val lineCenter1 = "l-c1"
	val lineCenter2 = "l-c2"
	val street = "street"
}