package h.car2.util


const val lineWidth = ww / 4

const val halfLine = lineWidth / 2


fun linePos(index: Int) = index * lineWidth


infix fun Number.centerOfLine(index: Int) =
		linePos(index - 1) + halfLine - half()


infix fun Number.linePosition(index: Int) = linePos(index) - half()

fun Number.half() = toFloat() / 2f
