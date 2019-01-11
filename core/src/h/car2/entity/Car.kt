package h.car2.entity

import com.badlogic.gdx.Input
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import h.car2.util.*

class Car(private val side: CarSide) {


	private lateinit var sprite: Sprite

	private val rectangle get() = sprite.boundingRectangle

	private var current = side.firstLine

	private var xTarget = 0f
	private var rotate = 0f

	init {

	}

	fun start() {

		sprite = Sprite(side.getTexture())
		sprite.y = wHeight / 9f

		xTarget = sprite.regionWidth centerOfLine side.firstLine
		sprite.x = xTarget

	}

	fun update(delta: Float) {
		if (side is CarSide.Right)
			if (keyJust(Input.Keys.D) || keyJust(Input.Keys.RIGHT))
				changePos()
		if (side is CarSide.Left)
			if (keyJust(Input.Keys.A) || keyJust(Input.Keys.LEFT))
				changePos()

		sprite.x = MathUtils.lerp(sprite.x, xTarget, 6 * delta)
		sprite.x = near(sprite.x, xTarget, .2f)


		if (sprite.x > xTarget && sprite.x < xTarget + halfLine) rotate = 0f
		if (sprite.x < xTarget && sprite.x > xTarget - halfLine) rotate = 0f

		sprite.rotation = MathUtils.lerp(sprite.rotation, rotate, 5 * delta)
		sprite.rotation = near(sprite.rotation, rotate, 2f)


	}

	fun draw(batch: Batch) = sprite.draw(batch)


	fun changePos() {
		current =
				if (current == side.lines.first)
					side.lines.second
				else
					side.lines.first


		xTarget = sprite.regionWidth centerOfLine current

		rotate = if (xTarget > sprite.x) -45f else 45f

	}

}


sealed class CarSide(private val assetManager: AssetManager) {

	abstract val firstLine: Int
	abstract val lines: Pair<Int, Int>
	abstract val textureName: String

	fun getTexture() = assetManager.atlas(textureName)


	class Right(assetManager: AssetManager) : CarSide(assetManager) {
		override val firstLine = 4
		override val lines = 3 to 4
		override val textureName = RegionName.carRed
	}

	class Left(assetManager: AssetManager) : CarSide(assetManager) {
		override val firstLine = 1
		override val lines = 1 to 2
		override val textureName = RegionName.carBlue
	}

}