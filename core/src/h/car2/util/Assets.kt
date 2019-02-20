package h.car2.util

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin


object AssetsPath {
	const val atlass = "2carC.atlas"
	const val atlas = "2cars-bw.atlas"
	const val skin = "skin/uiskin.json"

	const val music = "audio/music.mp3"
	const val coin = "audio/coin.ogg"
	const val block = "audio/block.ogg"
}

object AssetsDescription {
	val atlas = AssetDescriptor(AssetsPath.atlas, TextureAtlas::class.java)
	val skin = AssetDescriptor(AssetsPath.skin, Skin::class.java)

	val music = AssetDescriptor(AssetsPath.music, Music::class.java)
	val coin = AssetDescriptor(AssetsPath.coin, Sound::class.java)
	val block = AssetDescriptor(AssetsPath.block, Sound::class.java)
}

object RegionName {
	const val blockBlue = "block-blue"
	const val blockRed = "block-red"
	const val carBlue = "player-blue"
	const val carRed = "player-red"
	const val coinBlue = "coin-blue"
	const val coinRed = "coin-red"
	const val lineCenterStreet = "l-c-s"
	const val lineCenter1 = "l-c1"
	const val lineCenter2 = "l-c2"
	const val street = "street"

	const val block = "block"
	const val coin = "coin"

	const val rightP = "black"
	const val leftP = "white"

	const val lineC = "linec"

	const val line = "line"
	const val lineC1 = "line-c1"
	const val lineC2 = "line-c2"
	const val lineC3 = "line-c3"
	const val lineC4 = "line-c4"

}