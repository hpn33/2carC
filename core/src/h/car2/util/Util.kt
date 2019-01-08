package h.car2.util

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx

val isMobile = Gdx.app.type == Application.ApplicationType.Android
		|| Gdx.app.type == Application.ApplicationType.iOS