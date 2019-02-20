package h.car2.entity

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Polygon
import h.car2.screen.PlayScreen.Companion.renderer
import h.car2.util.*

class Player(private val side: Side) : Sprite() {


	private var current = side.firstLine

	private var xTarget = 0f
	private var rotate = 0f

	internal val bound = Polygon()

	private val scale = 1


	fun load() {

		val region = side.playerTexture

		setRegion(region)
		setColor(1f, 1f, 1f, 1f)
		setSize(region.regionWidth.toFloat(), region.regionHeight.toFloat())
		setOrigin(width / 2, height / 2)

		start()
	}


	fun start() {

		y = wh / 9f

		current = side.firstLine

		xTarget = regionWidth centerOfLine current
		x = xTarget

		rotate = 0f
		rotation = 0f


		bound.vertices = arrayOf(0f, 0f,
				0f, height,
				width, height,
				width, 0f).toFloatArray()
		bound.setPosition(x, y)
		bound.rotation = 0f

	}

	fun update(delta: Float) {

		if (side is Side.Right)
			if (keyJust(Input.Keys.D) || keyJust(Input.Keys.RIGHT))
				changePosition()
		if (side is Side.Left)
			if (keyJust(Input.Keys.A) || keyJust(Input.Keys.LEFT))
				changePosition()

		x = MathUtils.lerp(x, xTarget, 8 * delta)
		x = near(x, xTarget, .2f)


		if (x > xTarget && x < xTarget + halfLine) rotate = 0f
		if (x < xTarget && x > xTarget - halfLine) rotate = 0f

		rotation = MathUtils.lerp(rotation, rotate, 8 * delta)
		rotation = near(rotation, rotate, 2f)

		bound.setPosition(x, y)
		bound.rotation = rotation
	}


	internal fun changePosition() {
		current =
				if (current == side.lines.first)
					side.lines.second
				else
					side.lines.first


		xTarget = regionWidth centerOfLine current

		rotate = if (xTarget > x) -45f else 45f

	}

	override fun draw(batch: Batch?) {
		super.draw(batch)

		renderer.draw(bound.transformedVertices)

	}

}