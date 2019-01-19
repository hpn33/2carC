package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

import h.car2.Game
import h.car2.util.wh
import h.car2.util.ww

object DesktopLauncher {
	@JvmStatic
	fun main(arg: Array<String>) {
		val config = LwjglApplicationConfiguration()
				.apply {
					width = (ww.toInt() * 5)
					height = (wh.toInt() * 5).toInt()
				}
		LwjglApplication(Game(), config)
	}
}
