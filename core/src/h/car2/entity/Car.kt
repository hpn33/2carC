package h.car2.entity

import com.badlogic.gdx.Input
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import h.car2.util.*

class Car(private val side: CarSide) : Sprite() {


	private var current = side.firstLine

	private var xTarget = 0f
	private var rotate = 0f


	fun start() {


		val region = side.getTexture()

		setRegion(region)
		setColor(1f, 1f, 1f, 1f)
		setSize(region.regionWidth.toFloat(), region.regionHeight.toFloat())
		setOrigin(width / 2, height / 2)

		y = wHeight / 9f

		xTarget = regionWidth centerOfLine side.firstLine
		x = xTarget

	}

	fun update(delta: Float) {
		if (side is CarSide.Right)
			if (keyJust(Input.Keys.D) || keyJust(Input.Keys.RIGHT))
				changePosition()
		if (side is CarSide.Left)
			if (keyJust(Input.Keys.A) || keyJust(Input.Keys.LEFT))
				changePosition()

		x = MathUtils.lerp(x, xTarget, 6 * delta)
		x = near(x, xTarget, .2f)


		if (x > xTarget && x < xTarget + halfLine) rotate = 0f
		if (x < xTarget && x > xTarget - halfLine) rotate = 0f

		rotation = MathUtils.lerp(rotation, rotate, 5 * delta)
		rotation = near(rotation, rotate, 2f)


	}


	private fun changePosition() {
		current =
				if (current == side.lines.first)
					side.lines.second
				else
					side.lines.first


		xTarget = regionWidth centerOfLine current

		rotate = if (xTarget > x) -45f else 45f

	}

}


sealed class CarSide(private val assetManager: AssetManager) {

	abstract val firstLine: Int
	abstract val lines: Pair<Int, Int>
	abstract val textureName: String

	fun getTexture() = assetManager.atlas(textureName)


	class Right(assetManager: AssetManager) : CarSide(assetManager) {
		override val firstLine = 4
		override val lines = LinesRight.lines
		override val textureName = RegionName.carRed
	}

	class Left(assetManager: AssetManager) : CarSide(assetManager) {
		override val firstLine = 1
		override val lines = LinesLeft.lines
		override val textureName = RegionName.carBlue
	}

}