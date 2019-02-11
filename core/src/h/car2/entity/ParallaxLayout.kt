package h.car2.entity

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.*
import ktx.log.debug

class ParallaxLayout(private val layer: TextureRegion) {


	private var scroll = Vector2()

	internal val speed = Vector2()

	internal val position = Vector2()
	internal val dimension = Dimension()

	internal var overlap = Overlap()

	internal val width get() = layer.regionWidth.toFloat()
	internal val height get() = layer.regionHeight.toFloat()


	private var minX = 0f
	private var maxX = 0f

	private var minY = 0f
	private var maxY = 0f

	init {
		apply()
	}

	fun apply(function: ParallaxLayout.() -> Unit): ParallaxLayout {

		function()

		apply()

		return this
	}

	fun apply() {

		minX = run {
			var x = position.x

			if (overlap.left)
				x = -width - 10f

			x
		}
		maxX = run {
			var x = position.x + dimension.width

			if (overlap.right)
				x += width

			x
		}


		minY = run {
			var y = position.y

			if (overlap.down)
				y = -height - 10f

			y
		}
		maxY = run {

			var y = position.y + dimension.height

			if (overlap.top)
				y += height

			y
		}

	}

	fun update(delta: Float) {

		scroll.add(speed.scl(delta))

		speed.scl(1 / delta)
	}


	fun draw(batch: Batch) {


		val minx = minX + scroll.x
		val miny = minY + scroll.y


		var x = minx
		var y = miny



		while (x <= maxX) {
			while (y <= maxY) {


				batch.draw(layer, x, y)

				y += height
			}

			y = miny
			x += width
		}


		if (scroll.y % height == 0f)
			scroll.y = 0f

		if (scroll.x % width == 0f)
			scroll.x = 0f

	}

}

data class Dimension(var width: Float = 0f, var height: Float = 0f) {


	/** Sets the components of this Dimension
	 * @param widht The x-component
	 * @param height The y-component
	 * @return This Dimension for chaining
	 */
	fun set(width: Float, height: Float): Dimension {
		this.width = width
		this.height = height
		return this
	}
}


class Overlap {


	var x = true
	var y = true

	var top = true
	var down = true
	var right = true
	var left = true


	constructor(x: Boolean = true, y: Boolean = true) {
		if (!x) {
			left = false
			right = false
		}

		this.x = x

		if (!y) {
			top = false
			down = false
		}

		this.y = y
	}

	constructor(top: Boolean = true,
	            down: Boolean = true,
	            left: Boolean = true,
	            right: Boolean = true) {

		this.top = top
		this.down = down
		this.left = left
		this.right = right

	}


	fun x(value: Boolean) {
		left = value
		right = value

		x = value
	}

	fun y(value: Boolean) {
		top = value
		down = value

		y = value
	}

	fun top(value: Boolean) {
		x = value == down

		top = value
	}

	fun down(value: Boolean) {
		x = value == top

		down = value
	}

	fun right(value: Boolean) {
		y = value == left

		right = value
	}

	fun left(value: Boolean) {
		y = value == right

		left = value
	}

	/** Sets the components of this Overlap
	 * @param x The x-component
	 * @param y The y-component
	 * @return This Overlap for chaining
	 */
	fun set(x: Boolean = true, y: Boolean = true): Overlap {
		this.x = x
		this.y = y

		set(y, y, x, x)

		return this
	}


	fun set(top: Boolean = true,
	        down: Boolean = true,
	        left: Boolean = true,
	        right: Boolean = true): Overlap {

		if (!(left && right))
			x = false

		if (!(top && down))
			y = false


		this.top = top
		this.down = down
		this.left = left
		this.right = right

		return this
	}
}