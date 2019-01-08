package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

import h.car2.Game
import h.car2.wHeight
import h.car2.wWidth

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
				.apply {
					width = wWidth.toInt()
					height = wHeight.toInt()
				}
		LwjglApplication(Game(), config)
	}
}
