package h.car2.util

import com.badlogic.gdx.Gdx
import h.car2.screen.Assets
import ktx.inject.Context
import kotlin.properties.Delegates

class Setting(context: Context) {

	private val assets = context<Assets>()

	object Key {
		const val music = "music"
		const val sound = "sound"
	}

	private val preferences by lazy { Gdx.app.getPreferences("h.2cars")!! }

	var music by Delegates.observable(true) { _, _, n ->
		preferences.putBoolean(Setting.Key.music, n).flush()

		if (assets.manager.isLoaded(AssetsDescription.music))
			if (!n && assets[AssetsDescription.music].isPlaying)
				assets[AssetsDescription.music].stop()
			else
				assets[AssetsDescription.music].play()
	}
	var sound by Delegates.observable(true) { _, _, n ->
		preferences.putBoolean(Setting.Key.sound, n).flush()
	}

	fun load() {

		music = preferences.getBoolean("music", true)
		sound = preferences.getBoolean("sound", true)

	}
}