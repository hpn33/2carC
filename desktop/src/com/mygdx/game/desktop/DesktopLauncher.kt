package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

import h.car2.Game
import h.car2.util.wHeight
import h.car2.util.wWidth

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
				.apply {
					width = (wWidth * 1.7).toInt()
					height = (wHeight * 1.7).toInt()
				}
		LwjglApplication(Game(), config)
	}
}
